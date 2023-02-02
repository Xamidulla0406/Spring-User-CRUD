package nt.uz.SpringUserCRUD.service;

import nt.uz.SpringUserCRUD.dto.ResponseDTO;
import nt.uz.SpringUserCRUD.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public List<UserDTO> userList = new ArrayList<>();

    public ResponseDTO<UserDTO> getById(Integer id) {
        Optional<UserDTO> user = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        return ResponseDTO.<UserDTO>builder()
                .data(user.orElse(null))
                .success(user.isPresent())
                .code(user.isPresent() ? 0 : -1)
                .message(user.isPresent() ? "OK" : "User is not found with this ID " + id)
                .build();
    }

    public ResponseDTO<UserDTO> addUser(UserDTO user) {
        if (userList.stream().anyMatch(u -> u.getId().equals(user.getId()))) {
            return ResponseDTO.<UserDTO>builder()
                    .code(1)
                    .message("User ID already exists: " + user.getId())
                    .build();
        }

        userList.add(user);
        return ResponseDTO.<UserDTO>builder()
                .data(user)
                .success(true)
                .message("OK")
                .build();
    }

    public ResponseDTO<UserDTO> deleteById(Integer id) {
        for (UserDTO user : userList) {
            if (user.getId().equals(id)) {
                userList.remove(user);
                return ResponseDTO.<UserDTO>builder()
                        .data(user)
                        .message("Successfully deleted!")
                        .build();
            }
        }
        return ResponseDTO.<UserDTO>builder()
                .message("User ID not found " + id)
                .build();
    }

    public ResponseDTO<UserDTO> addDeposit(Integer id, Double deposit) {
        for (UserDTO user : userList) {
            if (user.getId().equals(id)) {
                user.setDeposit(user.getDeposit() + deposit);
                return ResponseDTO.<UserDTO>builder()
                        .data(user)
                        .message("Deposit successfully added!")
                        .build();
            }
        }
        return ResponseDTO.<UserDTO>builder()
                .message("User ID not found " + id)
                .build();
    }
}