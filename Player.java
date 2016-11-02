public class Player{
Hand hand = new Hand();
String name;

public Player(String name){
    this.name = name;
}

public Player(String name, Hand hand){
    this.name = name;
    this.hand = hand;
}

public Hand getHand(){
    return hand;
}

public void addCard(Card card){
    hand.addCard(card);
}

public String getName(){
    return name;
}
}