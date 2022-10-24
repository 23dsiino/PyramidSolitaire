package cs3500.pyramidsolitaire.controller;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import cs3500.pyramidsolitaire.view.PyramidSolitaireView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * controller for a game of pyramid solitaire. Reads input from the user decides what to do with it,
 * and prints output.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {

  private final Appendable a;
  private final Scanner scan;
  private List<Integer> spots;


  /**
   * Constructs a controller for a game of pyramid solitaire.
   *
   * @param rd allows the controller to read inputs
   * @param ap allows the controller to print outputs
   */
  public PyramidSolitaireTextualController(Readable rd, Appendable ap) {

    //check if null
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Null Argument");
    }

    this.a = ap;
    scan = new Scanner(rd);
    spots = new ArrayList<Integer>();

  }

  @Override
  public <K> void playGame(PyramidSolitaireModel<K> model, List<K> deck, boolean shuffle,
      int numRows, int numDraw) {
    boolean isQuit = false;

    //make sure the model is not null
    if (model == null) {
      throw new IllegalArgumentException("Model is null");
    }

    //try catch block to catch errors with Appendables and Readables
    try {
      PyramidSolitaireView psv = new PyramidSolitaireTextualView(model, a);

      //if rows or draw are invalid, play game with defaults
      try {
        model.startGame(deck, shuffle, numRows, numDraw);
      } catch (IllegalArgumentException e) {
        model.startGame(deck, shuffle, 7, 3);
      }

      boolean done = false;
      //keep running through the steps until the game ends
      while (!done) {

        //display board
        psv.render();
        a.append("\n");
        a.append("Score: " + model.getScore() + "\n");

        String command = "";
        boolean gotCommand = false;

        //read in the next command
        while (!gotCommand && scan.hasNext()) {
          command = scan.next();
          spots = new ArrayList<Integer>();
          int howMany = 0;

          switch (command) {
            case "rm1":
              gotCommand = true;
              howMany = 2;
              break;
            case "rm2":
              gotCommand = true;
              howMany = 4;
              break;
            case "rmwd":
              gotCommand = true;
              howMany = 3;
              break;
            case "dd":
              gotCommand = true;
              howMany = 1;
              break;
            case "q":
            case "Q":
              gotCommand = true;
              done = true;
              isQuit = true;
              break;
            default:
              gotCommand = false;
              break;
          }

          if (!done) {

            //keep reading until there is an adequate amount of correct inputs
            for (int i = 0; i < howMany; i++) {
              boolean isGood = false;
              while (!isGood && !scan.hasNext("q") && !scan.hasNext("Q")
                  && scan.hasNext()) {
                isGood = getGoodDigit();
              }

              //if the next input is a quit, quit game
              if (!isGood && (scan.hasNext("q") || scan.hasNext("Q"))) {
                isQuit = true;
                done = true;
                i = howMany;
              }
              //if there are no more inputs, end game
              if (!isGood && !scan.hasNext()) {
                done = true;
                gotCommand = true;
                i = howMany;
              }
            }
          }

          //process the command
          if (!done && gotCommand) {
            try {
              process(command, model);
            }
            //if it is an invalid move, ask the user to try again
            catch (IllegalArgumentException e) {
              a.append("Invalid move. Play again. *" + e.getMessage() + "\n");
              gotCommand = false;
            }
          }
          //if the game is over, or there are no more inputs, end game
          if (model.isGameOver() || !scan.hasNext()) {
            done = true;
            gotCommand = true;
          }
        }

      }

      //if the game was quit, display quit message
      if (isQuit) {
        a.append("Game quit!\nState of game when quit:\n");
        psv.render();
        a.append("\nScore: " + model.getScore());
      }
      //display the final view of the board
      else if (done) {
        psv.render();
      }

    } catch (IOException e) {
      throw new IllegalStateException("Controller can't read input or print output");
    }
  }

  /**
   * calls the correct function on the model, depending on what command is given.
   *
   * @param command signifies what method should be called
   * @param model   the model on which the command will be called
   * @param <K>     the type of Object that the model works with
   */
  private <K> void process(String command, PyramidSolitaireModel<K> model) {
    switch (command) {
      case "rm1":
        model.remove(spots.get(0), spots.get(1));
        break;
      case "rm2":
        model.remove(spots.get(0), spots.get(1), spots.get(2), spots.get(3));
        break;
      case "rmwd":
        model.removeUsingDraw(spots.get(0), spots.get(1), spots.get(2));
        break;
      case "dd":
        model.discardDraw(spots.get(0));
        break;
      default:
        break;
    }
  }

  /**
   * if the next input is an integer, add it to {@code this.spots}, if not return false and skip.
   *
   * @return whether or not a digit was added to {@code this.spots}
   */
  private boolean getGoodDigit() {
    if (scan.hasNextInt()) {
      spots.add(Integer.parseInt(scan.next()) - 1);
      return true;
    } else {
      scan.next();
      return false;
    }
  }
}

