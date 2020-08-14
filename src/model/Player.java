package model;

public class Player {
    int totalWalk=0;
    int position=0;
    private int id;
    private String name;
    private Money money;
    private Money assets;

    public Player(int id,int initialMoney,int assets) {
        this.id = id;
        this.money=new Money(initialMoney);
        this.assets=new Money(assets);
    }

    public int getTotalWalk() {
        return totalWalk;
    }

    public void setTotalWalk(int totalWalk) {
        this.totalWalk = totalWalk;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Money getAssets() {
        return assets;
    }

    public void setAssets(Money assets) {
        this.assets = assets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
