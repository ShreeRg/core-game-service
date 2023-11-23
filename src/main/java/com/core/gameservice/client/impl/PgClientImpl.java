package com.core.gameservice.client.impl;

import com.core.gameservice.client.PgClient;
import com.core.gameservice.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PgClientImpl implements PgClient {

    private final WebClient webClient;
    @Value("${services.pgService.url}")
    String baseUrl;

    public PgClientImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public PartnerLoginResponse pgLogin(PgLoginRequest pgLoginRequest) {
        return webClient.post()
                .uri(baseUrl + "/api/pg/login")
                .bodyValue(pgLoginRequest)
                .retrieve()
                .bodyToMono(PartnerLoginResponse.class)
                .block();
    }

    @Override
    public List<PgGameResponse> getGameList() {

        return webClient.get()
                .uri(baseUrl+"/api/pg/gameList")
                .retrieve()
                .bodyToFlux(PgGameResponse.class)
                .collectList()
                .block();
    }
}
