
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * tests methods within the model.
 */
public class RelaxedPyramidModelTests {

  RelaxedPyramidSolitaire bps1;
  RelaxedPyramidSolitaire bps2;
  RelaxedPyramidSolitaire bps3;
  RelaxedPyramidSolitaire bps32;
  RelaxedPyramidSolitaire bps4;
  RelaxedPyramidSolitaire bps5;
  RelaxedPyramidSolitaire bps6;


  Card cl1;
  Card cl2;
  Card cl3;
  Card cl4;
  Card cl5;
  Card cl6;
  Card cl7;
  Card cl8;
  Card cl9;
  Card cl10;
  Card cl11;
  Card cl12;
  Card cl13;

  Card cb1;
  Card cb2;
  Card cb3;
  Card cb4;
  Card cb5;
  Card cb6;
  Card cb7;
  Card cb8;
  Card cb9;
  Card cb10;
  Card cb11;
  Card cb12;
  Card cb13;

  Card d1;
  Card d2;
  Card d3;
  Card d4;
  Card d5;
  Card d6;
  Card d7;
  Card d8;
  Card d9;
  Card d10;
  Card d11;
  Card d12;
  Card d13;

  Card h1;
  Card h2;
  Card h3;
  Card h4;
  Card h5;
  Card h6;
  Card h7;
  Card h8;
  Card h9;
  Card h10;
  Card h11;
  Card h12;
  Card h13;

  List<Card> loc;
  List<Card> loc2;
  List<Card> loc3;
  List<Card> loc32;
  List<Card> loc4;

  PyramidSolitaireTextualView ptv1;


  @Before
  public void initConditions() {

    bps1 = new RelaxedPyramidSolitaire();

    bps2 = new RelaxedPyramidSolitaire();
    bps2.startGame(bps2.getDeck(), false, 2, 3);

    bps3 = new RelaxedPyramidSolitaire();
    bps3.startGame(bps3.getDeck(), false, 3, 4);

    bps4 = new RelaxedPyramidSolitaire();
    bps4.startGame(bps4.getDeck(), false, 7, 3);

    cl1 = new Card(1, Suit.Clover);
    cl2 = new Card(2, Suit.Clover);
    cl3 = new Card(3, Suit.Clover);
    cl4 = new Card(4, Suit.Clover);
    cl5 = new Card(5, Suit.Clover);
    cl6 = new Card(6, Suit.Clover);
    cl7 = new Card(7, Suit.Clover);
    cl8 = new Card(8, Suit.Clover);
    cl9 = new Card(9, Suit.Clover);
    cl10 = new Card(10, Suit.Clover);
    cl11 = new Card(11, Suit.Clover);
    cl12 = new Card(12, Suit.Clover);
    cl13 = new Card(13, Suit.Clover);

    cb1 = new Card(1, Suit.Club);
    cb2 = new Card(2, Suit.Club);
    cb3 = new Card(3, Suit.Club);
    cb4 = new Card(4, Suit.Club);
    cb5 = new Card(5, Suit.Club);
    cb6 = new Card(6, Suit.Club);
    cb7 = new Card(7, Suit.Club);
    cb8 = new Card(8, Suit.Club);
    cb9 = new Card(9, Suit.Club);
    cb10 = new Card(10, Suit.Club);
    cb11 = new Card(11, Suit.Club);
    cb12 = new Card(12, Suit.Club);
    cb13 = new Card(13, Suit.Club);

    d1 = new Card(1, Suit.Diamond);
    d2 = new Card(2, Suit.Diamond);
    d3 = new Card(3, Suit.Diamond);
    d4 = new Card(4, Suit.Diamond);
    d5 = new Card(5, Suit.Diamond);
    d6 = new Card(6, Suit.Diamond);
    d7 = new Card(7, Suit.Diamond);
    d8 = new Card(8, Suit.Diamond);
    d9 = new Card(9, Suit.Diamond);
    d10 = new Card(10, Suit.Diamond);
    d11 = new Card(11, Suit.Diamond);
    d12 = new Card(12, Suit.Diamond);
    d13 = new Card(13, Suit.Diamond);

    h1 = new Card(1, Suit.Heart);
    h2 = new Card(2, Suit.Heart);
    h3 = new Card(3, Suit.Heart);
    h4 = new Card(4, Suit.Heart);
    h5 = new Card(5, Suit.Heart);
    h6 = new Card(6, Suit.Heart);
    h7 = new Card(7, Suit.Heart);
    h8 = new Card(8, Suit.Heart);
    h9 = new Card(9, Suit.Heart);
    h10 = new Card(10, Suit.Heart);
    h11 = new Card(11, Suit.Heart);
    h12 = new Card(12, Suit.Heart);
    h13 = new Card(13, Suit.Heart);

    loc3 = Arrays.asList(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10,
        h11, h12, h13, cl1, cl2, cl3, cl4, cl5, cl6, cl7, cl8, cl9, cl10, cl11,
        cl12, cl13, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8,
        cb9, cb10, cb11, cb12, cb13, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13);
    loc4 = Arrays.asList(h1, h12, h13, h4, h5, h6, h7, h8, h9, h10,
        h11, h2, h3, cl1, cl2, cl3, cl4, cl5, cl6, cl7, cl8, cl9, cl10, cl11,
        cl12, cl13, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8,
        cb9, cb10, cb11, cb12, cb13, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13);

    bps32 = new RelaxedPyramidSolitaire();

    bps5 = new RelaxedPyramidSolitaire();
    bps5.startGame(bps5.getDeck(), false, 8, 0);

    bps6 = new RelaxedPyramidSolitaire();
    bps6.startGame(loc4, false, 2, 0);



    loc = new ArrayList<Card>();
    loc.add(h1);
    loc.add(cl2);
    loc.add(cb2);

    loc2 = new ArrayList<Card>();

    ptv1 = new PyramidSolitaireTextualView(bps2);

  }

