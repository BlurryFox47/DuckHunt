package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Pond;

public abstract class ActionCard extends Card {
    //attributes
    //getters
    //setters
    //constructors
    public ActionCard(String name) {
        super(name);
    }
    //methods
    public abstract void playCard(Pond pond) throws InvalidInputException;
}
