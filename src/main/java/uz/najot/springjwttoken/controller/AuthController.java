package uz.najot.springjwttoken.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.najot.springjwttoken.model.ResponseModel;
import uz.najot.springjwttoken.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){
        ResponseModel responseModel = authService.loginUser(username, password);
        return ResponseEntity.ok(responseModel);
    }
    @PostMapping("refreshToken")
    public ResponseEntity<?> refreshToken(@RequestParam String refreshToken){
        ResponseModel responseModel = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(responseModel);
    }

}
