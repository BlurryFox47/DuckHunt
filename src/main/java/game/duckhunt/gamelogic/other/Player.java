package game.duckhunt.gamelogic.other;

import game.duckhunt.gamelogic.cards.ActionCard;
import game.duckhunt.gamelogic.cards.PondCard;

import java.util.ArrayList;

public class Player {
    //attributes
    private ArrayList<PondCard> ducks;
    private ArrayList<ActionCard> hand;
    //getters
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
}