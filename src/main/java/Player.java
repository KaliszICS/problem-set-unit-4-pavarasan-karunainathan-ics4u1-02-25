import java.util.ArrayList;

/**
 * The {@link Player} class, with a name, age and hand of {@link Card}s.
 * @author Pavarasan Karunainathan
 * @version 17.0.1
 */
public class Player{
    private String name;
    private int age;
    private ArrayList<Card> hand = new ArrayList<Card>();

    /**
     * Constructor of the {@link Player} class, where the {@code hand} is given.
     * Will ignore any {@code null} {@link Card}s in the array.
     * @param name The name of the {@link Player}.
     * @param age The age of the {@link Player}.
     * @param hand The {@link Player}'s current hand, an array of {@link Card}s.
     */
    public Player(String name, int age, Card[] hand){
        this.name = name;
        this.age = age;
        for(int i = hand.length-1; i >= 0; --i){ // iterating in reverse to preserve order of cards
            Card c = hand[i];
            if(c != null){
                this.hand.add(c);
            }
        }
    }

    /**
     * Constructor of the {@link Player} class.
     * @param name The name of the {@link Player}.
     * @param age The age of the {@link Player}.
     */
    public Player(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * Gets the name of the {@link Player}.
     * @return The name of the {@link Player}.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the age of the {@link Player}.
     * @return The age of the {@link Player}.
     */
    public int getAge(){
        return age;
    }

    /**
     * Gets the hand of the {@link Player}.
     * @return The hand of the {@link Player}, as an array of {@link Card}s.
     */
    public Card[] getHand(){
        Card[] toReturn = new Card[this.hand.size()];
        for(int i = 0; i < this.hand.size(); i++){
            toReturn[i] = this.hand.get(this.hand.size()-i-1);
        }
        return toReturn;
    }

    /**
     * Gets the amount of {@link Card}s in the {@link Player}'s hand.
     * @return The size of the {@link Player}'s hand.
     */
    public int size(){
        return this.hand.size();
    }

    /**
     * Draws a {@link Card} from a {@link Deck}, and adds it to the {@link Player}'s hand.
     * If there are no {@link Card}s in the {@link Deck}, does nothing.
     * @param deck The {@link Deck} to be drawn from.
     */
    public void draw(Deck deck){
        Card c = deck.draw();
        if(c != null){
            this.hand.add(c);
        }
    }

    /**
     * Removes a {@link Card} from the {@link Player}'s hand, and adds it to a {@link DiscardPile}.
     * If the {@link Card} to be discarded is {@code null} or is not found, returns {@code false}.
     * Otherwise, returns {@code true}.
     * @param card The {@link Card} to be discarded.
     * @param discardPile The {@link DiscardPile} to discard the {@link Card} to.
     * @return A {@code boolean}, based on whether the {@link Card} was successfully discarded.
     */
    public boolean discardCard(Card card, DiscardPile discardPile){
        if(card != null && this.hand.contains(card)){
            this.hand.remove(card);
            discardPile.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * Removes a {@link Card} from the {@link Player}'s hand, and adds it to a {@link Deck}.
     * If the {@link Card} to be returned is {@code null} or is not found, returns {@code false}.
     * Otherwise, returns {@code true}.
     * @param card The {@link Card} to be returned.
     * @param deck The {@link Deck} to return the {@link Card} to.
     * @return A {@code boolean}, based on whether the {@link Card} was successfully returned.
     */
    public boolean returnCard(Card card, Deck deck){
        if(card != null && this.hand.contains(card)){
            this.hand.remove(card);
            deck.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * An override of the {@link toString} method of {@link Player}.
     * @return A {@link String}, with the {@link Player}'s name, age and hand seperated by commas, ending with a period.
     */
    @Override
    public String toString(){
        String returnString = name + ", " + String.valueOf(age);
        for(int i = hand.size()-1; i >= 0; --i){ // iterating in reverse to preserve order of cards
            returnString += ", " + hand.get(i).toString();
        }
        return returnString + ".";
    }
}