package cs3500.pyramidsolitaire.model.hw02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a basic game of solitaire where there is a pyramid of card with a given
 * number of rows.
 */
public class BasicPyramidSolitaire implements PyramidSolitaireModel<Card> {

  protected int numRows;
  protected int numDraw;
  protected List<Card> stock = new ArrayList<Card>();
  protected List<ArrayList<Card>> pyramid = new ArrayList<ArrayList<Card>>();
  protected boolean canStart;

  /**
   * Represents a basic game of solitaire with default values.
   */
  public BasicPyramidSolitaire() {
    numRows = 7;
    numDraw = 3;
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

    return loc;
  }


  /**
   * Determines whether every card is present in the given deck that is also in a valid deck,
   * with no extras.
   * @param other the given deck
   * @return if the deck is valid and complete
   */
  protected boolean checkDeck(List<Card> other) {
    List<Card> dCopy = new ArrayList<>();
    dCopy.addAll(other);
    List<Card> valid = this.getDeck();

    while (valid.size() != 0) {
      if (dCopy.size() == 0) {
        return false;
      } else if (dCopy.contains(valid.get(0))) {
        dCopy.remove(valid.get(0));
        valid.remove(0);
      } else {
        return false;
      }
    }

    return dCopy.size() == 0;
  }

  @Override
  public void startGame(List<Card> deck, boolean shuffle, int numRows, int numDraw)
      throws IllegalArgumentException {

    List<Card> dCopy = new ArrayList<Card>();

    if (deck == null) {
      throw new IllegalArgumentException("invalid inputs");
    }

    for (int i = 0; i < deck.size(); i++) {
      dCopy.add(deck.get(i));
    }

    //check if deck is valid, aka has all cards and no duplicates
    if (!checkDeck(dCopy)) {
      throw new IllegalArgumentException("Invalid Deck, Can't Start Game");
    }

    if (numRows <= 0) {
      throw new IllegalArgumentException("Negative rows are not allowed");
    }

    if (numDraw < 0) {
      throw new IllegalArgumentException("Negative draw cards are not allowed");
    }
    this.numRows = numRows;
    this.numDraw = numDraw;

    canStart = true;

    //make sure its an ok number w rows/draw
    int numCards = cardsNeeded();

    if (numCards > dCopy.size()) {
      throw new IllegalArgumentException("Not enough cards! Can't Start Game");
    }

    //shuffle
    if (shuffle) {
      List<Card> shuffled = new ArrayList<Card>();

      for (int i = 0; i < dCopy.size(); i++) {
        shuffled.add(dCopy.get(i));
      }

      for (int i = 0; i < shuffled.size(); i++) {
        Random rand = new Random();
        int spot = rand.nextInt(shuffled.size());

        dCopy.set(i, shuffled.get(spot));
        shuffled.remove(spot);
      }
    }
    makePyramid(dCopy);

  }


  /**
   * Create the pyramid, using a given deck and numRows. Also puts the extra cods in the stock.
   * @param dCopy the deck of Cards
   */
  protected void makePyramid(List<Card> dCopy) {

    int where = 0;

    for (int r = 0; r < numRows; r++) {
      ArrayList<Card> aloc = new ArrayList<Card>();

      for (int c = 0; c <= r; c++) {
        Card adding = dCopy.get(where);
        aloc.add(adding);
        where = where + 1;
      }
      pyramid.add(aloc);

    }

    //put the rest of the cards in the stock
    for (int i = where; i < dCopy.size(); i++) {
      stock.add(dCopy.get(i));
    }
  }


  /**
   * Determines how many cards are needed to construct the desired pyramid.
   * @return how many cards are needed to construct the pyramid
   */
  protected int cardsNeeded() {
    int num = 0;
    for (int i = 1; i <= numRows; i++) {
      num = num + i;
    }
    return num + numDraw;
  }

  /**
   * Determines if both cards infront of a given Card are null.
   * @param row the row index of the card
   * @param card the card index of the card
   * @return whether or not the card is exposed
   */
  protected boolean isExposed(int row, int card) {
    if (row == numRows - 1) {
      return true;
    }
    if (row > numRows || card > getRowWidth(row) - 1 || row < 0 || card < 0) {
      return false;
    }
    else {
      Card front1 = getCardAt(row + 1, card);
      Card front2 = getCardAt(row + 1, card + 1);

      return (front1 == null && front2 == null);
    }
  }

  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {
    started();

    Card one = getCardAt(row1, card1);
    Card two = getCardAt(row2, card2);


    if (one != null && two != null) {

      if (((one.getCardValue() + two.getCardValue() == 13)
          && isExposed(row1, card1) && isExposed(row2, card2))) {
        makeNull(row1, card1);
        makeNull(row2, card2);
      }
      else {
        throw new IllegalArgumentException("Can't Remove Those Cards");
      }
    }
    else {
      throw new IllegalArgumentException("Can't Remove Those Cards - One Or More Does Not Exist");
    }
  }

