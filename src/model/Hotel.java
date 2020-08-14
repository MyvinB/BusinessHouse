package model;

import enums.HotelType;

public  class Hotel extends Square  {
    private int price;
    private int owner=-1;
    private HotelType hotelType;




    public Hotel(String name){
        super(name);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    @Override
    public void doAction(Player player, Board board) {

        if(owner<0){
            this.owner=player.getId();
            this.hotelType=HotelType.SILVER;
            int money=this.getHotelType().getValue();
            board.getBank().getMoney().addMoney(money);
            player.getMoney().substractMoney(money);
            player.getAssets().addMoney(money);
        }
        else{
            if(owner!=player.getId()){
                int rent=this.hotelType.getRent();
                player.getMoney().substractMoney(rent);
                board.getPlayer(owner).getMoney().addMoney(rent);
            }
            else{
                if(this.hotelType==HotelType.SILVER){
                    int diffMoney=HotelType.GOLD.getValue()-this.getHotelType().getValue();
                    this.hotelType=HotelType.GOLD;
                    board.getBank().getMoney().addMoney(diffMoney);
                    player.getMoney().substractMoney(diffMoney);
                    player.getAssets().addMoney(diffMoney);
                }
                else if(this.hotelType==HotelType.GOLD){
                    int diffMoney=HotelType.PLATINUM.getValue()-this.getHotelType().getValue();
                    this.hotelType=HotelType.PLATINUM;
                    board.getBank().getMoney().addMoney(diffMoney);
                    player.getMoney().substractMoney(diffMoney);
                    player.getAssets().addMoney(diffMoney);
                }
            }
        }

    }
}
