import java.util.ArrayList;
import java.util.Random;
public class Deck {

ArrayList<Card> deck = new ArrayList<Card>();
ArrayList<Card> discard = new ArrayList<Card>();

    public Deck (char preCreate){
        // preCreate signifies whether deck is standard 52 card deck or will be created separately. options should be 'y' or 'n'.
        if (preCreate == 'y'){
            createDeck();
            shuffleDeck();
        }
    }

    public boolean isEmpty(){
        return deck.isEmpty();
    }

    public Card checkCard(int pos){
        return deck.get(pos);
    }

    public Card dealCard(){
        return deck.remove(0);
    }

    public Card dealCard(int pos){
        return deck.remove(pos);
    }

    public void discardCard(Card card){
        discard.add(card);
    }

    private void shuffleDeck(){
    ArrayList<Card> temp = new ArrayList<Card>();
        while(!deck.isEmpty()) {
            int pos=(int)(Math.random()*deck.size());
            temp.add(deck.remove(pos));
        }
        deck=temp;
    }
    //Simplified shuffle method

    private void shuffleDiscard(){
    ArrayList<Card> temp = new ArrayList<Card>();
        while(!discard.isEmpty()) {
            int pos=(int)(Math.random()*discard.size());
            temp.add(discard.remove(pos));
        }
        discard=temp;
    }

    private void createDeck(){
        for (int i = 1; i <= 4; i++){
            for (int j = 1; j <= 13; j++){
                deck.add(new Card(j, i));
            }
        }
    }

}