  @Override
  public void remove(int row, int card) throws IllegalArgumentException, IllegalStateException {
    started();

    Card removingC = getCardAt(row, card);


    if (removingC != null) {

      if (isExposed(row, card) && removingC.getCardValue() == 13) {
        makeNull(row, card);
      }
      else {
        throw new IllegalArgumentException("Can't Remove That Card");
      }
    }
    else {
      throw new IllegalArgumentException("Can't Remove Those Cards - One Or More Does Not Exist");
    }
  }

  /**
   * If a game has not started, throw an IllegalStateException.
   */
  protected void started() {
    if (!canStart) {
      throw new IllegalStateException("Game has not started yet");
    }
  }

  protected void makeNull(int row, int card) {
    pyramid.get(row).set(card, null);
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
      throws IllegalArgumentException, IllegalStateException {

    started();


    Card cPy = getCardAt(row, card);

    usableDraw(drawIndex);
    Card cDr = stock.get(drawIndex);


    if (cPy != null && cDr != null) {
      if (isExposed(row, card) && (cPy.getCardValue() + cDr.getCardValue() == 13)) {
        makeNull(row, card);
        stock.remove(drawIndex);
      }
      else {
        throw new IllegalArgumentException("Incorrect Pairing, can't remove card");
      }
    }
  }

  /**
   * if a given index does not correlate to a draw card, throws an exception.
   *
   * @param drawIndex the index of the desired draw card
   */
  protected void usableDraw(int drawIndex) {
    if ((drawIndex > numDraw) || (drawIndex > stock.size()) || drawIndex < 0) {
      throw new IllegalArgumentException("Invalid Draw Index");
    }
  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalArgumentException, IllegalStateException {
    started();

    usableDraw(drawIndex);


    stock.remove(drawIndex);

  }

  @Override
  public int getNumRows() {
    if (canStart) {
      return this.numRows;
    }
    else {
      return -1;
    }
  }

  @Override
  public int getNumDraw() {
    if (canStart) {
      return this.numDraw;
    } else {
      return -1;
    }
  }

  @Override
  public int getRowWidth(int row) throws IllegalArgumentException, IllegalStateException {
    started();

    if (row > numRows - 1 || row < 0) {
      throw new IllegalArgumentException("Invalid Row");
    }
    else {
      return row + 1;
    }
  }

  /**
   * determines if every Card in a given row of the pyramid is {@code null}.
   *
   * @return true of every Card in every row is null
   */
  protected boolean allEmpty() {

    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < getRowWidth(r); c++) {
        if (getCardAt(r, c) != null) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * creates a list of all Cards that are visible.
   *
   * @return a list of all Cards that are visible, and thus, can be removed
   */
  protected List<Card> getAllVisible() {
    List<Card> loc = new ArrayList<Card>();

    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < getRowWidth(r); c++) {
        if (isExposed(r, c)) {
          loc.add(getCardAt(r, c));
        }
      }
    }

    List<Card> lod = getDrawCards();
    for (int i = 0; i < lod.size(); i++) {
      loc.add(lod.get(i));
    }

    return loc;
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    started();

    if (this.getScore() == 0) {
      return true;
    }

    if (stock.size() != 0) {
      return false;
    }


    else {
      List<Card> loc = getAllVisible();
      for (int i = 0; i < loc.size() - getDrawCards().size(); i++) {
        for (int compare = i; compare < loc.size(); compare++) {
          Card one = loc.get(i);
          Card two = loc.get(compare);

          if (one != null && two != null) {
            if (one.getCardValue() + two.getCardValue() == 13) {
              return false;
            }
          }
        }
      }
      return true;
    }
  }

  @Override
  public int getScore() throws IllegalStateException {

    started();

    int score = 0;

    for (int o = 0; o < pyramid.size(); o++) {
      for (int i = 0; i < pyramid.get(o).size(); i++) {
        Card c = pyramid.get(o).get(i);
        if (c != null) {
          score += c.getCardValue();
        }
        else {
          score = score + 0;
        }
      }
    }
    return score;
  }

  @Override
  public Card getCardAt(int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    started();

    if (row >= pyramid.size() || row < 0) {
      throw new IllegalArgumentException("Invalid Row");
    } else if (card > (getRowWidth(row) - 1) || card < 0) {
      throw new IllegalArgumentException("Invalid Card");
    }

    Card copying = pyramid.get(row).get(card);
    if (copying != null) {
      return new Card(copying.getCardValue(), copying.getCardSuit());
    }
    else {
      return null;
    }
  }

  @Override
  public List<Card> getDrawCards() throws IllegalStateException {
    started();

    List<Card> lc = new ArrayList<Card>();

    if (stock.size() <= numDraw) {
      return stock;
    }
    else {
      for (int i = 0; i < numDraw; i++) {
        lc.add(stock.get(i));
      }
    }
    return lc;
  }
}
