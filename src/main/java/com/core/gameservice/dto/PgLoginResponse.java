package com.core.gameservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PgLoginResponse {

    private boolean success;
    private String message;
    private String authToken; // Authentication token if login is successful
}
