package game.duckhunt.gamelogic.other;

import game.duckhunt.gamelogic.cards.PondCards;
import java.util.ArrayList;

public class Pond {
    //attributes
    private final int POND_SIZE = 6;
    private ArrayList<Boolean> aim;
    private ArrayList<PondCards> pondDeck;
    private ArrayList<PondCards> pond;
    //getters
    //setters
    //constructors
    public Pond(int numPlayers) {
        setupAim();
    }
    //methods
    private void setupAim(){
        aim=new ArrayList<>();
        for (int i = 0; i < POND_SIZE;  ++i) {
            aim.add(false);
        }
    }
    private void setupPondDeck(){
        pondDeck=new ArrayList<>();

    }
    private void setupPond(){
        pond=new ArrayList<>();

    }
}
