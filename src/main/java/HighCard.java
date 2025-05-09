import java.util.Scanner;

class HighCard{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nameA = sc.nextLine();
        String nameB = sc.nextLine();
        sc.close();
        Deck deck = new Deck();
        Player playerA = new Player(nameA, 2147483647);
        Player playerB = new Player(nameB, -2147483648);
        deck.shuffle();
        for(int i = 0; i < 5; i++){
            playerA.draw(deck);
            playerB.draw(deck);
        }
        int A = 0;
        int B = 0;
        for(int i = 0; i < 5; i++){
            Card[] cardsA = playerA.getHand();
            Card maxCardA = cardsA[0];
            for(int j = 1; j < cardsA.length; j++){
                if(cardsA[j].getValue() > maxCardA.getValue()){
                    maxCardA = cardsA[j];
                }
            }
            Card[] cardsB = playerB.getHand();
            Card maxCardB = cardsB[0];
            for(int j = 1; j < cardsB.length; j++){
                if(cardsB[j].getValue() > maxCardB.getValue()){
                    maxCardB = cardsB[j];
                }
            }
            if(maxCardA.getValue() > maxCardB.getValue()){
                A++;
            }else{
                B++;
            }
        }
        if(A > B){
            System.out.println(playerA.toString());
        }else{
            System.out.println(playerB.toString());
        }
    }
}