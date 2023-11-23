package com.core.gameservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAgentGameRequest {

    private String agentId; // Identifier for the agent
    private String gameId; // Identifier for the game
    // Fields representing the details that can be updated
    private String newGameStatus; // Example field
    private Double newRate; // Another example field, if rate updates are relevant
}
