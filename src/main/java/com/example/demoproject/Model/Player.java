package com.example.demoproject.Model;

public enum Player {
    White, Black;

    // Example method to check if a player is white
    public boolean isWhite() {
        return this == White;
    }

    // Example method to check if a player is black
    public boolean isBlack() {
        return this == Black;
    }

    public static Player opponent(Player player){
        return player.isWhite() ? Player.Black : Player.White;
    }
}






