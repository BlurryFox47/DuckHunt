package game.duckhunt.gamelogic;

import game.duckhunt.gamelogic.cards.ActionCard;
import game.duckhunt.gamelogic.other.Player;
import game.duckhunt.gamelogic.other.Pond;
import game.duckhunt.utility.KeyboardInput;

import java.util.ArrayList;

public class Game {
    //attributes
    private ArrayList<ActionCard> actionDeck;
    private ArrayList<Player> players;
    private Pond pond;
    private int numPlayers;
    //getters
    //setters
    //constructors
    public Game() {
        this.setup();
    }
    //methods
    private void setup(){
        do {
            numPlayers=KeyboardInput.readInt("Enter number of players (2-6)");
        }while (numPlayers<2 || numPlayers>6);
        for (int i = 0; i < numPlayers; ++i) {
            players.add(new Player());
        }
        pond=new Pond(numPlayers,players);
    }
}
