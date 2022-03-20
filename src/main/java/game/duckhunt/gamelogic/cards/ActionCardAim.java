package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Pond;
import game.duckhunt.utility.KeyboardInput;

public class ActionCardAim extends ActionCard {
    //attributes
    //getters
    //setters
    //constructors
    public ActionCardAim(String name) {
        super(name);
    }
    //methods

    @Override
    public void playCard(Pond pond) throws InvalidInputException {
        int pondIndex=KeyboardInput.readInt("Select a pond space to take aim at (1-6)");
        if (pondIndex<1 || pondIndex>6) {
            throw new InvalidInputException("You selected incorrect pond space\n");
        }
        if (pond.getAimed(pondIndex)){
            throw new InvalidInputException("This pond space is already aimed at\n");
        }
        pond.setAimed(pondIndex-1,true);
    }
}
