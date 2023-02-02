package nt.uz.SpringUserCRUD.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String username;
    private Double deposit;

    public UserDTO(Integer id, String username, Double deposit) {
        this.id = id;
        this.username = username;
        this.deposit = deposit;
    }
}