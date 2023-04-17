/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hashemmohamed98.attendeecheck.domain;

import com.hashemmohamed98.attendeecheck.domain.security.User;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author #EM
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "working_days_and_hours")
public class WorkingDaysAndHours {

@Id
private Integer id;
    
private Integer dayOfWeek ;

private Time openTime;

private Time closeTime; 

 @ManyToOne(fetch = FetchType.EAGER)
private Season season;
}
