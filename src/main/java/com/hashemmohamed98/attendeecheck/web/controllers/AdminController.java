/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashemmohamed98.attendeecheck.web.controllers;

import com.hashemmohamed98.attendeecheck.domain.security.Role;
import com.hashemmohamed98.attendeecheck.domain.security.User;
import com.hashemmohamed98.attendeecheck.repositories.security.RoleRepository;
import com.hashemmohamed98.attendeecheck.repositories.security.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
   @GetMapping("/employees")
   public String employeesConfig( Model model){ 
       
       List <User> users= userRepository.findAll();
       model.addAttribute("employees", users);
       return "admin/employees";
   } 
   @GetMapping("/employee/add")
   public String employeeInitCreationForm(Model model){ 
       
       model.addAttribute("employee", User.builder().build());
       return "admin/addEmployee";
   }     
   
      @PostMapping("/employee/add")
   public String employeeProcessCreationForm(User user){ 
               Role role= roleRepository.findByName("USER");
       User userToSave= User.builder().username(user.getUsername())
               .name(user.getName())
               .password(user.getPassword())
               .startDate(user.getStartDate())
               .role(role)
               .build();
       
        userRepository.save(userToSave);
       return "redirect:/administration/employees";
   }     
}
