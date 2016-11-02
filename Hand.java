import java.util.ArrayList;
public class Hand{
ArrayList<Card> hand = new ArrayList<Card>();

    public Hand(){

    }

    public void printHand(){
        for(int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i).getDesc());
        }
    }

    public Card getCard(int pos){
        return hand.remove(pos);
    }

    public Card checkCard(int pos){
        return hand.get(pos);
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public Card getLastCard(){
        return hand.get(hand.size()-1);
    }

    public boolean isEmpty(){
        return hand.isEmpty();
    }

    public boolean haveCard(String num){
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).getWordValue().equals(num)){
                return true;
            }
        }
        return false;
    }

    public int posOf(String num){
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).getWordValue().equals(num)){
                return i;
            }
        }
        return -1;
    }
}