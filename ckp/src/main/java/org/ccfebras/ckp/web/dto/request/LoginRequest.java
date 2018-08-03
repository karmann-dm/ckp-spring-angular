package org.ccfebras.ckp.web.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    @NotNull
    private String email;

    @NotNull
    @NotBlank
    private String password;
}
