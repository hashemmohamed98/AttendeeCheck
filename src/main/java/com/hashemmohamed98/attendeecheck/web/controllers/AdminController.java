/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashemmohamed98.attendeecheck.web.controllers;

import com.hashemmohamed98.attendeecheck.domain.Season;
import com.hashemmohamed98.attendeecheck.domain.WorkingDay;
import com.hashemmohamed98.attendeecheck.domain.WorkingHours;
import com.hashemmohamed98.attendeecheck.domain.security.Role;
import com.hashemmohamed98.attendeecheck.domain.security.User;
import com.hashemmohamed98.attendeecheck.repositories.SeasonRepository;
import com.hashemmohamed98.attendeecheck.repositories.WorkingDaysRepository;
import com.hashemmohamed98.attendeecheck.repositories.WorkingHoursRepository;
import com.hashemmohamed98.attendeecheck.repositories.security.RoleRepository;
import com.hashemmohamed98.attendeecheck.repositories.security.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author #EM
 */
@Slf4j
@RequestMapping("/administration")
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SeasonRepository seasonRepository;
    private final WorkingDaysRepository workingDaysRepository;
    private final WorkingHoursRepository workingHoursRepository;

    @GetMapping("/employees")
    public String employeesConfig(Model model) {

        List<User> users = userRepository.findAll();
        model.addAttribute("employees", users);
        return "admin/employees";
    }

    @GetMapping("/employee/add")
    public String employeeInitCreationForm(Model model) {

        model.addAttribute("employee", User.builder().build());
        return "admin/addEmployee";
    }

    @PostMapping("/employee/add")
    public String employeeProcessCreationForm(User user) {
        Role role = roleRepository.findByName("USER");
        User userToSave = User.builder().username(user.getUsername())
                .name(user.getName())
                .password(user.getPassword())
                .startDate(user.getStartDate())
                .role(role)
                .build();

        userRepository.save(userToSave);
        return "redirect:/administration/employees";
    }

    @PostMapping("/employee/edit")
    public String initUpdateEmployeeForm(User user) {

        User oldDetailsUser = userRepository.getById(user.getId());
        if (user instanceof User) {

            if (user.getPassword().equals("")) {
                user.setPassword(oldDetailsUser.getPassword());
            }
            userRepository.save(user);
            log.debug("Update Successfully");
        }

        return "redirect:/administration/employees";
    }

    @GetMapping("/seasons")
    public String seasonsConfig(Model model) {

        List<Season> seasons = seasonRepository.findAll();
        model.addAttribute("seasons", seasons);
        return "admin/seasons";
    }

    @GetMapping("/season/add")
    public String seasonInitCreationForm(Model model) {

        model.addAttribute("season", Season.builder().build());
        return "admin/addSeason";
    }

    @PostMapping("/season/add")
    public String seasonCrocessCreationForm(Season season) {

        Season newSeason = Season.builder().seasonName(season.getSeasonName())
                .seasonStartDate(season.getSeasonStartDate())
                .seasonEndDate(season.getSeasonEndDate())
                .seasonActive(season.getSeasonActive())
                .build();

        seasonRepository.save(newSeason);
        return "redirect:/administration/seasons";
    }

    @PostMapping("/season/edit")
    public String initUpdateSeasonForm(Season season) {

        seasonRepository.save(season);

        return "redirect:/administration/seasons";
    }

    @GetMapping("/workingdays")
    public String workingDAHConfig(Model model) {

    
     
        List<Season> seasons = seasonRepository.findAll();

        model.addAttribute("seasons", seasons);
        model.addAttribute("workday" ,  WorkingDay.builder().build());
        return "admin/workingDays";
    }


    @GetMapping("/workingdays/add")
    public String workingDAHInitCreationForm(Model model) {
        List<Season> seasons = seasonRepository.findAll();
        model.addAttribute("seasons", seasons);
        model.addAttribute("workdays", WorkingDay.builder().build());
        return "admin/addWorkingDays";
    }
//
    @PostMapping( "/workingdays/add")
    public String workingDAHCrocessCreationForm( @RequestBody List<WorkingDay> workingDays) {
    for(WorkingDay workingDay : workingDays){
        
        workingDay.getWorkingHours().setWorkingDay(workingDay);
  
    }
workingDaysRepository.saveAll(workingDays);

        return "redirect:/administration/workingdays";
    }


    @PostMapping("/workingdays/edit")
    public String workingDAHUpdateSeasonForm(WorkingDay workingDay) {

        if (workingDay instanceof WorkingDay ) {

            if (workingDay.getSeason() == null) {
                WorkingDay oldWorkingDay = workingDaysRepository.getById(workingDay.getDayId());
                workingDay.setSeason(oldWorkingDay.getSeason());

            }

            workingDaysRepository.save(workingDay);
            
            workingHoursRepository.save(workingDay.getWorkingHours());
        }


        return "redirect:/administration/workingdays";

    }
}
