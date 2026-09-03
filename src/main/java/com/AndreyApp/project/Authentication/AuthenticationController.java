package com.AndreyApp.project.Authentication;
import com.AndreyApp.project.Users.UserModel;
import com.AndreyApp.project.Users.UserRepository;
import com.AndreyApp.project.infra.TokensServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokensServices tokensServices;

    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody @Valid AutheticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokensServices.generateTokes((UserModel)auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO registerDTO){
        if(this.userRepository.findByLogin(registerDTO.login())!= null){
            return ResponseEntity.badRequest().body("Login already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        UserModel newUser = new UserModel(registerDTO.login(), encryptedPassword, registerDTO.role());
        this.userRepository.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }
}
