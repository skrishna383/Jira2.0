package com.skrishna383.jira2.service;

import com.skrishna383.jira2.dao.UsersDao;
import com.skrishna383.jira2.model.MyUserDetails;
import com.skrishna383.jira2.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UsersDao usersDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> user  = usersDao.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("not found"+userName));
        return  user.map(MyUserDetails::new).get();


    }
}
