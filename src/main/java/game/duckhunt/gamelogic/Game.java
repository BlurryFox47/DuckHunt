package game.duckhunt.gamelogic;

import game.duckhunt.gamelogic.cards.*;
import game.duckhunt.gamelogic.other.Player;
import game.duckhunt.gamelogic.other.Pond;
import game.duckhunt.utility.KeyboardInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Game {
    //attributes
    private ArrayList<ActionCard> actionDeck;
    private ArrayList<Player> players;
    private Pond pond;
    private int numPlayers;
    //constants
    private final int NUM_AIM=10;
    private final int NUM_SHOOT=12;
    private final int NUM_WILD_BILL=2;
    private final int NUM_DUCK_MARCH=6;
    private final int NUM_TURBODUCK=1;
    private final int NUM_ROSHAMBO=2;
    private final int NUM_DUCK_DANCE=1;
    //getters
    //setters
    //constructors
    public Game() {
        setup();
        int safety=0;
        do {
            ++safety;
            for (Player player : players) {
                System.out.println("\n\n Turn of player "+player.getName());
                pond.printPond();
                player.printHand();
                System.out.print("\033[H\033[23");
                System.out.flush();

                //TODO player turnss
                //TODO at the of each players turn delete all players with zero duck
            }
        }while (safety<20);
        //}while (players.size()>1);

        //printAll();
    }
    //methods
    private void setup(){
        do {
            numPlayers=KeyboardInput.readInt("Enter number of players (2-6)");
        }while (numPlayers<2 || numPlayers>6);

        players=new ArrayList<>();
        for (int i = 0; i < numPlayers; ++i) {
            players.add(new Player(String.format("%d",i)));
        }
        pond=new Pond(numPlayers,players);
        setupActionDeck();
        dealCards();
    }
    private void setupActionDeck(){
        actionDeck=new ArrayList<>();
        for (int i = 0; i < NUM_AIM; ++i) {
            actionDeck.add(new ActionCardAim("Take aim"));
        }
        for (int i = 0; i < NUM_SHOOT; ++i) {
            actionDeck.add(new ActionCardShoot("Shoot!"));
        }
        for (int i = 0; i < NUM_WILD_BILL; ++i) {
            actionDeck.add(new ActionCardWildBill("Wild Bill"));
        }
        for (int i = 0; i < NUM_DUCK_MARCH; ++i) {
            actionDeck.add(new ActionCardDuckMarch("Duck March"));
        }
        for (int i = 0; i < NUM_TURBODUCK; ++i) {
            actionDeck.add(new ActionCardTurboduck("TURBODUCK!"));
        }
        for (int i = 0; i < NUM_ROSHAMBO; ++i) {
            actionDeck.add(new ActionCardRoshambo("Roshambo"));
        }
        for (int i = 0; i < NUM_DUCK_DANCE; ++i) {
            actionDeck.add(new ActionCardDuckDance("Duck dance"));
        }
        Collections.shuffle(actionDeck);
    }
    private void dealCards(){
        for (int i = 0; i < Player.getHAND_SIZE(); ++i) {
            for (Player player : players) {
                player.addCard(actionDeck.remove(0));            }
        }
    }

    private void printAll(){
        pond.printPond();
        System.out.print("\n");
        for (Player player : players) {
            player.printHand();
        }
    }
}
