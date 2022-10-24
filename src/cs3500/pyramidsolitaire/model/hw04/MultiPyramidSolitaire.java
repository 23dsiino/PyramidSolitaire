package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import java.util.ArrayList;
import java.util.List;

/**
 * A game of solitaire in which there are three pyramids, overlapping
 * for half of their rows.
 */
public class MultiPyramidSolitaire extends BasicPyramidSolitaire {

  private int notOverlap;

  /**
   * Constructs a game of solitaire in which there are three pyramids, overlapping
   * for half of their rows, with default values.
   */
  public MultiPyramidSolitaire() {
    super();
  }

  @Override
  public List<Card> getDeck() {
    List<Card> loc = new ArrayList<Card>();

    for (int val = 1; val <= 13; val++) {
      loc.add(new Card(val, Suit.Clover));
      loc.add(new Card(val, Suit.Club));
      loc.add(new Card(val, Suit.Diamond));
      loc.add(new Card(val, Suit.Heart));
    }
    for (int val = 1; val <= 13; val++) {
      loc.add(new Card(val, Suit.Clover));
      loc.add(new Card(val, Suit.Club));
      loc.add(new Card(val, Suit.Diamond));
      loc.add(new Card(val, Suit.Heart));
    }

    return loc;
  }




  @Override
  protected void makePyramid(List<Card> dCopy) {
    int howMuchOverlap;
    if ((numRows % 2) == 0) {
      howMuchOverlap = numRows / 2;
    } else {
      howMuchOverlap = (numRows + 1) / 2;
    }

    this.notOverlap = numRows - howMuchOverlap;

    int where = 0;
    int numNull = notOverlap - 1;

    for (int r = 0; r < notOverlap; r++) {
      ArrayList<Card> aloc = new ArrayList<Card>();

      for (int i = 0; i < 3; i++) {
        for (int c = 0; c <= r; c++) {
          aloc.add(dCopy.get(where));
          where++;

        }
        if (i != 2) {
          for (int nn = 0; nn < numNull; nn++) {
            aloc.add(null);
          }
        }
      }

      pyramid.add(aloc);
      numNull = numNull - 1;
    }
    int startNumCards = ((notOverlap + 1) * 2) + notOverlap - 1;
    for (int r = notOverlap; r < numRows; r++) {
      ArrayList<Card> aloc = new ArrayList<Card>();

      for (int c = 0; c < startNumCards; c++) {
        Card adding = dCopy.get(where);
        aloc.add(adding);
        where = where + 1;
      }
      startNumCards++;
      pyramid.add(aloc);

    }

    //put the rest of the cards in the stock
    for (int i = where; i < dCopy.size(); i++) {
      stock.add(dCopy.get(i));
    }
  }

  @Override
  public int getRowWidth(int row) throws IllegalArgumentException, IllegalStateException {
    started();

    if (row > numRows - 1 || row < 0) {
      throw new IllegalArgumentException("Invalid Row");
    }
    else if (row < notOverlap) {
      return (3 * (row + 1)) + (2 * (notOverlap - 1 - row));
    }

    else {
      return row + 1 + (2 * row) + (2 * (notOverlap - row));
    }
  }

  @Override
  protected int cardsNeeded() {

    int num = 0;
    for (int i = 0; i < numRows; i++) {
      num = num + getRowWidth(i);
    }
    return num + numDraw;
  }

}
