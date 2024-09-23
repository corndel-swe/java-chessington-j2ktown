package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Queen(PlayerColour colour) {
    this.type = PieceType.QUEEN;
    this.colour = colour;
  }

  @Override
  public Piece.PieceType getType() {
    return type;
  }

  @Override
  public PlayerColour getColour() {
    return colour;
  }

  @Override
  public String toString() {
    return colour.toString() + " " + type.toString();
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    //if (getColour().equals(PlayerColour.WHITE)) {
    int totalCol = board.getBoard()[0].length;
    int totalRow = board.getBoard().length;

    int currentRow = from.getRow();
    int currentCol = from.getCol();

    System.out.println("current row = ");
    System.out.println(currentRow);
    System.out.println("current col = ");
    System.out.println(currentCol);


    //vert
    for (int c = 0; c < totalCol ; c++) {
      if (c != currentCol) {
        System.out.println("adding"+ currentRow + c);
        allowedMoves.add(new Move(from, new Coordinates(currentRow, c)));
        System.out.println();
      }
    }
    System.out.println(allowedMoves);
    for (int r = 0; r < totalRow ; r++) {
      if (r != currentCol) {
        System.out.println("adding"+ currentRow + r);
        allowedMoves.add(new Move(from, new Coordinates(r, currentRow)));
        System.out.println();
      }
    }
    System.out.println(allowedMoves);
    //horizon



    // TODO Implement this!
    return allowedMoves;
  }
}
