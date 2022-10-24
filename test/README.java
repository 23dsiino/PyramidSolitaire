/**
 * explains what changes I made to my HW2.
 */
public class README {
  /*
  - In a lot of places, my code just assumed that the width  of a row was equal to
  the row number. Therefore, in many places I had to go in and change this to no
  longer be hardcoded and instead use the .getRowWidth function
- I also outsourced some of the work in startGame to helper functions. A lot of this function
did not change for the MultiPyramid class, so I made helpers for the parts that did and
just overrided those parts
- I also made helper functions and data members that were once private, protected. This
is because I needed to access many of them in my subclasses and could not if they were
private
- I also realized that my remove method was not throwing an error if one/both of the cards were null
- I changed the way I check if two decks are equals -- I no longer use containsAll


   */

}
