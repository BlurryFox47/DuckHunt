package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Pond;

public class ActionCardDuckMarch  extends ActionCard {
    //attributes
    //getters
    //setters
    //constructors
    public ActionCardDuckMarch(String name) {
        super(name);
    }
    //methods
    @Override
    public void playCard(Pond pond) {
        pond.getPondDeck().add(pond.getPond().remove(0));
        pond.getPond().add(pond.getPondDeck().remove(0));
    }
}
