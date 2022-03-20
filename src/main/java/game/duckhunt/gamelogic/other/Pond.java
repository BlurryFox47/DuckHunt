package game.duckhunt.gamelogic.other;

import game.duckhunt.gamelogic.cards.ActionCard;
import game.duckhunt.gamelogic.cards.PondCard;
import game.duckhunt.gamelogic.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Collections;

public class Pond {
    //attributes
    private final int POND_SIZE = 6;
    private final int CARDS_PER_PLAYER = 5;
    private ArrayList<Boolean> aim;
    private ArrayList<PondCard> pondDeck;
    private ArrayList<PondCard> pond;
    //getters
    public Boolean getAimed(int index){
        return aim.get(index);
    }
    public PondCard getPondSpace(int index){
        return pond.get(index);
    }
    public ArrayList<PondCard> getPond() {
        return pond;
    }
    public ArrayList<PondCard> getPondDeck() {
        return pondDeck;
    }

    public int getPOND_SIZE() {
        return POND_SIZE;
    }

    //setters
    public void setAimed(int index, boolean aiming) {
        aim.set(index,aiming);
    }
    //constructors
    public Pond(int numPlayers, ArrayList<Player> players) {
        setupAim();
        setupPondDeck(players);
        setupPond();
    }
    //methods
    private void setupAim(){
        aim=new ArrayList<>();
        for (int i = 0; i < POND_SIZE;  ++i) {
            aim.add(false);
        }
    }
    private void setupPondDeck(ArrayList<Player> players){
        pondDeck=new ArrayList<>();
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            pondDeck.add(new PondCard("Water"));
        }
        PondCard card;
        int j=0; //player counter
        for (Player player : players) {
            ++j;
            for (int i = 0; i < CARDS_PER_PLAYER; ++i) {
                card=new PondCard("Duck of player "+ player.getName(),player);
                pondDeck.add(card);
                player.addDuck(card);
            }
        }
        Collections.shuffle(pondDeck);
    }
    private void setupPond(){
        pond=new ArrayList<>();
        for (int i = 0; i < POND_SIZE; i++) {
            pond.add(pondDeck.remove(0));
        }
    }
    public void printPond(){
        for (int i = 0; i < POND_SIZE; ++i) {
            if (aim.get(i))
                System.out.println((i+1)+". Aimed at\t"+ pond.get(i).getName());
            else
                System.out.println((i+1)+". Not aimed at\t"+ pond.get(i).getName());
        }
    }
    public void killDuck(int index){
        PondCard tmp=pond.remove(index);
        tmp.getPlayer().deleteDuck(tmp);
        pond.add(pondDeck.remove(0));
        setAimed(index,false);
    }
    public boolean has6aim(boolean type){
        int count=0;
        if (type){
            for (boolean aimed : aim) {
                if (aimed){
                    ++count;
                }
            }
        }else{
            for (boolean aimed : aim) {
                if (!aimed){
                    ++count;
                }
            }
        }
        return count == POND_SIZE;
    }
}
