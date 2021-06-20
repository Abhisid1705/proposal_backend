package com.sbdigital.webapp.SecurityService.Service;

import com.sbdigital.webapp.SecurityService.Domain.User;
import com.sbdigital.webapp.SecurityService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;


public interface CustomUserDetailsService extends UserDetailsService {

    UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException;


}
