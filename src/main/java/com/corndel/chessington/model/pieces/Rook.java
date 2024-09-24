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
    // TODO Implement this!
    var allowedMoves = new ArrayList<Move>();

    int totalCol = board.getBoard()[0].length;
    int totalRow = board.getBoard().length;
    int currentRow = from.getRow();
    int currentCol = from.getCol();

    var q = new ArrayList<List<Object>>(Arrays.asList(
            Arrays.asList(currentRow, currentCol + 1, "E"),
            Arrays.asList(currentRow, currentCol - 1, "W"),
            Arrays.asList(currentRow + 1, currentCol, "N"),
            Arrays.asList(currentRow - 1, currentCol, "S")
    ));

    while (q.size() > 0) {
      for (List<Object> direction : q) {
        int rowMove = (int) direction.get(0);
        int colMove = (int) direction.get(1);
        String direc = direction.get(1).toString();


        if ((rowMove >= 0 && rowMove < totalRow) && (colMove >= 0 && colMove < totalCol)) { //IF INBOUNDS
          Coordinates frontCoordinates = new Coordinates(rowMove, currentCol);
          Piece frontPiece = board.get(frontCoordinates);
          if (frontPiece != null) {  // A piece is found
            allowedMoves.add(new Move(from, frontCoordinates));
          } else {
            allowedMoves.add(new Move(from, frontCoordinates));
            if (direc == "S") {
              q.add(Arrays.asList(currentRow + 1, currentCol, "S"));
            } else if (direc == "N") {
              q.add(Arrays.asList(currentRow - 1, currentCol, "N"));
            } else if (direc == "W") {
              q.add(Arrays.asList(currentRow, currentCol - 1, "W"));
            } else if (direc == "S") {
              q.add(Arrays.asList(currentRow, currentCol + 1, "E"));
            }
          }
        }
      }
    }
    return allowedMoves;
  }
}
