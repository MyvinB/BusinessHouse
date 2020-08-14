package model;/*
 @author Myvin Barboza
 14/08/20 5:21 PM 
 */

public class Bank {
private  Money money;



    public Bank(int initialAmount) {
       money = new Money(initialAmount);
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
