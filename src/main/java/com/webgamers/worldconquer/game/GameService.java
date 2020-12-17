package com.webgamers.worldconquer.game;

import com.webgamers.worldconquer.game.dto.HistoryResponse;
import com.webgamers.worldconquer.game.model.GameHistory;
import com.webgamers.worldconquer.game.model.GameScoreBoard;
import com.webgamers.worldconquer.game.repository.*;
import com.webgamers.worldconquer.shared.ResourceNotFoundException;
import com.webgamers.worldconquer.shared.SharedService;
import com.webgamers.worldconquer.user.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class GameService {
    private final GameScoreBoardRepository scoreBoardRepository;
    private final SharedService sharedService;
    private final GameHistoryRepository gameHistoryRepository;


    @Transactional
    public Long savePoint(Long id, Integer areaNumber, Integer point) {
        final User user = sharedService.getUser(id);
        final List<Long> flags = new ArrayList<>();

        if (!scoreBoardRepository.existsByUserAndAreaNumber(user, areaNumber)) {
            scoreBoardRepository.save(
                    GameScoreBoard.builder()
                            .areaNumber(areaNumber)
                            .score(point)
                            .user(sharedService.getUser(id))
                            .build()
            ).getId();
        } else {
            scoreBoardRepository.findByAreaNumberAndUser(areaNumber, user)
                    .orElseThrow(() -> new ResourceNotFoundException())
                    .update(point);
        }


        for (final Integer area : List.of(1, 2, 3, 4)) {
            if (scoreBoardRepository.existsByUserAndAreaNumber(user, area)) {
                List<GameScoreBoard> scores
                        = scoreBoardRepository.findAllByAreaNumberOrderByScoreDesc(area);
                flags.add(scores.get(0).getUser().getId());
            }
        }

        if (flags.size() == 4) {
            for (int i=0; i<flags.size()-1; i++) {
                if (!flags.get(i).equals(flags.get(i+1))){
                    return id;
                }
            }
        }

        if (flags.size() == 4 ){
            scoreBoardRepository.deleteAll();
            gameHistoryRepository.save(GameHistory.builder().user(sharedService.getUser(id)).build());
            return 0L;
        }

        return id;
    }

    @Transactional
    public Map<String, String> getWorldMapInformation() {
        Map<String, String> map = new LinkedHashMap<>();

        for (Integer areaNumber : List.of(1, 2, 3, 4)) {
            List<GameScoreBoard> scoreBoards =
                    scoreBoardRepository.findAllByAreaNumberOrderByScoreDesc(areaNumber);

            if (scoreBoards.size() == 0) continue;
            GameScoreBoard scoreBoard = scoreBoards.get(0);
            log.info("info : {}", scoreBoard);

            map.put(String.format("area%sWinner", areaNumber), scoreBoard.getUser().getUsername());
            map.put(String.format("area%sPoint", areaNumber), scoreBoard.getScore().toString());
            map.put(String.format("area%sDate", areaNumber), scoreBoard.getCreatedAt().toString().split("T")[0]);
        }

        log.info("all info : {}", map);
        return map;
    }

    @Transactional
    public List<HistoryResponse> getHistoryResponse() {
        return gameHistoryRepository
                .findAllOrderByCreatedAtDesc()
                .stream()
                .map(HistoryResponse::of)
                .collect(Collectors.toList());
    }
}
