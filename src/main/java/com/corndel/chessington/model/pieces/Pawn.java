package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece{

//  private final Piece.PieceType type;
//  protected final PlayerColour colour;

  public Pawn(PlayerColour colour) {
    super(PieceType.PAWN, colour);
//    this.type = PieceType.PAWN;
//    this.colour = colour;
  }

  @Override
  public Piece.PieceType getType() {
    return super.getType();
  }

  @Override
  public PlayerColour getColour() {
    return super.colour;
  }

  @Override
  public String toString() {
    PlayerColour colour = super.getColour();
    return colour.toString() + " " + colour.toString();
    //return colour.toString() + " " + type.toString();
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    // return the list of the allowed moves:
    // 1. 1 in front if free in front
    // 2. left diagonal if opposite left diagonal
    // 3. right diagonal if opposite right diagonal
    // 4. 2 in front if first move
    // board:
    //   012
    // 0 -------- black
    // 1 --------
    // 2 --------
    // 3 --------
    // 4 --------
    // 5 --------
    // 6 --------
    // 7 -------- white

    // move = 1 if color = black
    // move = -1 if color = white
    //                r c
    // eg: position  [2,2]
    // white: {front:[1,2], diag_left = [1,1], diag_right = [1,3]}
    // black: {front:[3,2], diag_left = [3,1], diag_right = [3,3]}

    // front: [r+move,c], diag_left = [r+move, c-1], diag_right = [r+move, c+1], 2up = [r+2*move, c]

    var allowedMoves = new ArrayList<Move>();
    int currentRow = from.getRow();
    int currentCol = from.getCol();
    int totalCol = board.getBoard()[0].length;
    int totalRow = board.getBoard().length;

    var move = 1;
    if (getColour() == PlayerColour.WHITE) {move = -1;}

    // check one in front
    if (currentRow + move >=0 && currentRow + move < totalRow) {
      // valid posibility
      Coordinates frontCoordinates = new Coordinates(currentRow + move, currentCol);
      Piece frontPiece = board.get(frontCoordinates);
      if (frontPiece == null) {
        allowedMoves.add(new Move(from, frontCoordinates));
      }
    }

    // check two in front
    if ( ((getColour() == PlayerColour.WHITE && currentRow == totalRow - 2) ||
            (getColour() == PlayerColour.BLACK && currentRow == 1)) && !allowedMoves.isEmpty()) {
      // valid posibility
      Coordinates frontCoordinates = new Coordinates(currentRow + 2*move, currentCol);
      Piece frontPiece = board.get(frontCoordinates);
      if (frontPiece == null) {
        allowedMoves.add(new Move(from, frontCoordinates));
      }
    }

    // check diagonal left
    if (currentRow + move >=0 && currentRow + move < totalRow && currentCol-1>=0 && currentCol - 1 < totalCol) {
      Coordinates diagCoordinates = new Coordinates(currentRow + move, currentCol - 1);
      Piece diagPiece = board.get(diagCoordinates);
      if (diagPiece != null && diagPiece.getColour() != getColour()) {
        allowedMoves.add(new Move(from, diagCoordinates));
      }
    }

    // check diagonal right
    if (currentRow + move >=0 && currentRow + move < totalRow && currentCol+1>=0 && currentCol + 1 < totalCol) {
      Coordinates diagCoordinates = new Coordinates(currentRow + move, currentCol + 1);
      Piece diagPiece = board.get(diagCoordinates);
      if (diagPiece != null && diagPiece.getColour() != getColour()) {
        allowedMoves.add(new Move(from, diagCoordinates));
      }
    }

    return allowedMoves;
  }
}
