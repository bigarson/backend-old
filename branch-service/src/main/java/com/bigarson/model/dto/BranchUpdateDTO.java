package com.bigarson.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Data
@Validated
public class BranchUpdateDTO {

    private UUID id;
    @NotBlank(message = "{exception.notnull.name}")
    private String name;
    @NotBlank(message = "{exception.notnull.name}")
    private String address;
    private String city;
    private String district;
    private String phone;
    private String zipcode;
    @NotBlank(message = "{exception.notnull.name}")
    private String contactName;
    @NotBlank(message = "{exception.notnull.email}")
    private String contactEmail;
    @NotBlank(message = "{exception.notnull.phone}")
    private String contactPhone;
    private WorkingTimeDTO workingTime;
}

