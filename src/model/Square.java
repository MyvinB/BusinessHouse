package model;

public abstract class Square {
    String name;

    public Square(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void doAction(Player player,Board board);

}
