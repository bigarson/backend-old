package com.bigarson.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Data
@Validated
public class BranchDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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
    private String contactEmail;
    @NotBlank(message = "{exception.notnull.name}")
    private String contactPhone;
    private WorkingTimeDTO workingTime;
}
