package com.core.gameservice.entity;

import com.core.gameservice.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "game_providers")

public class GameProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "callback_url", length = 100)
    private String callbackUrl;

    @Column(nullable = false, length = 100)
    private String productID;

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(length = 100)
    private String provider;

    @Column(nullable = false)
    private double rate;

    @Column(name = "company_fix", nullable = false, length = 100)
    private String companyFix;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('A','C') default 'A'")
    private Status status;

    @Column(length = 100)
    private String readme;

    @Column(length = 100)
    private String note;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_allow_config")
    private boolean isAllowConfig;

}
