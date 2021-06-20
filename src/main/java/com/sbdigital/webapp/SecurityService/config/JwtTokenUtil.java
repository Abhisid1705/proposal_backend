package com.sbdigital.webapp.SecurityService.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    @Value("${app.jwtSecret}")
    private String secret;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return doGenerateToken(claims ,userDetails.getUsername() );
    }

    private String doGenerateToken(Map<String,Object> claims , String subject) {

        Date currDate = new Date(System.currentTimeMillis());
        Date ExpDate = new Date(System.currentTimeMillis() + 1800000);

        return Jwts.builder().
                setClaims(claims).
                setSubject(subject).
                setIssuedAt(currDate).
                setExpiration(ExpDate).
                signWith(SignatureAlgorithm.HS512 , secret).
                compact();
    }

    public Boolean validateToken(String token , UserDetails userDetails){
        final String userName = getUserNameFromToken(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public  String getUserNameFromToken(String token) {
        return getClaimFromToken(token , Claims::getSubject);
    }

    private <T> T getClaimFromToken(String token, Function<Claims , T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

}
