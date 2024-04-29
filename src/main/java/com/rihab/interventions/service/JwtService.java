package com.rihab.interventions.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Role;
import com.rihab.interventions.entities.User;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY = "4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";
  //  private final TokenRepository tokenRepository;
/*
    public JwtService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
*/
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }


   public boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);

        //boolean validToken = tokenRepository
          //      .findByToken(token)
            //    .map(t -> !t.isLoggedOut())
              //  .orElse(false);

        return (username.equals(user.getUsername())) && !isTokenExpired(token) ;
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public String generateToken(User user) {
        String token = Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24*60*60*1000 ))
                .signWith(getSigninKey())
                .compact();

        return token;
    }

    private SecretKey getSigninKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String generateTokenWithRole(UserDetails userDetails, Role role) {
        String token = Jwts
                .builder()
                .claim("role", role) // Ajouter le rôle comme une revendication (claim) dans le JWT
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }


}