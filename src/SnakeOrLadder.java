/*
An special square is a snake or a ladder
 */

public class SnakeOrLadder extends Square {
  private final int transport;

  public SnakeOrLadder(int pos, Board b, int trans) {
    super(pos, b);
    transport = trans;
  }

  @Override
  protected Square landHereOrGoHome() {
    String aux = "snake";
    if (transport > 0)
      aux = "ladder";

    System.out.println(aux + " from " + (position + 1) + " to "
        + (destination().getPosition() + 1));
    return destination().landHereOrGoHome();
  }

  private Square destination() {
    return findRelativeSquare(transport);
  }

}