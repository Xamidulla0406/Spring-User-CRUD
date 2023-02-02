package nt.uz.SpringUserCRUD.controller;

import lombok.RequiredArgsConstructor;
import nt.uz.SpringUserCRUD.dto.ResponseDTO;
import nt.uz.SpringUserCRUD.dto.UserDTO;
import nt.uz.SpringUserCRUD.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    ResponseDTO<UserDTO> get(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseDTO<UserDTO> addUser(@RequestBody UserDTO user) {
        return service.addUser(user);
    }

    @DeleteMapping("/{id}")
    ResponseDTO<UserDTO> deleteUser(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}/{deposit}")
    ResponseDTO<UserDTO> addDeposit(@PathVariable Integer id, @PathVariable Double deposit) {
        return service.addDeposit(id, deposit);
    }
}