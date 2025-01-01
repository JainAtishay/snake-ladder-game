package com.lld.snake_ladder_game.service;

import com.lld.snake_ladder_game.model.Board;
import com.lld.snake_ladder_game.model.Ladder;
import com.lld.snake_ladder_game.model.Player;
import com.lld.snake_ladder_game.model.Snake;

import java.util.*;

public class BoardService implements IBoardService{

    public Board board;

    @Override
    public Board createBoard(int size, List<Snake> snakes, List<Ladder> ladders, Map<Integer, Player> playerMap) {
        board = new Board(size, snakes, ladders, playerMap);
        return board;
    }

    @Override
    public void removePlayerFromBoard(Player currentPlayer) {

    }

    @Override
    public int getNewPosAfterSnakeAndLadderHit(int pos) {;
        Snake snake = getSnakeHit(pos);

        if(Objects.nonNull(snake)){
            return snake.getEnd();
        }

        Ladder ladder = getLadderHit(pos);

        if(Objects.nonNull(ladder)){
            return ladder.getEnd();
        }

        return pos;
    }

    private Ladder getLadderHit(int pos) {
        Optional<Ladder> ladderOpt = board.getLadders().stream().filter(ladder -> ladder.getStart() == pos).findFirst();
        return ladderOpt.orElse(null);
    }

    private Snake getSnakeHit(int pos) {
        Optional<Snake> snakeOpt = board.getSnakeList().stream().filter(snake -> snake.getStart() == pos).findFirst();
        return snakeOpt.orElse(null);
    }


}
