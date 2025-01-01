package com.lld.snake_ladder_game.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Board {
    private int size;
    private List<Snake> snakeList;
    private List<Ladder> ladders;
    private Map<Integer, Player> playerMap;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders, Map<Integer, Player> playerMap) {
        this.size = size;
        this.snakeList = snakes;
        this.ladders = ladders;
        this.playerMap = playerMap;
    }
}
