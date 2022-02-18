package com.example.meconnect.controller;

import com.example.meconnect.entity.User;
import com.example.meconnect.entity.VerificationToken;
import com.example.meconnect.model.AuthenticateRequest;
import com.example.meconnect.model.AuthenticationResponse;
import com.example.meconnect.model.Users;
import com.example.meconnect.service.Usersservice;
import com.example.meconnect.service.Usersserviceimpl;
import com.example.meconnect.service.myUserDetailService;
import com.example.meconnect.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

//import com.meConnect2.meConnect2.entity.Usersentity;
//import com.meConnect2.meConnect2.model.AuthenticateRequest;
//import com.meConnect2.meConnect2.model.AuthenticationResponse;
//import com.meConnect2.meConnect2.model.Users;
//import com.meConnect2.meConnect2.service.Usersservice;
//import com.meConnect2.meConnect2.serviceImpl.myUserDetailService;
//import com.meConnect2.meConnect2.util.JwtUtil;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private myUserDetailService userDetailsService;

    @Autowired
    private Usersservice usersService;

    @Autowired
    private Usersserviceimpl usersserviceimpl;


    @Autowired
    private JwtUtil jwtUtil;

    //	@PostMapping("/authenticate")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticationRequest) throws Exception {

        System.out.print(authenticationRequest.getUsername());

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect password", e);
        }


        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);


        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        System.out.print(user);
        //return ResponseEntity.ok(usersService.saveUser(user));
        return new ResponseEntity<>(usersService.saveUser(user), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/getalluser", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(usersService.getUser());
    }


    @RequestMapping(value = "/deleteuserbyid/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteuser(@PathVariable Long id) {
        User userEntity = usersService.getUser(id);

        if (userEntity == null) {
            return new ResponseEntity<>("user with particular " + id + "notfound", HttpStatus.NOT_FOUND);
        }
        usersService.deleteUser(id);
        return new ResponseEntity<>("user with particular id Delete succesfuly ", HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateuser(@PathVariable Long id, @RequestBody Users user) {
        User userEntity = usersService.getUser(id);

        if (userEntity == null) {
            return new ResponseEntity<>("user with particular " + id + "notfound", HttpStatus.NOT_FOUND);
        }
        usersService.updateuser(user, id);

        return ResponseEntity.ok(userEntity);
    }



    @GetMapping("/auccountToken/{token}")
    public ResponseEntity<?> verifyUser(@PathVariable String token){

        String username= SecurityContextHolder.getContext().getAuthentication().getName();

//        System.out.println("*__________***** "+username+" ****************");


        VerificationToken verifi= usersserviceimpl.verification(token);
              if(verifi==null){
                  return new ResponseEntity<>("user verify fail please enter right token ",HttpStatus.NOT_FOUND);
              }
        return new ResponseEntity<>("user verify succesfully ",HttpStatus.OK);
    }



}
