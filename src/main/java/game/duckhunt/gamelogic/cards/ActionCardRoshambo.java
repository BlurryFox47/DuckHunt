package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Pond;

import java.util.Collections;

public class ActionCardRoshambo extends ActionCard {
    //attributes
    //getters
    //setters
    //constructors
    public ActionCardRoshambo(String name) {
        super(name);
    }
    //methods

    @Override
    public void playCard(Pond pond) {
        Collections.shuffle(pond.getPond());
    }
}
