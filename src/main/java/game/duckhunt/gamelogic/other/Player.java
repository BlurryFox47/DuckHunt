package game.duckhunt.gamelogic.other;

import game.duckhunt.gamelogic.cards.ActionCard;
import game.duckhunt.gamelogic.cards.PondCard;

import java.util.ArrayList;

public class Player {
    //attributes
    private ArrayList<PondCard> ducks;
    private ArrayList<ActionCard> hand;
    private static final int HAND_SIZE=3;
    //getters
    public static int getHAND_SIZE() {
        return HAND_SIZE;
    }
    //setters
    //constructors
    public Player() {
        ducks=new ArrayList<>();
        hand=new ArrayList<>();
    }
    //methods
    public void addDuck(PondCard duck){
        ducks.add(duck);
    }
    public void addCard(ActionCard card){
        hand.add(card);
    }
    public void printHand(){
        System.out.print("Player's Hand:\n");
        for (ActionCard actionCard : hand) {
            System.out.print(actionCard.getName()+"\t");
        }
        System.out.print("\n");
    }
}
