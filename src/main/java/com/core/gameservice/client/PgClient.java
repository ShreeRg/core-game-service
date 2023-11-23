package com.core.gameservice.client;

import com.core.gameservice.dto.PartnerLoginResponse;
import com.core.gameservice.dto.PgGameResponse;
import com.core.gameservice.dto.PgLoginRequest;

import java.util.List;

public interface PgClient {
     PartnerLoginResponse pgLogin(PgLoginRequest pgLoginRequest) ;
     List<PgGameResponse> getGameList() ;

    }
