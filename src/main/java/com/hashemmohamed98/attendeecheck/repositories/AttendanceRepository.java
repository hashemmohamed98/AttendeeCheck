/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hashemmohamed98.attendeecheck.repositories;

import com.hashemmohamed98.attendeecheck.domain.Attendance;
import com.hashemmohamed98.attendeecheck.domain.AttendanceType;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author #EM
 */
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {


    public Attendance findByUserIdAndAttendanceDateAndType(Integer id, LocalDate now, AttendanceType type);
    
}
