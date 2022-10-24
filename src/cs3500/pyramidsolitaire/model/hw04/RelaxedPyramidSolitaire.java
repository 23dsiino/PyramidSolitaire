package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;


/**
 * A game of pyramid solitaire with more relaxed rules. The user can now remove two cards if one is
 * infront of the other.
 */
public class RelaxedPyramidSolitaire extends BasicPyramidSolitaire {

  /**
   * Constructs a game of pyramid solitaire with more relaxed rules, with default settings. The user
   * can now remove two cards if one is infront of the other.
   */
  public RelaxedPyramidSolitaire() {
    super();
  }

  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {
    started();

    Card one = getCardAt(row1, card1);
    Card two = getCardAt(row2, card2);

    if (one != null && two != null) {

      if (((card1 == card2) || (Math.abs(card1 - card2) == 1))
          && Math.abs(row1 - row2) == 1) {
        int lowRow = row2;
        int lowCard = card2;
        int highRow = row1;
        int highCard = card1;

        if (row1 > row2) {
          lowRow = row1;
          lowCard = card1;
          highCard = card2;
          highRow = row2;
        }

        if (isExposed(lowRow, lowCard) && (one.getCardValue() + two.getCardValue() == 13)
            && otherIsNull(highRow, highCard)) {
          makeNull(row1, card1);
          makeNull(row2, card2);
        }
      } else if (((one.getCardValue() + two.getCardValue() == 13)
          && isExposed(row1, card1) && isExposed(row2, card2))) {
        makeNull(row1, card1);
        makeNull(row2, card2);
      } else {
        throw new IllegalArgumentException("Can't Remove Those Cards");
      }
    } else {
      throw new IllegalArgumentException("One or both of those cards do not exist");
    }

  }

  /**
   * Checks that the other card infront of a card is null.
   *
   * @param row  the row of the card
   * @param card the card index of the card
   * @return if at least one of the cards infront of the given card is null
   */
  private boolean otherIsNull(int row, int card) {
    return (getCardAt(row + 1, card) == null
        || getCardAt(row + 1, card + 1) == null);
  }

}

