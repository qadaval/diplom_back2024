package kz.spring.diplom_project.controller;

// AuthController.java

import kz.spring.diplom_project.model.City;
import kz.spring.diplom_project.model.Parent;
import kz.spring.diplom_project.model.dto.ParentDto;
import kz.spring.diplom_project.request.AuthenticationRequest;
import kz.spring.diplom_project.service.CityService;
import kz.spring.diplom_project.service.ParentService;
import kz.spring.diplom_project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ParentService parentService;

    @Autowired
    private CityService cityService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequestDTO
    ) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getIin(), authenticationRequestDTO.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = parentService.loadUserByUsername(authenticationRequestDTO.getIin());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @RequestBody ParentDto parentDto
    ) {
        Parent parent = new Parent();

        parent.setIin(parentDto.getIin());
        parent.setPassword(parentDto.getPassword());
        parent.setF_name(parentDto.getF_name());
        parent.setName(parentDto.getName());
        parent.setSurname(parentDto.getSurname());
        parent.setPhoneNumber(parentDto.getPhoneNumber());
        parent.setGender(parentDto.getGender());
        City city = cityService.getCity(parentDto.getCityId());
        parent.setCity(city);
        parent.setCitizenship(parentDto.getCitizenship());
        parent.setDateOfBirth(parentDto.getDateOfBirth());

        parentService.saveUser(parent);

        final UserDetails userDetails = parentService.loadUserByUsername(parentDto.getIin());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(jwt);
    }
}
