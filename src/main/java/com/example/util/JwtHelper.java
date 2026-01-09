package com.example.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JwtHelper {

    private static final String SECRET =
            "my-super-secret-key-my-super-secret-key";

    private static final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    private static final int MINUTES = 60;

    public static String generateToken(String emailId) {
        Instant now = Instant.now();
        return Jwts.builder()
                .subject(emailId)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(MINUTES, ChronoUnit.MINUTES)))
                .signWith(SECRET_KEY) // HS256 auto-selected
                .compact();
    }


    public static String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public static boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    private static Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }
        catch (ExpiredJwtException e) {
            throw new RuntimeException("JWT expired");
        }
        catch (SignatureException e) {
            throw new RuntimeException("Invalid JWT signature");
        }
        catch (Exception e) {
            throw new RuntimeException("Invalid JWT token");
        }
    }

    private static boolean isTokenExpired(String token) {
        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }
}
