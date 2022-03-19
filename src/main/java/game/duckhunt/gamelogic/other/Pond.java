package game.duckhunt.gamelogic.other;

import game.duckhunt.gamelogic.cards.Card;
import game.duckhunt.gamelogic.cards.PondCards;
import java.util.ArrayList;

public class Pond {
    //attributes
    private final int POND_SIZE = 6;
    private final int CARDS_PER_PLAYER = 5;
    private ArrayList<Boolean> aim;
    private ArrayList<PondCards> pondDeck;
    private ArrayList<PondCards> pond;
    //getters
    //setters
    //constructors
    public Pond(int numPlayers, ArrayList<Player> players) {
        setupAim();
        setupPondDeck(players);
        setupPond();
    }
    //methods
    private void setupAim(){
        aim=new ArrayList<>();
        for (int i = 0; i < POND_SIZE;  ++i) {
            aim.add(false);
        }
    }
    private void setupPondDeck(ArrayList<Player> players){
        pondDeck=new ArrayList<>();
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            pondDeck.add(new PondCards("Voda"));
        }
        PondCards card;
        for (Player player : players) {
            for (int i = 0; i < CARDS_PER_PLAYER; ++i) {
                pondDeck.add(new PondCards("Duck player "+i,player));
            }
        }
    }
    private void setupPond(){
        pond=new ArrayList<>();

    }
}
