package game.duckhunt.gamelogic.cards;

public abstract class Card {
    //attributes
    private String name;
    //getters
    public String getName() {
        return name;
    }
    //setters
    //constructors
    public Card() {
    }
    public Card(String name) {
        this.name = name;
    }
    //methods
}
