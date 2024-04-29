package com.rihab.interventions.register;

import com.rihab.interventions.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RegisterRequest {
	private String nom;
    private String prenom;
    private String email;
    private Role role;
}
