package eu.circletouch.users.services;

import eu.circletouch.users.beans.CompanyRole;
import eu.circletouch.users.beans.Credentials;
import eu.circletouch.users.beans.LoginResponse;
import eu.circletouch.users.beans.User;
import eu.circletouch.users.exceptions.CustomException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class AuthService {

    Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UsersService usersService;

    @Value("${jwt.issuer}")
    private String jwtIssuer;

    @Value("${jwt.audience}")
    private String jwtAudience;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${auth.hashalg}")
    private String defaulHashAlg;

    public AuthService(UsersService usersService) {
        this.usersService = usersService;
    }

    public LoginResponse createAuthenticationToken(Credentials credentials) {
        User user = this.authenticate(credentials);

        if (user == null)
            throw new CustomException("Invalid credentials", HttpStatus.UNAUTHORIZED);

        String id = UUID.randomUUID().toString();
        LocalDateTime iat = LocalDateTime.now();
        LocalDateTime exp = iat.plusHours(24);

        String token = Jwts.builder()
                .setId(id)
                .setIssuedAt(Date.from(iat.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(exp.atZone(ZoneId.systemDefault()).toInstant()))
                .setSubject(credentials.getUsername())
                .setIssuer(jwtIssuer)
                .setAudience(jwtAudience)
                .addClaims(getClaims(user))
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
                .compact();

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUser(user);
        return response;
    }

    private Map<String, Object> getClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("user_id", user.getId());
        claims.put("user_username", user.getUsername());
        claims.put("user", user);
        return claims;
    }

    public User authenticate(Credentials credentials) {
        String userEncodedPassword = usersService.getUserEncodedPassword(credentials.getUsername());
        if (userEncodedPassword != null) {
            if (checkPassword(credentials.getPassword(), userEncodedPassword, defaulHashAlg)) {
                return usersService.getByUsername(credentials.getUsername());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private boolean checkPassword(String password, String passwordHash, String passwordHashAlg) {
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(passwordHash)) {
            logger.error("Empty password or passwordhash");
            return false;
        }

        List<String> allowedHashAlgList = Arrays.asList("MD5", "MD5-B64", "SHA-1", "SHA-256");

        if (!allowedHashAlgList.contains(passwordHashAlg)) {
            logger.error("Password hash algorithm not supported");
            return false;
        }

        String hash = "";
        switch (passwordHashAlg) {
            case "MD5":
                hash = DigestUtils.md5Hex(password);
                break;
            case "MD5-B64":
                hash = new String(Base64.getEncoder().encode(DigestUtils.md5(password)));
                break;
            case "SHA1":
                hash = DigestUtils.sha1Hex(password);
                break;
            case "SHA256":
                hash = DigestUtils.sha256Hex(password);
                break;
        }

        return passwordHash.equals(hash);
    }
}
