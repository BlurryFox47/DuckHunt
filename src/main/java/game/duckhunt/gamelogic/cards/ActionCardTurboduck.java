package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Pond;
import game.duckhunt.utility.KeyboardInput;

public class ActionCardTurboduck extends ActionCard {
    //attributes
    //getters
    //setters
    //constructors
    public ActionCardTurboduck(String name) {
        super(name);
    }
    //methods

    @Override
    public void playCard(Pond pond) throws InvalidInputException {
        int pondIndex= KeyboardInput.readInt("Select a duck to become a TURBODUCK (1-6)");
        if (pondIndex<1 || pondIndex>6) {
            throw new InvalidInputException("You selected incorrect pond space\n");
        }
        //TODO check for duck only
        pond.getPond().add(pond.getPond().remove(pondIndex-1));
        for (int i = 0; i < pond.getPOND_SIZE()-1; ++i) {
            pond.getPond().add(pond.getPond().remove(0));
        }
    }
}
