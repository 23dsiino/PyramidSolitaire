package cs3500.pyramidsolitaire.model.hw02;


/**
* Represents a playing card in a game.
*/
public class Card {

  private int value;
  private Suit suit;

  /**
   * Constructs a playing card in terms of its value, (with ace as 1 and so on, until King as 13),
   * and its suit.
   *
   * @param value the value of the card, with ace as 1
   * @param suit  the suit of the card (must be one of, Club, Clover, Diamond or Heart)
   */
  public Card(int value, Suit suit) {
    if (value > 13) {
      throw new IllegalArgumentException("Not a possible card value");
    }
    else {
      this.value = value;
      this.suit = suit;
    }
  }

  /**
   * determines the Suit of a card.
   * @return the suit of a given Card Object
   */
  public Suit getCardSuit() {
    return suit;
  }

  /**
   * determines the value of a card.
   * @return the value of a given Card Object
   */
  public int getCardValue() {
    return value;
  }

  /**
  * determines if two cards are of the same suit and have the same value.
  * @param obj the Object that is being determined as equal, or not equal, to {@code this}
  * @return if the given Object is the same as this card
  */
  public boolean equals(Object obj) {
    if (!(obj instanceof Card)) {
      return false;
    }
    Card that = (Card) obj;

    return this.value == that.value && this.suit.equals(that.suit);
  }

  /**
   * creates a hash code for a given card.
   * @return the hashCode of a given Card
  */
  public int hashCode() {
    return value * suit.hashCode();
  }

  /**
  * creates a String representation of this card.
  * @return a String representation of this card
  */
  public String toString() {

    if (this == null) {
      return ".  ";
    }

    String result = "";

    switch (suit) {
      case Clover:
        result = "♣";
        break;
      case Heart:
        result = "♥";
        break;
      case Diamond:
        result = "♦";
        break;
      case Club:
        result = "♠";
        break;
      default:
        result = "";
        break;
    }

    if (value == 1) {
      result = "A" + result;
    }
    else if (value < 10) {
      result = Integer.toString(value) + result;
    }
    else if (value == 10) {
      result = Integer.toString(value) + result;
    }
    else if (value == 11) {
      result = "J" + result;
    }
    else if (value == 12) {
      result = "Q" + result;
    }
    else if (value == 13) {
      result = "K" + result;
    }
    return result;
  }


}
