package com.core.gameservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgentGameResponse {

    private Long id;
    private String username;
    private String upline;
    private String userType;
    private Double rate;
    private Double rateLimit;
    private String productId;
    private String provider;
    private String status;
    private String note;
}
