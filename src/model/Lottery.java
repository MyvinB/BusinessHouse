package model;/*
 @author Myvin Barboza
 14/08/20 4:23 PM 
 */

public class Lottery extends Square  {
    private final int lottery=200;

    public Lottery(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        board.getBank().getMoney().substractMoney(lottery);
        player.getMoney().addMoney(lottery);
    }
}