  //make sure that the draw cards are the next ones after the pyramid is delt
  @Test
  public void testGetDrawCards() {
    assertEquals(loc, bps2.getDrawCards());
    assertEquals(loc2, bps5.getDrawCards());
  }


  //if game hasnt started, can't get draw cards
  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardsError() {
    bps1.getDrawCards();
  }

  //returns the card at the correct location in the pyramid
  @Test
  public void testGetCardAt() {
    assertEquals(d1, bps4.getCardAt(1, 1));
    assertEquals(cl1, bps2.getCardAt(0, 0));
  }

  //if game hasn't started, can't get a card at a position
  @Test(expected = IllegalStateException.class)
  public void testGetCardAtError() {
    bps1.getCardAt(1, 2);
  }

  //if row is too high, can't get card
  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtError2() {
    bps4.getCardAt(20, 2);
  }

  //if row is negative, can't get card
  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtError3() {
    bps4.getCardAt(-1, 2);
  }

  //if card# is too high, can't get card
  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtError4() {
    bps4.getCardAt(2, 20);
  }

  //if card# is negative, can't get card
  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAtError5() {
    bps4.getCardAt(1, -4);
  }

  //can't get score if game has not started
  @Test(expected = IllegalStateException.class)
  public void testGetScoreError() {
    bps1.getScore();
  }

  //return the correct score
  @Test
  public void testGetScore() {
    assertEquals(112, bps4.getScore());
  }

  //return the correct score
  @Test
  public void testGetScore2() {
    assertEquals(8, bps3.getScore());
  }

  //returns the correct width (i.e. how many cards are in said row)
  @Test
  public void testGetRowWidth() {
    assertEquals(4, bps4.getRowWidth(3));
    assertEquals(1, bps3.getRowWidth(0));
  }

  //if game has not started, can't get a row width
  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthError() {
    bps1.getRowWidth(1);
  }

  //throws an error if the given row is too high
  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthError2() {
    bps4.getRowWidth(200);
  }

  //throws an error if the given row is too low
  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthError3() {
    bps4.getRowWidth(-2);
  }

  //allows for a valid removeUsingDraw
  @Test
  public void removeUsingDrawValid() {
    bps1.startGame(bps1.getDeck(), false, 6, 8);
    bps1.removeUsingDraw(7, 5, 2);
    assertEquals(null, bps1.getCardAt(5, 2));
  }

  //says that game is over when game is really over
  @Test
  public void testGameReallyOver() {
    bps1.startGame(bps1.getDeck(), false, 1, 50);
    bps1.removeUsingDraw(46, 0, 0);

    assertEquals(true, bps1.isGameOver());
  }

  //says that game is not over when game is still going
  @Test
  public void testGameNotOver() {
    bps1.startGame(bps1.getDeck(), false, 7, 3);

    assertEquals(false, bps1.isGameOver());
  }

  //if gameStarted is called after game has started, reset game accordingly
  @Test
  public void testRestartGame() {
    bps1.startGame(bps1.getDeck(), false, 7, 3);
    bps1.startGame(bps1.getDeck(), false, 5, 3);

    assertEquals(5, bps1.getNumRows());
  }


  //returns the correct number of draw cards, or -1 if the game has not started
  @Test
  public void testNumDraw() {
    assertEquals(7, bps4.getNumRows());
    assertEquals(2, bps2.getNumRows());
    assertEquals(-1, bps1.getNumRows());
  }

  //returns the correct number of rows, or -1 if the game has not started
  @Test
  public void testNumRows() {
    assertEquals(3, bps4.getNumDraw());
    assertEquals(4, bps3.getNumDraw());
    assertEquals(-1, bps1.getNumDraw());
  }

  //if the game has not started, can't discard a draw card
  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawError1() {
    bps1.discardDraw(1);
  }

