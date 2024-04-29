package com.rihab.interventions.entities;

public class AuthenticationResponse {
   private String token;
    private String message;
    private Role role;

    public AuthenticationResponse(String token, String message, Role role) {
    	this.role=role;
       this.token = token;
        this.message = message;
    }

   
	public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
    
    public Role getRole() {
        return role;
    }

}