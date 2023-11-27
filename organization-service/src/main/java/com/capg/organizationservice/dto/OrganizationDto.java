package com.capg.organizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
		description = "OrganizationDto model information"
		)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    private Long id;
    @Schema(
    		description = "Organization Name"
    		)
    private String organizationName;
    @Schema(
    		description = "organization Description"
    		)
    private String organizationDescription;
    @Schema(
    		description = "Organization Code"
    		)
    private String organizationCode;
    @Schema(
    		description = "Created Date"
    		)
    private LocalDateTime createdDate;
}