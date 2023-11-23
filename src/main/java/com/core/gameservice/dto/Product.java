package com.core.gameservice.dto;// Import statements go here

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private boolean checked;
    private double rate;
    private double rateLimit;
    private String productId;
    private String productName;
}
