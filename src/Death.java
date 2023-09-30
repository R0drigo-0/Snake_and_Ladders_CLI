public class Death extends Square {
  public Death(int pos, Board b) {
    super(pos, b);
  }
  public void enter(Player p) {
    p.setDead(true);
  }
}
