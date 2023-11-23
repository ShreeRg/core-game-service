package com.core.gameservice.repositories;

import com.core.gameservice.entity.AgentGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentGameRepository extends JpaRepository<AgentGame, Long> { // Assuming the ID type is Long

    // Custom query method to find AgentGames by username, status, and productId
    List<AgentGame> findAllByUsernameAndStatusAndProductId(String username, String status, String productId);


    // Other query methods as required
}
