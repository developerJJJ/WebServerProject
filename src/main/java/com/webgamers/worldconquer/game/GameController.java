package com.webgamers.worldconquer.game;

import com.webgamers.worldconquer.game.dto.HistoryResponse;
import com.webgamers.worldconquer.user.security.AuthUser;
import com.webgamers.worldconquer.user.security.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class GameController {
    private final GameService gameService;

    @GetMapping("api/game")
    public ResponseEntity<Long> savePoint(@Authentication AuthUser user,
                                          @RequestParam("area") Integer areaNumber,
                                          @RequestParam("point") Integer point) {

        return ResponseEntity.status(201).body(gameService.savePoint(user.getId(), areaNumber, point));
    }

    @GetMapping("api/game/info")
    public Map<String, String> getWorldMapInformation() {
        return gameService.getWorldMapInformation();
    }

    @GetMapping("api/game/history")
    public List<HistoryResponse> getHistoryResponse() {
        return gameService.getHistoryResponse();
    }
}