/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hashemmohamed98.attendeecheck.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.hashemmohamed98.attendeecheck.domain.security.User;
/**
 *
 * @author #EM
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
