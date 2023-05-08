/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashemmohamed98.attendeecheck.web.controllers;

import com.hashemmohamed98.attendeecheck.domain.Attendance;
import com.hashemmohamed98.attendeecheck.domain.AttendanceType;
import com.hashemmohamed98.attendeecheck.services.AttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;   

/**
 *
 * @author #EM
 */
@Slf4j
@RequestMapping("/attendance")
@Controller
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendenceService;

    @GetMapping("/history")
    public String a() {

        return "attendance/attendance";
    }

    @GetMapping("/checkin")
    public String attendanceCheckIn(Model model) {
        AttendanceType type = AttendanceType.Checkin;
        if (attendenceService.checkTodaysAttendance(type) != null) {
            return "attendance/attendanceSuccess";
        } else {
            model.addAttribute("attendance", attendenceService.constructAttendance(type));

            return "attendance/addCheckIn";
        }
    }

    @PostMapping("/checkin")
    public String saveAttendanceCheckIn(Attendance attendance) {

        attendenceService.saveAttendance(attendance);
        return "attendance/attendanceSuccess";

    }

    @GetMapping("/checkout")
    public String attendanceCheckout(Model model) {
        AttendanceType type = AttendanceType.Checkout;
        if (attendenceService.checkTodaysAttendance(type) != null) {
            return "attendance/attendanceSuccess";
        } else {
            model.addAttribute("attendance", attendenceService.constructAttendance(type));

            return "attendance/addCheckout";
        }
    }

    @PostMapping("/checkout")
    public String saveAttendanceCheckout(Attendance attendance) {

        attendenceService.saveAttendance(attendance);
        return "attendance/attendanceSuccess";

    }

}
