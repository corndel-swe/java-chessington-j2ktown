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

    var directions = new int[][]{
            {-1, 0},
            {-1, 1},
            {-1, -1},
            {1, 0},
            {1, 1},
            {1, -1},
            {0, -1},
            {0, 1},
    };


    for (int[] direction : directions) {
      int currentRow = from.getRow();
      int currentCol = from.getCol();
      int rowDelta = direction[0];
      int colDelta = direction[1];

      while (true) {
        currentRow += rowDelta;
        currentCol += colDelta;

        // check if out of bounds
        if (currentRow < 0 || currentRow >= totalRow || currentCol < 0 || currentCol >= totalCol) {
          break;
        }

        // check if there is a piece there. If there is check if its same colour
        Coordinates location = new Coordinates(currentRow, currentCol);
        Piece piece = board.get(location);
        if (piece != null) {
          if (piece.getColour() != this.getColour()) {
            allowedMoves.add(new Move(from, location));
          }
          break;
        }
        allowedMoves.add(new Move(from, location));
      }
    }
    return allowedMoves;
  }
}

