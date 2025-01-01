package com.lld.snake_ladder_game.model;

import lombok.Data;

import java.util.Random;

@Data
public class Dice {
    private int size;
    private Random random;

    public Dice(int size){
        this.size = size;
        this.random = new Random();
    }

    public int roll(){
        return this.random.nextInt(size)+1;
    }
}
