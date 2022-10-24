import static org.junit.Assert.assertEquals;


import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import cs3500.pyramidsolitaire.view.PyramidSolitaireView;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * tests for the PyramidSolitaireTextualController.
 */


public class ControllerTests {

  protected class BadAppendable implements Appendable {

    @Override
    public Appendable append(CharSequence csq) throws IOException {
      throw new IOException("bad");
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
      throw new IOException("bad");
    }

    @Override
    public Appendable append(char c) throws IOException {
      throw new IOException("bad");
    }
  }


  Appendable out;
  PyramidSolitaireModel<Card> bps1;
  String ninePyramid;
  String ninePyramidScore;
  String sevenPyramid;
  String sevenPyramidNulls;
  String sevenPyramidScore;
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
  List<Card> loc1;


  @Before
  public void initConditions() {
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

    loc = Arrays.asList(h1, h12, h3, h4, h5, h6, h7, h8, h9, h10,
        h11, h2, h13, cl1, cl2, cl3, cl4, cl5, cl6, cl7, cl8, cl9, cl10, cl11,
        cl12, cl13, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8,
        cb9, cb10, cb11, cb12, cb13, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13);
    loc1 = Arrays.asList(h1, h13, h3, h4, h5, h6, h7, h8, h9, h10,
        h11, h2, h12, cl1, cl2, cl3, cl4, cl5, cl6, cl7, cl8, cl9, cl10, cl11,
        cl12, cl13, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8,
        cb9, cb10, cb11, cb12, cb13, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13);

    out = new StringBuffer();
    bps1 = new BasicPyramidSolitaire();
    ninePyramid = "                A♣\n"
        + "              A♠  A♦\n"
        + "            A♥  2♣  2♠\n"
        + "          2♦  2♥  3♣  3♠\n"
        + "        3♦  3♥  4♣  4♠  4♦\n"
        + "      4♥  5♣  5♠  5♦  5♥  6♣\n"
        + "    6♠  6♦  6♥  7♣  7♠  7♦  7♥\n"
        + "  8♣  8♠  8♦  8♥  9♣  9♠  9♦  9♥\n"
        + "10♣ 10♠ 10♦ 10♥ J♣  J♠  J♦  J♥  Q♣\n";
    sevenPyramid = "            A♣\n"
        + "          A♠  A♦\n"
        + "        A♥  2♣  2♠\n"
        + "      2♦  2♥  3♣  3♠\n"
        + "    3♦  3♥  4♣  4♠  4♦\n"
        + "  4♥  5♣  5♠  5♦  5♥  6♣\n"
        + "6♠  6♦  6♥  7♣  7♠  7♦  7♥\n";
    sevenPyramidNulls = "            A♣\n"
        + "          A♠  A♦\n"
        + "        A♥  2♣  2♠\n"
        + "      2♦  2♥  3♣  3♠\n"
        + "    3♦  3♥  4♣  4♠  4♦\n"
        + "  4♥  5♣  5♠  5♦  5♥  6♣\n"
        + ".   6♦  6♥  7♣  7♠  7♦  .\n";
    sevenPyramidScore = "Score: 112\n";
    ninePyramidScore = "Score: 276\n";
  }


