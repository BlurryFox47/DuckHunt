package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.other.Player;

public class PondCard extends Card {
    //attributes
    private Player player;
    //getters

    public Player getPlayer() {
        return player;
    }

    //setters
    //constructors
    public PondCard(String name) {
        super(name);
        this.player=null;
    }
    public PondCard(String name, Player player) {
        super(name);
        this.player=player;
    }
    //methods
}
