package com.core.gameservice.services.impl;

import com.core.gameservice.client.PgClient;
import com.core.gameservice.client.WalletClient;
import com.core.gameservice.dto.*;
import com.core.gameservice.entity.AgentGame;
import com.core.gameservice.entity.GameProvider;
import com.core.gameservice.exceptions.BadRequestException;
import com.core.gameservice.exceptions.InternalErrorException;
import com.core.gameservice.repositories.AgentGameRepository;
import com.core.gameservice.repositories.GameProviderRepository;
import com.core.gameservice.services.PgService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PgServiceImpl implements PgService {

    private final AgentGameRepository agentGameRepository;
    private final GameProviderRepository gameProviderRepository;
    private final WalletClient walletClient;
    private final PgClient pgClient;
    @Value("${partner.pg.productId}")
    String productId;
    @Value("${partner.pg.provider}")
    String provider;

    public PgServiceImpl(AgentGameRepository agentGameRepository, GameProviderRepository gameProviderRepository, WalletClient walletClient, PgClient pgClient) {
        this.agentGameRepository = agentGameRepository;
        this.gameProviderRepository = gameProviderRepository;
        this.walletClient = walletClient;
        this.pgClient = pgClient;
    }

    @Override
    public PartnerLoginResponse login(PgLoginRequest pgLoginRequest) throws Exception {

try{
        GetWalletRequest walletRequest = new GetWalletRequest();
        walletRequest.setUsername(pgLoginRequest.getUsername());

        WalletResponse user = walletClient.getWallet(walletRequest);

        if (user == null) {
            throw new RuntimeException("Failed to get user from wallet");
        }
        boolean isActive = verifyAgentGame(this.productId, user.getUpline(), this.provider);
        if (!isActive) {
            throw new BadRequestException("Games inactive");
        }
    return pgClient.pgLogin(pgLoginRequest);

    } catch(Exception e)

    {
        throw new Exception("Error fetching games: " + e.getMessage());

    }


    }

    public boolean verifyAgentGame(String productId, String upline, String provider) {
        List<AgentGame> agentGames = agentGameRepository.findAllByUsernameAndStatusAndProductId(upline, "A", productId);

        // If we can't find games corresponding with the agent, then we find the game provider
        if (agentGames.isEmpty()) {
            GameProvider gameProvider = gameProviderRepository.findByProductID(productId);
            return gameProvider != null;
        }

        // Otherwise, we find if the agent games we found are equal to the provider; if it is, then the user can login
        for (AgentGame agentGame : agentGames) {
            if (provider.equals(agentGame.getProvider())) {
                return true;
            }
        }

        // Return false if no matching conditions are met
        return false;
    }
    @Override

    public List<PgGameResponse> gameList() throws InternalErrorException {
        try {
            List<PgGameResponse> gameList = pgClient.getGameList();

           return gameList;
        } catch (HttpClientErrorException e) {
            throw new InternalErrorException("Error fetching games: " + e.getMessage());
        }
    }


}
