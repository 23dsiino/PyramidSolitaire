package cs3500.pyramidsolitaire.model.hw04;


import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Factory class that creates a solitaire model depending on what type is wanted.
 */
public class PyramidSolitaireCreator {

  /**
   * Static enumeration representing the different types of pyramid solitaire.
   */
  public static enum GameType { BASIC, RELAXED,MULTIPYRAMID }

  /**
   * Factory method to return the proper type of solitaire, depending on the GameType parameter.
   * @param gt the desired GameType
   * @return the proper type of solitaire, depending on the GameType parameter
   */
  public static PyramidSolitaireModel<Card> create(GameType gt) {
    if (gt == GameType.BASIC) {
      return new BasicPyramidSolitaire();
    }
    else if (gt == GameType.MULTIPYRAMID) {
      return new MultiPyramidSolitaire();
    }
    else {
      return new RelaxedPyramidSolitaire();
    }

  }


}
