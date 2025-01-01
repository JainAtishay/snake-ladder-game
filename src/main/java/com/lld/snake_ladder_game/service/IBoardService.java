package com.lld.snake_ladder_game.service;

import com.lld.snake_ladder_game.model.Board;
import com.lld.snake_ladder_game.model.Ladder;
import com.lld.snake_ladder_game.model.Player;
import com.lld.snake_ladder_game.model.Snake;

import java.util.List;
import java.util.Map;

public interface IBoardService {
    Board createBoard(int size, List<Snake> snakes, List<Ladder> ladders, Map<Integer, Player> playerMap);
    void removePlayerFromBoard(Player currentPlayer);
    int getNewPosAfterSnakeAndLadderHit(int newPos);
}
