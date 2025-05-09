/**
 * A {@link Card} with a name, suit and integer value.
 * @author Pavarasan Karunainathan
 * @version 17.0.1
 */
public class Card{
    private String name;
    private String suit;
    private int value;
    
    /**
     * Constructor of the {@link Card} class.
     * @param name The name of the {@link Card}.
     * @param suit The suit of the {@link Card}.
     * @param value The value of the {@link Card}.
     */
    public Card(String name, String suit, int value){
        this.name = name;
        this.suit = suit;
        this.value = value;
    }
    
    /**
     * Gets the name of the {@link Card}.
     * @return The name of the {@link Card}.
     */
    public String getName(){
        return this.name;
    }
        
    /**
     * Gets the suit of the {@link Card}.
     * @return The suit of the {@link Card}.
     */
    public String getSuit(){
        return this.suit;
    }
    
    /**
     * Gets the value of the {@link Card}.
     * @return The value of the {@link Card}.
     */
    public int getValue(){
        return this.value;
    }
    
    /**
     * Override of the {@link toString} method of {@link Card}.
     * @return The {@link Card} in the format {@code "<name> of <suit>"}.
     */
    @Override
    public String toString(){
        return this.name + " of " + this.suit;
    }
    
    /**
     * Override of the {@link equals} method of {@link Card}.
     * @param other An {@link Object} to be compared to the {@link Card}. 
     *              If the {@link Object} is not a {@link Card}, returns false.
     * @return Whether the {@link Object} is equal to the {@link Card} in name, suit and value.
     */
    @Override
    public boolean equals(Object other){
        if(other instanceof Card){
            Card otherCard = (Card)other;
            return otherCard.getName() == this.name && 
                   otherCard.getSuit() == this.suit && 
                   otherCard.getValue() == this.value;
        }else{
            return false;
        }
    }
}