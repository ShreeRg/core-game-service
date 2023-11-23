package com.core.gameservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PgGameResponse {

    private String gameId;
    private String gameName;
    private String gameStatus; // e.g., 'active', 'inactive', 'under maintenance'
}
