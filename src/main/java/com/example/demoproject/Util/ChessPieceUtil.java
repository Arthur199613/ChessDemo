package com.example.demoproject.Util;

import com.example.demoproject.Model.Piece;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ChessPieceUtil {
    public static String getImagePath(Piece piece){
        String pieceType = piece.getPieceType().toString().toLowerCase();
        String pieceColour = piece.getColour().toLowerCase();

        return String.format("../static/ChessPieces/%s-%s.svg",pieceType,pieceColour);
    }
}
