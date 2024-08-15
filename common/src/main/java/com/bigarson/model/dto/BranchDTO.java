package com.bigarson.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
@Validated
public class BranchDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    @NotBlank(message = "{exception.notnull.name}")
    private String name;
    @NotBlank(message = "{exception.notnull.address}")
    private String address;
    private String city;
    private String district;
    @NotBlank(message = "{exception.notnull.phone}")
    private String phone;
    private String zipcode;
    @NotBlank(message = "{exception.notnull.contact.name}")
    private String contactName;
    @Email(message = "{exception.email.format}")
    @NotBlank(message = "{exception.notnull.email}")
    private String contactEmail;
    @NotBlank(message = "{exception.notnull.contact.phone}")
    private String contactPhone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MultipartFile image;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String imageUrl;
}
