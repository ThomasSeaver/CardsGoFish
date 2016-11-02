import java.util.Scanner;
import java.util.ArrayList;

public class Dealer {
Player player1 = new Player("player1");
Player player2 = new Player("player2");
Player player3 = new Player("player3");
ArrayList<Player> pArray = new ArrayList<Player>();
String[] numArray = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
Deck deck = new Deck('y');
int pNum = 0;
Scanner kb = new Scanner(System.in);

    public Dealer(){
        //implement dealing options later
        deal();
        pArray.add(player1);
        pArray.add(player2);
        pArray.add(player3);
        while((!allHandsEmpty()) && (!deck.isEmpty())){
            turn(pArray.get(pNum));
            if(pNum < 3){
                pNum++;
            }
            else{
                pNum = 0;
            }
        }
    }

    public boolean allHandsEmpty(){
        for(int i = 0; i < pArray.size(); i++){
            if(pArray.get(i).getHand().isEmpty()){
                return true;
            }
        return false;
    }

    public void deal(){
        for(int i = 0; i <7; i++){
            player1.addCard(deck.dealCard());
            player2.addCard(deck.dealCard());
            player3.addCard(deck.dealCard());
        }
    }

    public void turn(Player player){
        if(player.getHand().isEmpty()){
            System.out.println("Empty hand, you get five cards");
            for(int i = 0; i < 5; i++){
                player.addCard(deck.dealCard());
            }
        }
        System.out.println("Okay, here is your hand");
        player.getHand().printHand();
        System.out.println("Okay, who will you ask now");
        String pName;
        String num = null;
        Player victim = null;
        boolean nameCheck = true;
        while(nameCheck){
            pName = kb.nextLine();
            for(int i = 0; i < pArray.size(); i++){
                if(pName.equals(player.getName()) || pName.equals(pArray.get(i).getName())){
                    nameCheck = false;
                    victim = pArray.get(i);
                }
            }
            if (nameCheck){
                System.out.println("That's not an appropriate name, try again sorry.");
            }
        }
        boolean numCheck = true;
        boolean haveCard = false;
        System.out.println("Okay, what number would you like to look for?");
        while(numCheck){
            num = kb.nextLine();
            for(int i = 0; i < numArray.length; i++){
                System.out.println(num.equals(numArray[i]));
                System.out.println(player.getHand().haveCard(num));
                if(num.equals(numArray[i]) && player.getHand().haveCard(num)){
                    numCheck = false;
                }
            }
            if (numCheck){
                System.out.println("That's not an appropriate number, try again sorry.");
            }
        }
        if(victim.getHand().haveCard(num)){
            int cardPos = victim.getHand().posOf(num);
            System.out.println("Good job, you got the " + victim.getHand().checkCard(cardPos).getDesc());
            player.getHand().addCard(victim.getHand().getCard(cardPos));
            System.out.println("You get to go again!");
            turn(player);
        }
        else{
            System.out.println("Sorry, they didn't have it. Go fish!");
            if(deck.isEmpty()){
                System.out.println("Sorry, deck's empty! No card for you.");
            }
            else{
                player.getHand().addCard(deck.dealCard());
                System.out.println("One " + player.getHand().getLastCard().getDesc() + " for you!");
            }
        }

    }

}