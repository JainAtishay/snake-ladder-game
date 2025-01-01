package com.lld.snake_ladder_game.service;

import com.lld.snake_ladder_game.model.Board;
import com.lld.snake_ladder_game.model.Dice;
import com.lld.snake_ladder_game.model.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class PlayingService implements IPlayingService{
    private final Board board;
    private final Queue<Player> players;
    private final int initialPlayersCount;
    private final Dice dice;
    private final IBoardService boardService;

    public PlayingService(Board board, Map<Integer, Player> players, Dice dice, BoardService boardService){
        this.board = board;
        this.players = new LinkedList<>();
        this.initialPlayersCount = players.size();

        for(Player player : players.values()){
            this.players.offer(player);
        }

        this.dice = dice;
        this.boardService = boardService;
    }

    @Override
    public boolean playGame(){

        while(!isGameCompleted()){
            Player currentPlayer = players.poll();
            assert currentPlayer != null;
            int currPos = currentPlayer.getPlayerPos();
            int newPos = dice.roll() + currPos;

            if(newPos > this.board.getSize()){
                players.offer(currentPlayer);
                continue;
            }

            movePlayer(currentPlayer, newPos);

            if(hasPlayerWon(currentPlayer)){
                System.out.println(currentPlayer.getPlayerNo() + " has won");
                removePlayerFromBoard(currentPlayer);
            } else{
                players.offer(currentPlayer);
            }
        }

        return true;
    }

    private void removePlayerFromBoard(Player currentPlayer) {
        this.boardService.removePlayerFromBoard(currentPlayer);
    }

    private boolean hasPlayerWon(Player currentPlayer) {
        return this.board.getSize() == currentPlayer.getPlayerPos();
    }

    private void movePlayer(Player currentPlayer, int newPos) {
        newPos = boardService.getNewPosAfterSnakeAndLadderHit(newPos);
        currentPlayer.setPlayerPos(newPos);
    }

    private boolean isGameCompleted() {
        return this.initialPlayersCount > players.size();
    }

}
