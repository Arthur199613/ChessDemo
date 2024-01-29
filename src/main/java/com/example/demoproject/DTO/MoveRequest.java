package com.example.demoproject.DTO;

public class MoveRequest {
    private String fromSquare;
    private String toSquare;
    private String pieceType;
    private String pieceColor;

    public MoveRequest(String fromSquare, String toSquare, String pieceType, String pieceColor) {
        this.fromSquare = fromSquare;
        this.toSquare = toSquare;
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
    }

    public String getPieceColor() {
        return pieceColor;
    }

    public String getPieceType() {
        return pieceType;
    }

    public String getFromSquare() {
        return fromSquare;
    }

    public String getToSquare() {
        return toSquare;
    }


    // Getters and setters
}
