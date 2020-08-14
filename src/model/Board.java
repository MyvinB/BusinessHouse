package model;

public class Board {
    int currentTurn=0;
    int totalPlayer=0;
    int noOfCells;
    Player[] players;
    Square[] squares;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    private Bank bank;

    public Board(int totalPlayer,int noOfCells,int moneyInBank,int playerAmount,int assets){
        this.noOfCells=noOfCells;
        players=new Player[totalPlayer];
        this.totalPlayer=totalPlayer;
        for(int i=0;i<totalPlayer;i++){
            players[i]=new Player(i,playerAmount,assets);
        }
        this.bank=new Bank(moneyInBank);
        this.squares=new Square[noOfCells+1];

    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setBoard(String type){
        //@param s dice o/p
        String s=type;
        int squareIdx=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==',')continue;
            if(s.charAt(i)=='J'){
                squares[squareIdx++]=new Jail("Jail");
            }
            else if(s.charAt(i)=='H'){
                squares[squareIdx++]=new Hotel("Hotel to be");
            }
            else if(s.charAt(i)=='L')
                squares[squareIdx++]=new Lottery("Lottery");
            else if(s.charAt(i)=='E')
                squares[squareIdx++]=new Empty("Empty");
        }
    }



    public Square movePlayer(Player player,int face){
        int newPosition=normalizePosition(player.getPosition()+face);
        player.setPosition(newPosition);
        try{
            squares[newPosition].doAction(player,this);
        }catch (Exception e){
            System.out.println(newPosition);
        }

        return squares[newPosition];
    }

    public int  normalizePosition(int position){
        return position%noOfCells==0?noOfCells: position%noOfCells;
    }

    public void nextTurn(){
        if(++currentTurn>= players.length){
            currentTurn=0;
        }
    }

    public Player getCurrentPlayer(){
        return players[currentTurn];
    }

    public Player getPlayer(int index){
        return players[index];
    }

}
