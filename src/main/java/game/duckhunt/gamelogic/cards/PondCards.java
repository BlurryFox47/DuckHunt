package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.other.Player;

public class PondCards extends Card {
    //attributes
    private Player player;
    //getters
    //setters
    //constructors
    public PondCards(String name) {
        super(name);
        this.player=null;
    }
    public PondCards(String name, Player player) {
        super(name);
        this.player = player;
    }
    //methods
}
