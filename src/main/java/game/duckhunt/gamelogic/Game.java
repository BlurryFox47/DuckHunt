package game.duckhunt.gamelogic;

import game.duckhunt.gamelogic.cards.*;
import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Player;
import game.duckhunt.gamelogic.other.Pond;
import game.duckhunt.utility.KeyboardInput;

import java.util.ArrayList;
import java.util.Collections;

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
        int chosenCardIndex;

        do {
            ++safety;
            for (Player player : players) {
                System.out.println("\n\n Turn of player "+player.getName());
                System.out.println("Turn Num: "+safety);
                pond.printPond();
                player.printHand();

                //TODO check if player can play a card
                playCard(player);

                System.out.println("Islo nam to dalej");

                //TODO player turnss
                //TODO at the of each players turn delete all players with zero duck
            }
        }while (safety<20);
        //}while (players.size()>1);

        //printAll();
    }

    private void playCard(Player player) {
        int chosenCardIndex;
        boolean played=false;
        do {
            chosenCardIndex=chooseCard();
            played=player.playCard(chosenCardIndex-1,pond);
        }while (!played);
        actionDeck.add(player.discard(chosenCardIndex-1));
        player.addCard(actionDeck.remove(0));
    }
    private int chooseCard() {
        int chosenCard;
        do {
            chosenCard=KeyboardInput.readInt("\nChoose which card to play (1-3)");
            if (chosenCard<1 || chosenCard>3){
                try {
                    throw new InvalidInputException("Choose curd number 1,2 or 3");
                } catch (InvalidInputException e) {
                    System.out.print(e.getMessage());
                }
            }
        }while (chosenCard<1 || chosenCard>3);
        return chosenCard;
    }

    //methods
    private void setup(){
        do {
            numPlayers=KeyboardInput.readInt("Enter number of players (2-6)");
        }while (numPlayers<2 || numPlayers>6);
        players=new ArrayList<>();
        String playerName;
        for (int i = 0; i < numPlayers; ++i) {
            playerName=KeyboardInput.readString("Enter name of player "+(i+1));
            players.add(new Player(playerName));
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

    public void play(){

    }
}
