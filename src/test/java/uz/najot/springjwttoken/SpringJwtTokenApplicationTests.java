package uz.najot.springjwttoken;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import uz.najot.springjwttoken.security.JwtTokenUtil;

@SpringBootTest
class SpringJwtTokenApplicationTests {

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Test
    void contextLoads() {
        UserDetails build = User.builder().username("ismoil").password("root123").roles("admin").build();

        String s = jwtTokenUtil.jwtGenerator(build);
        System.out.println(s);
        String username = jwtTokenUtil.getUsernameFromJwt(s);
        System.out.println(username);
    }

}
