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
@Table(name = "agent_game")
public class AgentGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String username;

    @Column(length = 100)
    private String upline;

    @Column(nullable = false, length = 100)
    private String userType;

    @Column(nullable = false)
    private double rate;

    @Column(nullable = false)
    private double rateLimit;

    @Column(nullable = false, length = 100)
    private String productId;

    @Column(length = 100)
    private String provider;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('A','C') default 'A'")
    private Status status;

    @Column(length = 100)
    private String note;

}