  //if the given index is too high, can't discard said card
  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawError2() {
    bps2.discardDraw(7);
  }

  //if the given index is too low, can't discard said card
  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawError3() {
    bps2.discardDraw(-1);
  }

  //makes sure that the cards shift over when a card is discarded
  @Test
  public void testDiscardDraw() {
    bps4.discardDraw(0);
    assertEquals(cb8, bps4.getDrawCards().get(0));
  }

  //can't discard if they don't add to 13
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawError() {
    bps4.removeUsingDraw(0, 6, 5);

  }

  //can't discard if the draw index is invalid
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawError3() {
    bps4.removeUsingDraw(200, 6, 5);

  }

  //can't discard if the card# is invalid
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawError4() {
    bps4.removeUsingDraw(0, 3, 5);

  }

  //can't discard if the game has not started
  @Test(expected = IllegalStateException.class)
  public void testRemoveingUsingDrawError2() {
    bps1.removeUsingDraw(2, 3, 4);
  }

  //can't remove if the game has not started
  @Test(expected = IllegalStateException.class)
  public void testRemoveError() {
    bps1.remove(1, 1);
  }

  //can't remove if the card is not exposed
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveError2() {
    bps4.remove(6, 2);
  }

  //can't remove if the card does not exist
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveError3() {
    bps4.remove(7, 2);
  }

  //can't remove if the game has not started
  @Test(expected = IllegalStateException.class)
  public void testRemoveError4() {
    bps1.remove(1, 1, 2, 3);
  }

  //can't remove if one or more of the cards dont equal 13
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveError5() {
    bps4.remove(6, 2, 6, 0);
  }

  //can't remove if the first card isn't exposed
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveError6() {
    bps4.remove(2, 2, 6, 1);
  }

  //can't remove if the second card is not exposed
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveError7() {
    bps4.remove(6, 2, 3, 1);
  }

  //can't remove if you have the same card twice
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveError8() {
    bps4.remove(3, 1, 3, 1);
  }

  //able to remove if the two cards are a valid match
  @Test
  public void testRemove() {
    bps4.remove(6, 0, 6, 6);
    assertEquals(null, bps4.getCardAt(6, 0));
    assertEquals(null, bps4.getCardAt(6, 6));
  }


  //make sure that you can remove if one card is infront of the other
  //first card on bottom
  @Test
  public void testRelaxedRemove() {
    bps6.remove(1, 1);
    bps6.remove(1, 0, 0, 0);

    assertEquals(null, bps6.getCardAt(1, 0));
    assertEquals(null, bps6.getCardAt(0, 0));
  }

  //make sure that you can remove if one card is infront of the other
  //first card on top
  @Test
  public void testRelaxedRemove2() {
    bps6.remove(1, 1);
    bps6.remove(0, 0, 1, 0);

    assertEquals(null, bps6.getCardAt(1, 0));
    assertEquals(null, bps6.getCardAt(0, 0));
  }

  //every card exists in the deck when getDeck is called (i.e. all 13 cards in all 4 suits)
  @Test
  public void testGetDeck() {
    List<Card> deck = bps1.getDeck();

    assertEquals(true, deck.containsAll(loc3));
    assertEquals(true, loc3.containsAll(deck));
  }

  //toString returns the correct representation
  @Test
  public void testToString() {
    assertEquals("  A♣\nA♠  A♦\nDraw: A♥, 2♣, 2♠", ptv1.toString());
  }

  //can't start the game with an invalid deck
  @Test(expected = IllegalArgumentException.class)
  public void startGameError() {
    bps32.startGame(loc32, false, 3, 7);
  }

  //can't start the game if there are not enough cards in the deck to fufill row requirements
  @Test(expected = IllegalArgumentException.class)
  public void startGameError2() {
    bps32.startGame(bps4.getDeck(), false, 300, 7);
  }

  //can't start the game with a non-postive number of rows
  @Test(expected = IllegalArgumentException.class)
  public void startGameError3() {
    bps32.startGame(bps4.getDeck(), false, -3, 7);
  }

  //can't start the game with a negative amount of draw cards
  @Test(expected = IllegalArgumentException.class)
  public void startGameError4() {
    bps32.startGame(bps4.getDeck(), false, 3, -7);
  }

  //can't start the game with a null deck
  @Test(expected = IllegalArgumentException.class)
  public void startGameError5() {
    bps32.startGame(null, false, 4, 7);
  }

  //the cards are suffled when asked to be
  @Test
  public void testStartGameShuffle() {
    bps1.startGame(loc3, true, 3, 2);

    assertNotEquals(bps1.getDrawCards(), loc);
  }

  //toString for the Card class works correctly
  @Test
  public void testCardToString() {

    assertEquals("2♣", cl2.toString());
    assertEquals("K♥", h13.toString());
  }


}
