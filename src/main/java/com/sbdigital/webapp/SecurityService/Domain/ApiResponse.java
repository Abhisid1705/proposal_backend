package com.sbdigital.webapp.SecurityService.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse {

    private Boolean success;
    private String message;

    public ApiResponse(boolean success, String message) {
        this.message = message;
        this.success =success;
    }
}
