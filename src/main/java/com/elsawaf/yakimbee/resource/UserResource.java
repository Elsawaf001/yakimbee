package com.elsawaf.yakimbee.resource;

import com.elsawaf.yakimbee.domain.UserDTO;
import com.elsawaf.yakimbee.entity.User;
import com.elsawaf.yakimbee.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;
@PostMapping("/create")
    public ResponseEntity<HttpResponse> createUser(@RequestBody @Valid User user){
    UserDTO userDTO = userService.createUser(user);
    return ResponseEntity.created(getUri()).body(
            HttpResponse.builder()
                    .timeStamp(Instant.now())
                    .data(Map.of("user" , userDTO))
                    .httpStatus(HttpStatus.CREATED)
                    .StatusCode(HttpStatus.CREATED.value())
                    .message("User "+ userDTO.getFirstName() + " " + userDTO.getLastName() + " Created successfully")
                    .build()
    );

    }

    private URI getUri() {
        return URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/user/get/<userId>").toString());

    }


}
