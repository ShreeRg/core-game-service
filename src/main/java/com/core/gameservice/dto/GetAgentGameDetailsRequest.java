package com.core.gameservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAgentGameDetailsRequest {

    private String agentId; // Assuming an agent ID is needed to identify the game details
    private String gameId; // Assuming a game ID is also required
}
