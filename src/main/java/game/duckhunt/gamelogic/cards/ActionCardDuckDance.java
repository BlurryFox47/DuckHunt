package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Pond;

import java.util.Collections;

public class ActionCardDuckDance extends ActionCard {
    //attributes
    //getters
    //setters
    //constructors
    public ActionCardDuckDance(String name) {
        super(name);
    }
    //methods

    @Override
    public void playCard(Pond pond) {
        for (int i = 0; i < pond.getPOND_SIZE(); ++i) {
            pond.getPondDeck().add(pond.getPond().remove(0));
        }
        Collections.shuffle(pond.getPondDeck());
        for (int i = 0; i < pond.getPOND_SIZE(); ++i) {
            pond.getPond().add(pond.getPondDeck().remove(0));
        }
    }
}
