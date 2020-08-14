package model;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public void addMoney(int amount){
        this.money+=amount;
    }
    
    public void substractMoney(int amount){
        this.money-=amount;
    }
    
    
}
