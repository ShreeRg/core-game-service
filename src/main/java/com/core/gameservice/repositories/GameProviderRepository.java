package com.core.gameservice.repositories;

import com.core.gameservice.entity.AgentGame;
import com.core.gameservice.entity.GameProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameProviderRepository extends JpaRepository<GameProvider, Long>
{
    GameProvider findByProductID(String productId);
}
