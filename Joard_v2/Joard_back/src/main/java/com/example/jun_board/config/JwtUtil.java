package com.example.jun_board.config;

import com.example.jun_board.entity.User;
import com.example.jun_board.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJws;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
@Log4j2
@RequiredArgsConstructor
public class JwtUtil {

    private String secretKey = "dgsw0123456789";

    private final UserRepository userRepository;

    //1month
    private long expire = 60 * 24* 30;

    public String generateToken(String content) {
        try {
            return Jwts.builder()
                    .setIssuedAt(new Date())
                    .setSubject(content)
                    .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(expire).toInstant()))
                    //.setExpiration(Date.from(ZonedDateTime.now().plusSeconds(1).toInstant()))
                    .claim("sub", content)
                    .signWith(SignatureAlgorithm.HS256, secretKey.getBytes("UTF-8"))
                    .compact();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String validateAndExtract(String tokenStr)throws Exception {
        String contentValue = null;
        try {
            DefaultJws defaultJws = (DefaultJws) Jwts.parser()
                    .setSigningKey(secretKey.getBytes("UTF-8")).parseClaimsJws(tokenStr);
            log.info(defaultJws);
            log.info(defaultJws.getBody().getClass());

            DefaultClaims claims = (DefaultClaims) defaultJws.getBody();
            log.info("------------------------");
            contentValue = claims.getSubject();
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            contentValue = null;
        }

        return contentValue;
    }

    public Claims getTokenBody(String token) { // Token 정보 가져오는 거
        try {
            return Jwts.parser().setSigningKey(secretKey.getBytes("UTF-8"))
                    .parseClaimsJws(token).getBody();
        } catch (RuntimeException e) {
            throw new RuntimeException("Token Exception");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public Authentication getAuthentication(String token) {
        User user = userRepository.findByUsername(getTokenBody(token).getSubject()).orElseThrow();
        return new UsernamePasswordAuthenticationToken(user, null, null);
    }
}