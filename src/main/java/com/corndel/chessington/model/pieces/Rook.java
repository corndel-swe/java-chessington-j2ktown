package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Rook implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Rook(PlayerColour colour) {
    this.type = PieceType.ROOK;
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

    int totalCol = board.getBoard()[0].length;
    int totalRow = board.getBoard().length;
    int currentRow = from.getRow();
    int currentCol = from.getCol();

    // Initialize directions with their row and column deltas
    var directions = new int[][]{
            {0, 1},   // East
            {0, -1},  // West
            {1, 0},   // South
            {-1, 0}   // North
    };

    // Process each direction
    for (int[] direction : directions) {
      int rowDelta = direction[0];
      int colDelta = direction[1];
      int rowMove = currentRow;
      int colMove = currentCol;

      // Continue moving in the current direction until we hit an edge
      while (true) {
        rowMove += rowDelta;
        colMove += colDelta;

        // Check if the new position is within bounds
        if (rowMove < 0 || rowMove >= totalRow || colMove < 0 || colMove >= totalCol) {
          break; // Out of bounds, stop moving in this direction
        }

        Coordinates newCoordinates = new Coordinates(rowMove, colMove);
        Piece targetPiece = board.get(newCoordinates);

        if (targetPiece != null) {
          // If the target piece is an opponent, we can capture it
          if (targetPiece.getColour() != this.getColour()) {
            allowedMoves.add(new Move(from, newCoordinates)); // Add capture move
          }
          break; // Stop moving in this direction after hitting a piece
        }

        // If the square is empty, we can move there
        allowedMoves.add(new Move(from, newCoordinates));
      }
    }

    return allowedMoves;
  }
}

