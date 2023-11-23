package com.core.gameservice.client;


import com.core.gameservice.dto.GetWalletRequest;
import com.core.gameservice.dto.WalletResponse;

public interface WalletClient {

    WalletResponse getWallet(GetWalletRequest getWalletRequest);
}
