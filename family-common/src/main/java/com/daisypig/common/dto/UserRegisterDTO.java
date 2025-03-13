package com.daisypig.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegisterDTO {
    @NotBlank(message = "用户名不能为空")
    private String username;
    
    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*)[A-Za-z]{8,}$",
             message = "密码必须包含字母和数字，且长度至少8位")
    private String password;
    
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$",
             message = "邮箱格式不正确")
    private String email;
}