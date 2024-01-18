package com.example.demoproject.DTO;

import com.example.demoproject.Model.Colour;
import com.example.demoproject.Model.PieceType;

public class MoveRequest {
    private String fromSquare;
    private String toSquare;
    private PieceType pieceType;
    private Colour pieceColor;

    public MoveRequest(String fromSquare, String toSquare, PieceType pieceType, Colour pieceColor) {
        this.fromSquare = fromSquare;
        this.toSquare = toSquare;
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
    }

    // Getters and setters
}
