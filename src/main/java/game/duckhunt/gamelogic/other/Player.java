package game.duckhunt.gamelogic.other;

import game.duckhunt.gamelogic.cards.ActionCard;
import game.duckhunt.gamelogic.cards.PondCard;

import java.util.ArrayList;

public class Player {
    //attributes
    private String name;
    private ArrayList<PondCard> ducks;
    private ArrayList<ActionCard> hand;
    private static final int HAND_SIZE=3;
    //getters
    public static int getHAND_SIZE() {
        return HAND_SIZE;
    }
    public int getLives(){
        return ducks.size();
    }
    public String getName(){
        return this.name;
    }
    //setters
    //constructors
    public Player(String name) {
        ducks=new ArrayList<>();
        hand=new ArrayList<>();
        this.name=name;
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
        int i=1;
        for (ActionCard actionCard : hand) {
            System.out.print(i+" "+actionCard.getName()+"\t");
            ++i;
        }
        System.out.print("\n");
    }
    public void deleteDuck(PondCard duck){
        ducks.remove(duck);
    }
}
