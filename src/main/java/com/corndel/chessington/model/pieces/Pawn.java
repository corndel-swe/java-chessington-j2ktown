package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Pawn(PlayerColour colour) {
    this.type = PieceType.PAWN;
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
    var noCheckAllowedMoves = new ArrayList<Move>();

    int currentRow = from.getRow();
    int currentCol = from.getCol();
    int totalCol = board.getBoard()[0].length;
    int totalRow = board.getBoard().length;

    boolean whitePawnOutOfBounds = from.getRow() == 0;
    boolean blackPawnOutOfBounds = from.getRow() == totalRow-1;

    //check if out of bound if moved
    if (whitePawnOutOfBounds && getColour().equals(PlayerColour.WHITE))
      return allowedMoves;

    if (blackPawnOutOfBounds && getColour().equals(PlayerColour.BLACK))
      return allowedMoves;

    // check if a diagonal move can be made
    if (currentRow - 1 >= 0 && currentCol + 1 < totalCol) {
      Coordinates moveWhiteDiag = new Coordinates(currentRow - 1, currentCol + 1);
      Piece result = board.get(moveWhiteDiag);
      if (result != null) {
        noCheckAllowedMoves.add(new Move(from, moveWhiteDiag));
      }
    }

    if (currentRow - 1 >= 0 && currentCol - 1 >= 0) {
      Coordinates moveWhiteAntiDiag = new Coordinates(currentRow - 1, currentCol + 1);
      Piece result1 = board.get(moveWhiteAntiDiag);
      if (result1 != null) {
        noCheckAllowedMoves.add(new Move(from, moveWhiteAntiDiag));
      }
    }

    if (currentRow + 1 < totalRow && currentCol + 1 < totalCol) {
      Coordinates moveBlackAntiDiag = new Coordinates(currentRow + 1, currentCol + 1);
      Piece result3 = board.get(moveBlackAntiDiag);
      if (result3 != null) {
        noCheckAllowedMoves.add(new Move(from, moveBlackAntiDiag));
      }
    }

    if (currentRow + 1 < totalRow && currentCol - 1 >= 0) {
      Coordinates moveBlackDiag = new Coordinates(currentRow + 1, currentCol - 1);
      Piece result4 = board.get(moveBlackDiag);
      if (result4 != null){
        noCheckAllowedMoves.add(new Move(from, moveBlackDiag));
      }
    }



    if (getColour().equals(PlayerColour.WHITE)){
      if (currentRow == 6 ){
        allowedMoves.add(new Move(from, from.plus(-2, 0)));
      }
      allowedMoves.add(new Move(from, from.plus(-1, 0)));
    }

    else {
      if (currentRow == 1){
        allowedMoves.add(new Move(from, from.plus(2, 0)));
      }
      allowedMoves.add(new Move(from, from.plus(1, 0)));
    }

    // dont allow move if piece on that part of the board
    for (int i = allowedMoves.size() - 1; i >= 0; i--) {
      Move move = allowedMoves.get(i);
      Piece piece = board.get(move.getTo());
      if (piece != null) {
        allowedMoves.remove(i); // Remove the move if there's a piece at the destination
      }
    }


    // I had to add this as there wre some check when pawn take horizontal pieces that shouldnt apply to them.
    allowedMoves.addAll(noCheckAllowedMoves);
    // TODO Implement this!
    //return List.of();
    return allowedMoves;
  }
}
