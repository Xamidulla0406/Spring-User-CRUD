package nt.uz.SpringUserCRUD.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDTO<T> {
    private boolean success;
    private String message;
    private Integer code;
    private T data;
}