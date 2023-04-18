package net.javaguildes.springboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.javaguildes.springboot.dto.UserDTO;
import net.javaguildes.springboot.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @GetMapping
    public List<UserDTO> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    @PostMapping
    public UserDTO save(@RequestBody @Valid UserDTO userDTO) {
        return this.userService.save(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return this.userService.update(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return this.userService.delete(id);
    }
}
