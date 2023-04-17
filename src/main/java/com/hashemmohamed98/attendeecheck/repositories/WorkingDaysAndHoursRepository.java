/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hashemmohamed98.attendeecheck.repositories;

import com.hashemmohamed98.attendeecheck.domain.WorkingDaysAndHours;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author #EM
 */
public interface WorkingDaysAndHoursRepository extends JpaRepository<WorkingDaysAndHours, Integer>{
    
}
