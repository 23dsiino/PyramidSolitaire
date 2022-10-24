package cs3500.pyramidsolitaire;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Allows you to actually play a game of Pyramid Solitaire.
 */
public final class PyramidSolitaire {

  /**
   * The main method.
   *
   * @param args inputs to start the game
   */
  public static void main(String[] args) {
    int rows = 7;
    int draw = 3;
    PyramidSolitaireCreator psc = new PyramidSolitaireCreator();
    PyramidSolitaireModel<Card> mod = new BasicPyramidSolitaire();
    Appendable ap = System.out;
    Readable rd = new BufferedReader(new InputStreamReader(System.in));

    if (args.length > 0) {
      String game = args[0];
      if (game.equals("basic")) {
        mod = psc.create(PyramidSolitaireCreator.GameType.BASIC);
      }
      if (game.equals("relaxed")) {
        mod = psc.create(PyramidSolitaireCreator.GameType.RELAXED);
      }
      if (game.equals("multipyramid")) {
        mod = psc.create(PyramidSolitaireCreator.GameType.MULTIPYRAMID);
      }
    }

    if (args.length > 1) {
      try {
        int tryR = Integer.parseInt(args[2]);
        if (tryR > 0) {
          rows = tryR;
        }
      } catch (NumberFormatException e) {
        rows = 7;
      }
    }
    if (args.length > 2) {
      try {
        int tryR = Integer.parseInt(args[2]);
        if (tryR > 0) {
          draw = tryR;
        }
      } catch (NumberFormatException e) {
        draw = 3;
      }
    }

    PyramidSolitaireController cont = new PyramidSolitaireTextualController(rd, ap);
    cont.playGame(mod, mod.getDeck(), true, rows, draw);
  }
}
