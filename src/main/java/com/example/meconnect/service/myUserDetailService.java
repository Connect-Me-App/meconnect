package com.example.meconnect.service;

import com.example.meconnect.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.meConnect2.meConnect2.entity.Usersentity;

@Service
public class myUserDetailService implements UserDetailsService {

    @Autowired
    Usersserviceimpl usersServiceimpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usersEntity = usersServiceimpl.getUserByUserName(username);
        if (usersEntity == null) {
            throw new UsernameNotFoundException("username not present in databae " + username);
        }

        return new myUserDetails(usersEntity);
        //return new User("foo","foo",new ArrayList<>());
    }

}
