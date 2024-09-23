package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class King implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;
  protected boolean moved = false;

  public King(PlayerColour colour) {
    this.type = PieceType.KING;
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
    //if (getColour().equals(PlayerColour.WHITE)) {
    var directions = new ArrayList<List<Integer>>(Arrays.asList(
            Arrays.asList(1, 0),
            Arrays.asList(1, 1),
            Arrays.asList(0, 1),
            Arrays.asList(-1, 0),
            Arrays.asList(-1, -1),
            Arrays.asList(-1, 1),
            Arrays.asList(-1, 1),
            Arrays.asList(1, -1)
    ));

    for (List<Integer> direction : directions){
      allowedMoves.add(new Move(from, from.plus(direction.get(0), direction.get(1))));
    }

    return allowedMoves;

  }
}
