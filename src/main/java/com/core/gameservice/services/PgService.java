package com.core.gameservice.services;

import com.core.gameservice.dto.PartnerLoginResponse;
import com.core.gameservice.dto.PgGameResponse;
import com.core.gameservice.dto.PgLoginRequest;
import com.core.gameservice.exceptions.InternalErrorException;

import java.util.List;

public interface PgService {
    PartnerLoginResponse login(PgLoginRequest pgLoginRequest) throws Exception;

    List<PgGameResponse> gameList() throws InternalErrorException;
}
