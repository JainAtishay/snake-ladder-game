package com.lld.snake_ladder_game;

import com.lld.snake_ladder_game.model.*;
import com.lld.snake_ladder_game.service.BoardService;
import com.lld.snake_ladder_game.service.IPlayingService;
import com.lld.snake_ladder_game.service.PlayingService;

import java.util.*;

public class SnakeAndLadderTest {

    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        Snake snake1 = new Snake(50, 2);
        Snake snake2 = new Snake(40, 7);
        Snake snake3 = new Snake(21, 11);

        Ladder ladder1 = new Ladder(17, 98);
        Ladder ladder2 = new Ladder(19, 88);
        Ladder ladder3 = new Ladder(27, 55);

        List<Snake> snakeList = new ArrayList<>(Arrays.asList(snake1, snake2, snake3));
        List<Ladder> ladderList = new ArrayList<>(Arrays.asList(ladder1, ladder2, ladder3));

        Map<Integer, Player> playerMap = new HashMap<>();
        Player player1 = new Player(1, 0);
        Player player2 = new Player(2, 0);
        playerMap.put(1, player1);
        playerMap.put(2, player2);

        Board board = boardService.createBoard(100, snakeList, ladderList, playerMap);

        IPlayingService playingService = new PlayingService(board, playerMap, new Dice(6), boardService);

        playingService.playGame();
    }
}
