/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashemmohamed98.attendeecheck.services;

import com.hashemmohamed98.attendeecheck.domain.Attendance;
import com.hashemmohamed98.attendeecheck.domain.AttendanceStatus;
import com.hashemmohamed98.attendeecheck.domain.AttendanceType;
import com.hashemmohamed98.attendeecheck.domain.Day;
import com.hashemmohamed98.attendeecheck.domain.Season;
import com.hashemmohamed98.attendeecheck.domain.WorkingDay;
import com.hashemmohamed98.attendeecheck.domain.security.User;
import com.hashemmohamed98.attendeecheck.repositories.AttendanceRepository;
import com.hashemmohamed98.attendeecheck.repositories.SeasonRepository;
import com.hashemmohamed98.attendeecheck.repositories.security.UserRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author #EM
 */
@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final SeasonRepository seasonRepository;
    private final UserRepository userRepository;
    private final AttendanceRepository attendanceRepository;

    public Attendance constructAttendance(AttendanceType type) {
        Attendance attendance = Attendance.builder().build();
        attendance.setType(type);
        attendance.setStatus(AttendanceStatus.Late);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        DateFormat formatter = new SimpleDateFormat("EEEE");

        String dayOfWeekString = formatter.format(calendar.getTime());
        Day day = Day.valueOf(dayOfWeekString);
        Season seasons = seasonRepository.findAllBySeasonStartDateLessThanEqualAndSeasonEndDateGreaterThanEqual(calendar.getTime(), calendar.getTime());
        List<WorkingDay> workingDays = seasons.getWorkingDays();

        if (type == AttendanceType.Checkin) {

            workingDays.stream().filter(workingDay -> (workingDay.getDayOfWeek() == day))
                    .map(workingDay -> {
                        attendance.setStatus(
                                getAttendanceStatus(workingDay
                                        .getWorkingHours()
                                        .getOpenTime()
                                )
                        );

                        return workingDay;
                    })
                    .forEachOrdered(workingDay -> {
                        attendance.setWorkingDay(workingDay);
                    });

            return attendance;
        } else {

            workingDays.stream().filter(workingDay -> (workingDay.getDayOfWeek() == day))
                    .map(workingDay -> {
                        attendance.setStatus(
                                getAttendanceStatus(workingDay
                                        .getWorkingHours()
                                        .getCloseTime()
                                )
                        );

                        return workingDay;
                    })
                    .forEachOrdered(workingDay -> {
                        attendance.setWorkingDay(workingDay);
                    });

            return attendance;
        }

    }

    public AttendanceStatus getAttendanceStatus(java.sql.Time time) {
        LocalTime now = LocalTime.now();

            
             LocalTime ShiftTime = time
                .toLocalTime()
                .plus(Duration
                        .ofMinutes(10));
        if (now.isAfter(ShiftTime)) {
            return AttendanceStatus.Late;

        } else if (now.isBefore(time.toLocalTime())) {
            return AttendanceStatus.Early;
        } else {
            return AttendanceStatus.Ontime;
        }
        
  
    }
    

    public void saveAttendance(Attendance attendance) {
        AttendanceStatus status = getAttendanceStatus(attendance.getWorkingDay().getWorkingHours().getOpenTime());
        attendance.setUser(userRepository.getById(2));
        System.out.println("Username = " + attendance.getUser().getUsername());
        if (attendance.getStatus() != status) {
            attendance.setStatus(status);
            //Validation to Avoid User Changing Attendance Status From Form
        }
        attendance.setAttendanceDate(java.time.LocalDate.now());
        attendanceRepository.save(attendance);
    }

    public Attendance checkTodaysAttendance(AttendanceType type) {
        User user = userRepository.getById(2);
        Attendance attendance = attendanceRepository.findByUserIdAndAttendanceDateAndType(user.getId(), java.time.LocalDate.now(),type);

        return attendance;
    }
}
