package cs3500.pyramidsolitaire.view;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

import java.io.IOException;
import java.util.List;

/**
 * visual representation of a model of solitaire game.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {

  private final PyramidSolitaireModel<?> model;
  private final Appendable ap;


  /**
   * creates a view Object for a game of Pyramid Solitaire that displays cards textually.
   * @param model the model that the view is representing
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {
    this.model = model;
    ap = new StringBuilder();

  }

  /**
   * creates a view Object for a game of Pyramid Solitaire that displays cards textually.
   * @param model the model that the view is representing
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable ap) {
    this.model = model;
    this.ap = ap;
  }

  @Override
  public void render() throws IOException {
    ap.append(this.toString());
  }

  /**
   * determines if a row only contains null values.
   * @param r the row in the pyramid
   * @return if the row contains only null values
   */
  private boolean rowAllNull(int r) {

    for (int i = 0; i <= model.getRowWidth(r); i++) {
      if (model.getCardAt(r, i) != null) {
        return false;
      }
    }
    return true;

  }



  /**
   if the game is over, return the score. If game is won, return that they won
   else, just return a visual representation of each card in the current board
   */
  @Override
  public String toString() {
    try {
      // see if game started
      model.getScore();

      //if they won
      if (model.getScore() == 0) {
        return "You win!";
      }

      //if there are no more moves
      else if (model.isGameOver()) {
        return "Game over. Score: " + model.getScore();
      }
      //display the board
      else {
        String returning = "";

        int maxLength = (3 * model.getRowWidth(model.getNumRows() - 1))
            +  model.getRowWidth(model.getNumRows() - 1) - 1;


        //get the individual row
        for (int r = 0; r < model.getNumRows(); r++) {

          String rowS = "";

          //if it is empty, just print an empty line
          if (rowAllNull(r)) {
            rowS = "/n";
          }
          else {
            //put the correct amount of spaces before the cards
            int s = (maxLength - (3 * (model.getRowWidth(r)) + model.getRowWidth(r) - 1)) / 2;
            for (int spaces = 0; spaces < s; spaces++) {
              rowS = rowS + " ";
            }

            //print out each card, with a space before
            for (int c = 0; c < model.getRowWidth(r); c++) {
              String card;
              Object ca = model.getCardAt(r, c);
              if (ca == null) {
                if (c != model.getRowWidth(r) - 1) {
                  card = ".  ";
                }
                else {
                  card = ".";
                }
              }
              else {
                card = ca.toString();
              }

              if (card.length() == 2 && (c != model.getRowWidth(r) - 1)) {
                card = card + " ";
              }
              rowS = rowS + " " + card;

            }
          }

          //add this row to the overall
          returning = returning + rowS.substring(1) + "\n";
        }

        //add the draw pile
        String rowD = "Draw:";
        List<?> lo = this.model.getDrawCards();
        for (int i = 0; i < lo.size(); i++) {
          rowD = rowD + ", " + lo.get(i).toString();
        }

        returning = returning  + rowD.replaceFirst(",", "");

        //return the diagram
        return returning;
      }
    }
    catch (IllegalStateException ise) {
      return "";
    }


  }

}
