//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class ProblemSetTest {

   //Create your tests here if you want any

   @Test
   public void CardCheck(){
      Card c = new Card("REAL", "FOUR", 49294);
      assertEquals(c.getName(), "REAL");
      assertEquals(c.getSuit(), "FOUR");
      assertEquals(c.getValue(), 49294);
      assertEquals(c.toString(), "REAL of FOUR");
      Card _c = new Card("REAL", "FOUR", 49294);
      assertEquals(_c.getName(), "REAL");
      assertEquals(_c.getSuit(), "FOUR");
      assertEquals(_c.getValue(), 49294);
      assertEquals(_c.toString(), "REAL of FOUR");
      assertEquals(c.equals(_c), true);
      Card b = new Card("REAL", "FOUR", 49293);
      assertEquals(b.getName(), "REAL");
      assertEquals(b.getSuit(), "FOUR");
      assertEquals(b.getValue(), 49293);
      assertEquals(b.equals(_c), false);
      String s = "REAL OF FOUR";
      assertEquals(b.equals(s), false);
      assertEquals(b.equals((Object)s), false);
      assertEquals(b.equals(null), false);
   }

   @Test
   public void DeckCheck(){
      final String[] NAMES = {
        "Ace", "2", "3", "4", "5", "6", "7", 
        "8", "9", "10", "Jack", "Queen", "King"
      };

      final String[] SUITS = {
          "Hearts", "Clubs", "Diamonds", "Spades"
      };

      Deck A = new Deck();
      Deck B = new Deck(new Card[]{new Card("REAL", "FOUR", 49294), new Card("AC", "FIVE", 49293)});
      
      assertEquals(A.size(), 52);
      assertEquals(B.size(), 2);

      Card c = A.draw();
      assertEquals(c.toString(), "Ace of Hearts");
      assertEquals(A.size(), 51);
      A.addCard(c);
      assertEquals(A.size(), 52);
      
      Card _c = A.draw();
      assertEquals(_c.toString(), "Ace of Hearts");
      assertEquals(A.size(), 51);
      A.addCard(_c);
      assertEquals(A.size(), 52);

      for(int i = 0; i < 4; i++){
         for(int j = 0; j < 13; j++){
            assertEquals(A.draw().toString(), NAMES[j] + " of " + SUITS[i]);
         }
      }

      B.addCard(null);
      assertEquals(B.size(), 2);
      B.addCard(c);
      assertEquals(B.size(), 3);
      B.shuffle();
      A.shuffle();
      assertEquals(A.size(), 0);
      A.reshuffle(new Card[]{null, new Card("REAL", "FOUR", 49294), new Card("AC", "FIVE", 49293), null});
      assertEquals(A.size(), 2);
   }

   @Test
   public void DiscardCheck(){
      DiscardPile A = new DiscardPile();
      assertEquals(A.toString(), "");
      DiscardPile B = new DiscardPile(new Card[]{new Card("REAL", "FOUR", 49294), null, new Card("AC", "FIVE", 49293), null});
      assertEquals(B.getCards()[0], new Card("REAL", "FOUR", 49294));
      assertEquals(B.getCards()[1], new Card("AC", "FIVE", 49293));
      assertEquals(A.size(), 0);
      assertEquals(B.size(), 2);
      A.addCard(null);
      assertEquals(A.size(), 0);
      Deck C = new Deck();
      Card _C;
      while((_C = C.draw()) != null){
         A.addCard(_C);
      }
      Deck D = new Deck();
      Card _D;
      while((_D = D.draw()) != null){
         assertEquals(A.removeCard(_D), _D);
      }
      
      assertEquals(A.removeCard(null), null);
      assertEquals(B.toString(), "REAL of FOUR, AC of FIVE.");

      DiscardPile E = new DiscardPile(new Card[]{new Card("REAL", "FOUR", 49294), null, new Card("AC", "FIVE", 49293), null});
      Card[] e = E.removeAll();
      assertEquals(E.size(), 0);
      assertEquals(e[0], new Card("REAL", "FOUR", 49294));
      assertEquals(e[1], new Card("AC", "FIVE", 49293));
   }

   @Test
   public void PlayerCheck(){
      Player A = new Player("A", -1);
      Player B = new Player("B", 2147483647, new Card[]{new Card("REAL", "FOUR", 49294), null, new Card("AC", "FIVE", 49293), null});
      assertEquals(A.toString(), "A, -1.");
      assertEquals(B.toString(), "B, 2147483647, REAL of FOUR, AC of FIVE.");
      assertEquals(B.getHand()[0], new Card("REAL", "FOUR", 49294));
      assertEquals(B.getHand()[1], new Card("AC", "FIVE", 49293));
      assertEquals(A.size(), 0);
      assertEquals(B.size(), 2);
      A.draw(new Deck(new Card[]{}));
      assertEquals(A.size(), 0);
      Deck C = new Deck();
      while(C.size() != 0){
         A.draw(C);
      }
      while(A.size() != 0){
         assertEquals(A.returnCard(A.getHand()[0], C), true);
      }
      DiscardPile D = new DiscardPile();
      while(B.size() != 0){
         assertEquals(B.discardCard(B.getHand()[B.size()-1], D), true);
      }
      

      DiscardPile E = new DiscardPile(new Card[]{new Card("REAL", "FOUR", 49294), null, new Card("AC", "FIVE", 49293), null});
      Card[] e = E.removeAll();
      assertEquals(E.size(), 0);
      assertEquals(e[0], new Card("REAL", "FOUR", 49294));
      assertEquals(e[1], new Card("AC", "FIVE", 49293));
   }


   /*

   //Example Test
   
   @Test
   public void exampleTest()
   {
      Cat cat = new Cat();
      assertEquals("whiskers", cat.getName());
   }
   */
}
