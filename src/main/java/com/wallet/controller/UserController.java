package com.wallet.controller;

import com.wallet.business.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(Arrays.asList(new UserDTO("user", "pass")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOne(@PathVariable() Long id) {
        return ResponseEntity.ok(new UserDTO("user", "pass"));
    }
}
