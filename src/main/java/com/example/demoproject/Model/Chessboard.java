package com.example.demoproject.Model;

import com.example.demoproject.DTO.MoveRequest;
import com.example.demoproject.Model.Move.Move;
import com.example.demoproject.Model.Move.NormalMove;
import com.example.demoproject.Util.Position;
import org.springframework.data.util.Pair;

import java.util.Arrays;

public class Chessboard {
    //Square[][] squares;
    private Piece[][] squares;


    public Chessboard(){
        squares = new Piece[8][8];
        //Pieces being set
        //TODO remove this from the constructor, it is too confusing and unpredictable
        setPieces(squares);
        System.out.println(this);
    }

    public boolean makeMove(int fromX, int fromY,int toX,int toY){
        Move move = new NormalMove(new Position(fromX,fromY),new Position(toX,toY));
        move.execute(this);
        System.out.println(this.toString());
        return true;
    }

    public boolean validateMove(MoveRequest request){
        Piece[][] piece = getSquares();
        boolean isValid;

        String pieceStr = request.getPieceType();


        Pair<Integer, Integer> ToXY = ParseToRequestXY(request);
        Pair<Integer,Integer> FromXY = ParseFromRequestXY(request);
        System.out.println("X Value: "+ToXY.getFirst());
        System.out.println("Y Value: "+ToXY.getSecond());

        System.out.println("Moving from square "+ request.getFromSquare() + " To square "+ request.getToSquare()
        + " Colour " +  request.getPieceColor() + " Type " + request.getPieceType());

        //TODO Confusing logic, can refactor this later
        isValid = piece[FromXY.getFirst()][FromXY.getSecond()].getPiece().isValidMove(this, ToXY.getFirst(), ToXY.getSecond()
                ,FromXY.getFirst(),FromXY.getSecond() );

        return isValid;
    }

    /**have to parse the request x and y coordinates**/
    private Pair<Integer, Integer> ParseFromRequestXY(MoveRequest request) {
        Pair<Integer, Integer> xy;
        //String of
        System.out.println(request.getFromSquare().length());
        String[] a = request.getFromSquare().split("_");
        System.out.println(Arrays.toString(a));

        xy = Pair.of(Integer.parseInt(a[1]),Integer.parseInt(a[2]));
        return xy;
    }

    private Pair<Integer, Integer> ParseToRequestXY(MoveRequest request) {
        Pair<Integer, Integer> xy;
        //String of
        System.out.println(request.getFromSquare().length());
        String[] a = request.getToSquare().split("_");
        System.out.println(Arrays.toString(a));

        xy = Pair.of(Integer.parseInt(a[1]),Integer.parseInt(a[2]));
        return xy;
    }

//    public void setSquares(Square[][] squares) {
//        this.squares =squares;
//    }

    public Piece getPieceAtPosition(Position pos) {
        if(this.isEmpty(pos)){
            throw new NullPointerException();
        }
        else
            return this.squares[pos.getX()][pos.getY()];
    }

    public boolean isEmpty(Position pos){
        return (squares[pos.getX()][pos.getY()] == null);
    }

    private void setPieces(Piece[][] squares){
        for(int i = 1; i < 2; i++){
            for(int j = 0; j < squares[i].length;j++){
                squares[i][j] = new Pawn(Colour.BLACK,PieceType.PAWN);
            }
        }
        squares[0][0] = new Rook(Colour.BLACK,PieceType.ROOK);
        squares[0][7] = new Rook(Colour.BLACK,PieceType.ROOK);
        squares[0][1] = new Knight(Colour.BLACK,PieceType.KNIGHT);
        squares[0][6] = new Knight(Colour.BLACK,PieceType.KNIGHT);
        squares[0][2] = new Bishop(Colour.BLACK,PieceType.BISHOP);
        squares[0][5] = new Bishop(Colour.BLACK,PieceType.BISHOP);
        squares[0][3] = new Queen(Colour.BLACK,PieceType.QUEEN);
        squares[0][4] = new King(Colour.BLACK,PieceType.KING);

        for(int i = squares.length -2; i < squares.length-1;i++){
            for(int j = 0; j < squares[i].length; j++){
                squares[i][j] = new Pawn(Colour.WHITE,PieceType.PAWN);
            }
        }
        squares[7][0] = new Rook(Colour.WHITE,PieceType.ROOK);
        squares[7][7] = new Rook(Colour.WHITE,PieceType.ROOK);
        squares[7][1] = new Knight(Colour.WHITE,PieceType.KNIGHT);
        squares[7][6] = new Knight(Colour.WHITE,PieceType.KNIGHT);
        squares[7][2] = new Bishop(Colour.WHITE,PieceType.BISHOP);
        squares[7][5] = new Bishop(Colour.WHITE,PieceType.BISHOP);
        squares[7][3] = new Queen(Colour.WHITE,PieceType.QUEEN);
        squares[7][4] = new King(Colour.WHITE,PieceType.KING);
    }

    public boolean isInside(Position pos){
        return pos.getX() < squares.length && pos.getY() < squares.length &&
                pos.getX() >= 0 && pos.getY() >= 0;
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
