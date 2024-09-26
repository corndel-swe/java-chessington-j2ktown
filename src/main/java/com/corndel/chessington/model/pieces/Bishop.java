package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.List;

public class Bishop extends AbstractPiece {

//  private final Piece.PieceType type;
//  protected final PlayerColour colour;

  public Bishop(PlayerColour colour) {
    super(PieceType.BISHOP, colour);
    //this.type = PieceType.BISHOP;
    //this.colour = colour;
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
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    // TODO Implement this!
    return List.of();
  }
}
