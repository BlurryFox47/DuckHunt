package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Pond;
import game.duckhunt.utility.KeyboardInput;

public class ActionCardShoot extends ActionCard {
    //attributes
    //getters
    //setters
    //constructors

    public ActionCardShoot(String name) {
        super(name);
    }

    //methods
    @Override
    public void playCard(Pond pond) throws InvalidInputException {
        int pondIndex= KeyboardInput.readInt("Select an aimed upon pond space to shoot at (1-6)");
        if (pondIndex<1 || pondIndex>6) {
            throw new InvalidInputException("You selected incorrect pond space\n");
        }
        if (!(pond.getAimed(pondIndex))){
            throw new InvalidInputException("This pond space is NOT aimed at. You cannot shoot here\n");
        }
        if (pond.getPondSpace(pondIndex).getName().equals("Water")){
            pond.setAimed(pondIndex,false);
        }else {
            pond.killDuck(pondIndex);
        }
    }

}
