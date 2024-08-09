package com.bigarson.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Validated
public class PlanDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @NotBlank(message = "{plandto.name.notblank}")
    @Size(min = 3, max = 100, message = "{plandto.name.size}")
    private String name;

    @Size(max = 255, message = "{plandto.description.size}")
    private String description;

    @NotNull(message = "{plandto.pricepermonth.notnull}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{plandto.pricepermonth.decimalmin}")
    private BigDecimal pricePerMonth;

    @NotNull(message = "{plandto.priceperyear.notnull}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{plandto.priceperyear.decimalmin}")
    private BigDecimal pricePerYear;
}
