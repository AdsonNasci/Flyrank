package infra;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.ProviderManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, ProviderManagerBuilder providerManagerBuilder) throws Exception {
//        return http.authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/controller/testing").permitAll();
//                    auth.anyRequest().authenticated();
//                })
//                .oauth2Login(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
//                .build();
        //stateless no saving
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.POST,"/controller/testing").permitAll();
                    auth.anyRequest().authenticated();
                })
                .build();
    }
    @Bean
     PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder(12);
    }
}


