import java.util.ArrayList;

/**
 * A Discard Pile, where {@link Card}s can be added and removed.
 * @author Pavarasan Karunainathan
 * @version 17.0.1
 */
public class DiscardPile{
    private ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * Constructor of the {@link DiscardPile} class, where an array of {@link Card}s are already given.
     * Will ignore any {@code null} {@link Card}s in the array.
     * @param cards The array of {@link Card}s in the {@link DiscardPile}.
     */
    public DiscardPile(Card[] cards){
        for(int i = cards.length-1; i >= 0; --i){ // iterating in reverse to preserve order of cards
            Card c = cards[i];
            if(c != null){
                this.cards.add(c);
            }
        }
    }

    /**
     * Default Constructor of the {@link DiscardPile} class.
     */
    public DiscardPile(){}

    /**
     * Gets the {@link Card}s in the {@link DiscardPile} as an array.
     * @return The {@link Card}s in the {@link DiscardPile}.
     */
    public Card[] getCards(){
        return this.cards.toArray(new Card[this.cards.size()]);
    }

    /**
     * Gets the amount of {@link Card}s in the {@link DiscardPile}.
     * @return The amount of {@link Card}s in the {@link DiscardPile}.
     */
    public int size(){
        return this.cards.size();
    }

    /**
     * Adds a {@link Card} to the array of {@link Card}s in the {@link DiscardPile}.
     * Does nothing if the {@link Card} is {@code null}.
     * @param card The {@link Card} to be added.
     */
    public void addCard(Card card){
        if(card != null){
            this.cards.add(card);
        }
    }

    /**
     * Removes a specified {@link Card} from the {@link DiscardPile}.
     * Returns {@code null} if the {@link Card} is {@code null}, or is not found in the {@link DiscardPile}.
     * @param card The {@link Card} to be removed.
     * @return The {@link Card} removed — if it was found, otherwise {@code null}.
     */
    public Card removeCard(Card card){
        if(card != null && this.cards.contains(card)){
            this.cards.remove(card);
            return card;
        }else{
            return null;
        }
    }

    /**
     * Removes and returns all {@link Card}s from the {@link DiscardPile}.
     * If the {@link DiscardPile} is empty, returns an empty array.
     * @return The {@link Card}s removed as an array of {@link Card}s.
     */
    public Card[] removeAll(){
        Card[] removedCards = getCards();
        this.cards.clear();
        return removedCards;
    }

    /**
     * Overrides the {@link toString} method of {@link DiscardPile}.
     * @return All {@link Card}s in the {@link DiscardPile} in {@link String} form, seperated by commas, ending with a period.
     */
    @Override
    public String toString(){
        String returnString = "";
        for(int i = this.cards.size()-1; i >= 0; --i){ // iterating in reverse to preserve order of cards
            returnString += this.cards.get(i).toString();
            if(i != 0){
                returnString += ", ";
            }
        }
        return returnString + ".";
    }
}