  @Test
  //make sure that you can play a game through to a win
  public void testWinGame() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("rmwd 1 1 1");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, loc, false, 1, 3);
    assertEquals("A♥\nDraw: Q♥, 3♥, 4♥\nScore: 1\nYou win!", out.toString());
  }

  @Test
  //make sure that you can play a game through to a loss
  //also makes sure that the correct function is called when dd is entered
  public void testLoseGame() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("dd 1 dd 1 dd 1 dd 1 dd 1 dd 1 dd 1 dd 1");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 9, 3);
    assertEquals(ninePyramid + "Draw: Q♠, Q♦, Q♥\n" + ninePyramidScore
            + ninePyramid + "Draw: Q♦, Q♥, K♣\n" + ninePyramidScore
            + ninePyramid + "Draw: Q♥, K♣, K♠\n" + ninePyramidScore
            + ninePyramid + "Draw: K♣, K♠, K♦\n" + ninePyramidScore
            + ninePyramid + "Draw: K♠, K♦, K♥\n" + ninePyramidScore
            + ninePyramid + "Draw: K♦, K♥\n" + ninePyramidScore
            + ninePyramid + "Draw: K♥\n" + ninePyramidScore + "Game over. Score: 276",
        out.toString());
  }

  @Test
  //make sure that if negative draw cards and/or rows are asked for, play with default settings
  public void goToDefaults() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("q");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, -9, -3);
    assertEquals(sevenPyramid + "Draw: 8♣, 8♠, 8♦\n" + sevenPyramidScore
        + "Game quit!\nState of game when quit:\n"
        + sevenPyramid + "Draw: 8♣, 8♠, 8♦\nScore: 112", out.toString());
  }

  @Test(expected = IllegalStateException.class)
  //if IOException is thrown, throw an IllegalStateException
  public void testIllegalStateException() {
    Appendable out = new BadAppendable();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("q");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 9, 3);
  }


  @Test
  //make sure game is quit if given command is quit
  public void testQuitCommand() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("dd 1 q 1 dd ");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 9, 3);
    assertEquals(ninePyramid + "Draw: Q♠, Q♦, Q♥\n" + ninePyramidScore
            + ninePyramid + "Draw: Q♦, Q♥, K♣\n" + ninePyramidScore
            + "Game quit!\nState of game when quit:\n" + ninePyramid
            + "Draw: Q♦, Q♥, K♣\nScore: 276", out.toString());
  }

  @Test
  //make sure game is quit, even if after getting a given command, the user enters q
  public void testQuitCommand2() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("dd 1 rm1 1 q 1 dd ");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 9, 3);
    assertEquals(ninePyramid + "Draw: Q♠, Q♦, Q♥\n" + ninePyramidScore
            + ninePyramid + "Draw: Q♦, Q♥, K♣\n" + ninePyramidScore
            + "Game quit!\nState of game when quit:\n" + ninePyramid
            + "Draw: Q♦, Q♥, K♣\nScore: 276", out.toString());
  }

  @Test
  //if no more commands are present, end game
  public void testOutOfCommands() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("dd 1 ");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 9, 3);
    assertEquals(ninePyramid + "Draw: Q♠, Q♦, Q♥\n" + ninePyramidScore
        + ninePyramid + "Draw: Q♦, Q♥, K♣", out.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  //if model is null, throw an IllegalArgumentException
  public void testNullModel() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = null;
    Readable in = new StringReader("dd 1 rm2 3 nj 9 k 190 rm1 3 4 5 6");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, loc, false, 9, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  //if appendable is null, throw an IllegalArgumentException
  public void testNullAppend() {
    Appendable out = null;
    Readable in = new StringReader("dd 1 rm2 3 nj 9 k 190 rm1 3 4 5 6");
    PyramidSolitaireController c = new PyramidSolitaireTextualController(in, out);
  }

  @Test (expected = IllegalArgumentException.class)
  //if readable is null, throw an IllegalArgumentException
  public void testNullReadable() {
    Appendable out = new StringBuffer();
    Readable in = null;
    PyramidSolitaireController c = new PyramidSolitaireTextualController(in, out);
  }

  @Test
  //returns correct String if a move is invalid (as determined by the model)
  //does not propgate the error from the model
  public void testInvalidMove() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("rm1 7 2");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 9, 3);
    assertEquals(ninePyramid + "Draw: Q♠, Q♦, Q♥\n" + ninePyramidScore
        + "Invalid move. Play again. *Can't Remove That Card\n"
        + ninePyramid + "Draw: Q♠, Q♦, Q♥", out.toString());
  }

  @Test
  //keep looking for next call until one is valid
  public void testKeepLooking() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("rm1 j 9 2");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 9, 3);
    assertEquals(ninePyramid + "Draw: Q♠, Q♦, Q♥\n" + ninePyramidScore
        + "Invalid move. Play again. *Can't Remove That Card\n"
        + ninePyramid + "Draw: Q♠, Q♦, Q♥", out.toString());
  }

  @Test
  //keep looking for next call until one is valid
  public void testKeepLooking2() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("j rm1 9 2");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 9, 3);
    assertEquals(ninePyramid + "Draw: Q♠, Q♦, Q♥\n" + ninePyramidScore
        + "Invalid move. Play again. *Can't Remove That Card\n"
        + ninePyramid + "Draw: Q♠, Q♦, Q♥", out.toString());
  }

  @Test
  //if given an invalid number of rows/draw cards, call with the default settings
  public void testGoToDefault() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("q");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 20, 4);
    assertEquals(sevenPyramid + "Draw: 8♣, 8♠, 8♦\n" + sevenPyramidScore
        + "Game quit!\nState of game when quit:\n"
        + sevenPyramid + "Draw: 8♣, 8♠, 8♦\nScore: 112", out.toString());
  }

  @Test
  //calls correct function when rm1 is entered
  public void testRm1() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("rm1 2 1");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, loc1, false, 2, 4);
    assertEquals("  A♥\nK♥  3♥\nDraw: 4♥, 5♥, 6♥, 7♥\nScore: 17\n  A♥\n.   3♥\n"
        + "Draw: 4♥, 5♥, 6♥, 7♥", out.toString());
  }

  @Test
  //calls correct function when rm2 is entered
  public void testRm2() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("rm2 7 1 7 7");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, bps1.getDeck(), false, 7, 3);
    assertEquals(sevenPyramid + "Draw: 8♣, 8♠, 8♦\n" + sevenPyramidScore
        + sevenPyramidNulls + "Draw: 8♣, 8♠, 8♦", out.toString());
  }

  @Test
  //make sure that the correct function is called when rmwd is entered
  public void testRmwd() {
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    Readable in = new StringReader("rmwd 1 1 1");

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(in, out);
    cont.playGame(bps1, loc, false, 1, 3);
    assertEquals("A♥\nDraw: Q♥, 3♥, 4♥\nScore: 1\nYou win!", out.toString());
  }

  @Test
  //make sure that render works correctly
  public void testRender() {
    String output = sevenPyramid + "Draw: 8♣, 8♠, 8♦";
    Appendable out = new StringBuffer();
    PyramidSolitaireModel<Card> bps1 = new BasicPyramidSolitaire();
    bps1.startGame(bps1.getDeck(), false, 7, 3);

    PyramidSolitaireView psv = new PyramidSolitaireTextualView(bps1, out);
    try {
      psv.render();
    }
    catch (IOException e) {
      output = "Appendable threw IOException";
    }

    assertEquals(output, out.toString());
  }

}
