package eu.circletouch.users.configs;

import eu.circletouch.users.exceptions.CustomException;
import eu.circletouch.users.services.UserDetailsService;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Component
public class JwtTokenProvider {

    private final UserDetailsService userDetailsService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public JwtTokenProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new CustomException("Expired or invalid JWT token", HttpStatus.UNAUTHORIZED);
        }
    }
}
