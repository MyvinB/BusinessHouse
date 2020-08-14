package model;/*
 @author Myvin Barboza
 14/08/20 4:31 PM 
 */

public class Jail extends Square  {
    private final int jailFine=150;

    public Jail(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        board.getBank().getMoney().addMoney(jailFine);
        player.getMoney().substractMoney(jailFine);
    }
}
