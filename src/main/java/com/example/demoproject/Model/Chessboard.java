package com.example.demoproject.Model;

public class Chessboard {
    //Square[][] squares;
    Piece[][] squares;

    public Chessboard(){
        squares = new Piece[8][8];
        //Pieces being set
        setPieces(squares);
        System.out.println(this);
    }

//    public void setSquares(Square[][] squares) {
//        this.squares =squares;
//    }

    private void setPieces(Piece[][] squares){
        for(int i = 1; i < 2; i++){
            for(int j = 0; j < squares[i].length;j++){
                squares[i][j] = new Pawn(Colour.WHITE,PieceType.PAWN);
            }
        }

        for(int i = squares.length -2; i < squares.length-1;i++){
            for(int j = 0; j < squares[i].length; j++){
                squares[i][j] = new Pawn(Colour.BLACK,PieceType.PAWN);
            }
        }
    }

    public Piece[][] getSquares() {
        return squares;
    }
    @Override
    public String toString(){
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if(squares[i][j] != null){
                    c.append(squares[i][j].type.toString());
                    c.append(squares[i][j].colour.toString());
                    c.append(" ");
                }
                if(squares[i][j] == null){
                    c.append("---");
                    c.append(" ");
                }
            }
            c.append("\n");
        }
        return c.toString();
    }



    //64 positions... e.g. 0-7, 8-15 etc
    //Start from top left

}
