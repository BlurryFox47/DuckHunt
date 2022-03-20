package game.duckhunt.gamelogic.cards;

import game.duckhunt.gamelogic.exceptions.InvalidInputException;
import game.duckhunt.gamelogic.other.Pond;
import game.duckhunt.utility.KeyboardInput;

public class ActionCardWildBill extends ActionCard {
    //attributes
    //getters
    //setters
    //constructors
    public ActionCardWildBill(String name) {
        super(name);
    }
    //methods

    @Override
    public void playCard(Pond pond) throws InvalidInputException {
        int pondIndex= KeyboardInput.readInt("Select an aimed upon pond space to shoot at (1-6)");
        if (pondIndex<1 || pondIndex>6) {
            throw new InvalidInputException("You selected incorrect pond space\n");
        }
        --pondIndex;
        if (pond.getPondSpace(pondIndex).getName().equals("Water")){
            throw new InvalidInputException("You cannot use Wild Bill at Water");
        }else {
            pond.killDuck(pondIndex);
        }
    }
}
