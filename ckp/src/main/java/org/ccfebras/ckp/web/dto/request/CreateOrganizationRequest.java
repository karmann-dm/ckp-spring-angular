package org.ccfebras.ckp.web.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrganizationRequest {
    private String info;

    @NotNull
    @NotEmpty
    private String shortName;

    @NotNull
    @NotEmpty
    private String fullName;

    @Positive
    @NotNull
    private Long departmentId;
}
