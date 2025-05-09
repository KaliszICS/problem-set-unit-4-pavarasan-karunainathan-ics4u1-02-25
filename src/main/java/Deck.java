import java.util.ArrayList;
import java.util.Random;

/**
 * A {@link Deck} of {@link Card}s. 
 * {@link Card}s can be added, removed, and shuffled in this.
 * @author Pavarasan Karunainathan
 * @version 17.0.1
 */
public class Deck{
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Random rand = new Random();

    /* Names of the default Cards */
    final private static String[] NAMES = {
        "Ace", "2", "3", "4", "5", "6", "7", 
        "8", "9", "10", "Jack", "Queen", "King"
    };

    /* Suits of the default Cards */
    final private static String[] SUITS = {
        "Hearts", "Clubs", "Diamonds", "Spades"
    };

    /**
     * Constructor of the {@link Deck} class, where an array of {@link Card}s are given.
     * Will ignore any {@code null} {@link Card}s in the array.
     * @param cards The {@link Card}s to the put in the {@link Deck}.
     */
    public Deck(Card[] cards){
        for(int i = cards.length-1; i >= 0; --i){ // iterating in reverse to preserve order of cards
            Card c = cards[i];
            if(c != null){
                this.cards.add(c);
            }
        }
    }

    /**
     * Default Constructor of the {@link Deck} class.
     * Will initialize the deck with a regular set of {@link Card}s — Ace through King for each suit, in the order Hearts, Clubs, Diamonds and Spades.
     */
    public Deck(){
        /* iterating in reverse to preserve order of cards */
        for(int i = 3; i >= 0; --i){
            for(int j = 12; j >= 0; --j){
                this.cards.add(new Card(NAMES[j], SUITS[i], j*4+i));
            }
        }
    }

    /**
     * Gets the amount of {@link Card}s in the {@link Deck}
     * @return The size of the {@link Deck}.
     */
    public int size(){
        return this.cards.size();
    }

    /**
     * Draws the first {@link Card} from the {@link Deck}.
     * If there are no {@link Card}s in the {@link Deck}, returns {@code null}.
     * @return The first {@link Card} in the {@link Deck}.
     */
    public Card draw(){
        if(this.cards.size() == 0) return null;
        return this.cards.remove(this.cards.size()-1);
    }

    /**
     * Performs a uniformly random shuffle on the {@link Deck}.
     */
    public void shuffle(){
        for(int i = 0; i < this.cards.size()-1; i++){
            Card tempCard = this.cards.get(i);
            int randIndex = i+1+this.rand.nextInt(this.cards.size()-i-1);
            this.cards.set(i, this.cards.get(randIndex));
            this.cards.set(randIndex, tempCard);
        }
    }

    /**
     * Adds a {@link Card} to the top of the {@link Deck}.
     * If the {@link Card} is {@code null}, does nothing.
     * @param card The {@link Card} to be added to the {@link Deck}
     */
    public void addCard(Card card){
        if(card != null){
            this.cards.add(card);
        }
    }

    /**
     * Adds an array of {@link Card}s to the {@link Deck}, then shuffles the {@link Deck}.
     * Will ignore any {@code null} {@link Card}s in the array.
     * @param cards The array of {@link Card}s to be added.
     */
    public void reshuffle(Card[] cards){
        for(Card c : cards){
            if(c != null){
                this.cards.add(c);
            }
        }
        shuffle();
    }
}