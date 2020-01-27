package com.FayTax.FayTax.api;

import com.FayTax.FayTax.model.User;
import com.FayTax.FayTax.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/fayTax")
@Slf4j
@RequiredArgsConstructor
public class UserApi {
    private final UserService UserService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(UserService.findAll());
    }

    @PostMapping(value = "/addUser", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@Valid @RequestBody(required = false) User user) {
        return ResponseEntity.ok(UserService.save(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = UserService.findById(id);
        if (!user.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
        if (!UserService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(UserService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!UserService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        UserService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}