import enums.HotelType;
import model.Board;
import model.Hotel;
import model.Player;

public class Game {

    Board board;
    public Game(int totalPlayer,int noOfCells,int bankMoney,int playerAmount,int assets){
        board=new Board(totalPlayer,noOfCells,bankMoney,playerAmount,assets);

    }

    void startGame(String dice){
        String[] diceAr =dice.split(",");
        int i=0;
        while(i<diceAr.length){
            int diceNumber=Integer.parseInt(diceAr[i++]);
            board.movePlayer(board.getCurrentPlayer(),diceNumber);
            board.nextTurn();
        }
    }

    void stats(){
        for(Player player:board.getPlayers()){
            System.out.println("Player "+player.getId()+"has a total momey of "+player.getMoney().getMoney()+" assets"+player.getAssets().getMoney());
        }
        System.out.println(board.getBank().getMoney().getMoney());
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static void main(String[] args) {
        Game game=new Game(3,10,5000,1000,0);
        String dice="2,2,1,4,4,2,4,4,2,2,2,1,4,4,2,4,4,2,2,2,1";
        String boardSet="J,H,L,H,E,L,H,L,H,J";
        game.getBoard().setBoard(boardSet);
        game.startGame(dice);
        game.stats();

        Game game2=new Game(3,10,5000,1000,0);
        String dice2="2,2,1,4,2,3,4,1,3,2,2,7,4,7,2,4,4,2,2,2,2";
        game2.getBoard().setBoard(boardSet);
        game2.startGame(dice2);
        game2.stats();
    }

}
