package game.duckhunt.gamelogic.other;

import game.duckhunt.gamelogic.cards.PondCard;
import java.util.ArrayList;
import java.util.Collections;

public class Pond {
    //attributes
    private final int POND_SIZE = 6;
    private final int CARDS_PER_PLAYER = 5;
    private ArrayList<Boolean> aim;
    private ArrayList<PondCard> pondDeck;
    private ArrayList<PondCard> pond;
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
            pondDeck.add(new PondCard("Voda"));
        }
        PondCard card;
        int j=0; //player counter
        for (Player player : players) {
            ++j;
            for (int i = 0; i < CARDS_PER_PLAYER; ++i) {
                card=new PondCard("Duck player "+ j,player);
                pondDeck.add(card);
                player.addDuck(card);
            }
        }
        Collections.shuffle(pondDeck);
    }
    private void setupPond(){
        pond=new ArrayList<>();
        for (int i = 0; i < POND_SIZE; i++) {
            pond.add(pondDeck.remove(0));
        }
    }
    public void printPond(){
        for (int i = 0; i < POND_SIZE; ++i) {
            if (aim.get(i))
                System.out.println((i+1)+". Aimed at\t"+ pond.get(i).getName());
            else
                System.out.println((i+1)+". Not aimed at\t"+ pond.get(i).getName());
        }
    }
}
