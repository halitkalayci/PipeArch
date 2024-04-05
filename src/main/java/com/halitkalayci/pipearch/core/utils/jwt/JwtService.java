package com.halitkalayci.pipearch.core.utils.jwt;

import an.awesome.pipelinr.repack.org.checkerframework.checker.units.qual.A;
import com.halitkalayci.pipearch.core.security.dtos.AccessToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService
{
  @Value("${jwt.key}")
  private String SECRET_KEY;
  @Value("${jwt.expiration}")
  private long EXPIRATION;

  // Boilerplate => Basmakalıp
  public AccessToken generateToken(String userName) {
    Map<String,Object> claims = new HashMap<>();
    return createToken(claims,userName);
  }
  public AccessToken generateToken(String userName, Map<String,Object> claims) {
    return createToken(claims, userName);
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    String username = extractUser(token);
    Date expirationDate = extractExpiration(token);
    return userDetails.getUsername().equals(username) && !expirationDate.before(new Date());
  }

  private Date extractExpiration(String token) {
    Claims claims = Jwts
            .parser()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    return claims.getExpiration();
  }
  public String extractUser(String token) {
    Claims claims = Jwts
            .parser()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    return claims.getSubject();
  }
  // 10:15
  private AccessToken createToken(Map<String, Object> claims, String userName) {
    Date expiration = new Date(System.currentTimeMillis() + EXPIRATION);
    String jwt = Jwts.builder()
            .setClaims(claims)
            .setSubject(userName)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(expiration)
            .signWith(getSignKey(), SignatureAlgorithm.HS256)
            .compact();
    return new AccessToken(jwt, expiration);
  }


  private Key getSignKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
