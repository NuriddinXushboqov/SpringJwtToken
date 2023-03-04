package uz.najot.springjwttoken.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class
JwtTokenUtil {
    private final String key = "MySecretKey";
    public String jwtGenerator(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+1000*60))
                .signWith(SignatureAlgorithm.HS256,key).compact();
    }
    public boolean checkExpireDate(String token){
        Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        Date expiration = body.getExpiration();
        return expiration.getTime()>=new Date().getTime();

    }
    public String getUsernameFromJwt(String token) throws SignatureException {
        Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return body.getSubject();
    }
}
