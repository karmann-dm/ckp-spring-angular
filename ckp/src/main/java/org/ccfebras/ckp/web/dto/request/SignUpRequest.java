package org.ccfebras.ckp.web.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SignUpRequest {
    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String secondName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotNull
    private String phone;

    @NotBlank
    @NotNull
    @Size(min = 6)
    private String password;

    @Positive
    @NotNull
    private Long organizationId;

    @Positive
    @NotNull
    private Long positionId;

    @Positive
    @NotNull
    private Long degreeId;

    @Positive
    @NotNull
    private Long rankId;
}
