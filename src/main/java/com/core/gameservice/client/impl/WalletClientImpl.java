package com.core.gameservice.client.impl;

import com.core.gameservice.client.WalletClient;
import com.core.gameservice.dto.GetWalletRequest;
import com.core.gameservice.dto.WalletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class WalletClientImpl implements WalletClient {


    private final WebClient webClient;
    @Value("${services.walletService.url}")
    String baseUrl;

    public WalletClientImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }


    @Override
    public WalletResponse getWallet(GetWalletRequest getWalletRequest) {

        return webClient.get()
                .uri("api/wallet/get/wallet/{username}", getWalletRequest.getUsername())
                .retrieve()
                .bodyToFlux(WalletResponse.class)
                .last()
                .block();
    }


}
