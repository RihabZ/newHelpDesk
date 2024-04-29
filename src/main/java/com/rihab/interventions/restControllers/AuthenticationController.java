package com.rihab.interventions.restControllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.dto.UserDTO;
import com.rihab.interventions.entities.AuthenticationResponse;
import com.rihab.interventions.entities.User;
import com.rihab.interventions.register.LoginRequest;
import com.rihab.interventions.service.AuthenticationService;

@RestController
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDTO request
            ) {
        return ResponseEntity.ok(authService.register(request));
    }

 /*
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestParam String login,
            @RequestParam String password
    ) {
        return ResponseEntity.ok(authService.authenticate(login, password));
    }
*/
  
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
             @RequestBody UserDTO request
    ) {
    	 return ResponseEntity.ok(authService.authenticate(request));
    }
   
    @GetMapping("/allUsers")
    public List<UserDTO> getAllUsers() {
        return authService.getAllUsers();
    }
    

 // supprimer un user
    @RequestMapping(value="/delUser/{user_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("user_id") Long userId) {
        authService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}