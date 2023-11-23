package com.core.gameservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletResponse {
    private String id;
    private String token;
    private String username;
    private double balance;
    private String type;// UserType
    private String refSale;
    private String upline;
    private Date createdAt;
    private Date updatedAt;
}
