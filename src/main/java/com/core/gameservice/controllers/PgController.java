package com.core.gameservice.controllers;

import com.core.gameservice.dto.GameListResponse;
import com.core.gameservice.dto.PartnerLoginResponse;
import com.core.gameservice.dto.PgGameResponse;
import com.core.gameservice.dto.PgLoginRequest;
import com.core.gameservice.services.PgService;
import com.core.gameservice.services.impl.PgServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pg")
@AllArgsConstructor
@Slf4j
public class PgController {

    private final PgService pgService;

    @PostMapping("/login")
    public ResponseEntity<PartnerLoginResponse> login(@RequestBody PgLoginRequest pgLoginRequest) {
        try {
            PartnerLoginResponse response = pgService.login(pgLoginRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
           // logger.error("Error during login: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body(new PartnerLoginResponse(false,e.getMessage(),""));

            // return ResponseEntity.internalServerError().body(new PartnerLoginResponse("Error", e.getMessage()));
        }
    }

    @GetMapping("/games")
    public ResponseEntity<GameListResponse> gameList() throws Exception {
        try {
            List<PgGameResponse> pgGameResponses = pgService.gameList();
            GameListResponse response=new GameListResponse(pgGameResponses,pgGameResponses.size());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
           // logger.error("Error fetching game list: {}", e.getMessage(), e);
            throw  new Exception();
           // return ResponseEntity.internalServerError().body(new GameListResponse("Error", e.getMessage()));
        }
    }
}
