import java.util.ArrayList;

public final class Board {
  private ArrayList<Square> squares = new ArrayList<>();
  private static final int MIN_NUM_SQUARES = 10;

  public Board(int numSquares, int[][] ladders, int[][] snakes, int[] deathSquares) {
    assert numSquares > MIN_NUM_SQUARES : "There must be at least " + MIN_NUM_SQUARES + " squares";
    makeSquares(numSquares);
    makeSnakeOrLadders(ladders);
    makeSnakeOrLadders(snakes);
    makeDeaths(deathSquares);
  }

  public Square firstSquare() {
    return squares.get(0);
  }

  public Square lastSquare() {
    return squares.get(squares.size() - 1);
  }

  public Square findSquare(int position) {
    assert (position > 0) && (position < numberOfSquares()) : "inexistent square";
    return squares.get(position);
  }

  public int numberOfSquares() {
    assert !squares.isEmpty();
    return squares.size();
  }

  private void makeSquares(int numSquares) {
    System.out.println("There are " + numSquares + " squares");
    squares.add(new FirstSquare(this));
    for (int position = 1; position < numSquares; position++) {
      Square square = new Square(position, this);
      squares.add(square);
    }
    assert squares.get(numSquares - 1).isLastSquare();
  }

  private void makeSnakeOrLadders(int[][] toFrom) {
    for (int[] specialSquare : toFrom) {
      assert specialSquare.length == 2;

      int fromPosition = specialSquare[0] - 1;
      int toPosition = specialSquare[1] - 1;
      int transport = toPosition - fromPosition;

      String typeSpecialSquare = "snake";
      if (transport > 0) {
        typeSpecialSquare = "ladder";
        assert transport > 0 : "In " + typeSpecialSquare + ", origin equal or after destination";
        assert (toPosition < numberOfSquares()) && (toPosition > 0);
        assert (fromPosition > 0) && (fromPosition < numberOfSquares());
      } else {
        assert transport < 0 : "In snake, destination equal or after origin";
        assert (toPosition > 0) && (toPosition < numberOfSquares() - 1);
        assert (fromPosition < numberOfSquares() - 1) && (fromPosition > 0);
      }

      System.out.println(typeSpecialSquare + " from " + (fromPosition + 1) + " to " + (toPosition + 1));
      squares.set(fromPosition, new SnakeOrLadder(fromPosition, this, transport));
    }
  }

  private void makeDeaths(int[] deathSquares) {
    for (int deathSquare : deathSquares) {
      squares.set(deathSquare, new Death(deathSquare, this));
    }
  }
}
