public class Card{

    int value;
    // value is an integer from 1-13, with 11-13 representing face cards in order of jack, queen, king
    String wordValue;
    // actual word for value, in english
    int suit;
    // suit is an integer from 1-4, representing card suits in alphabetical order, clubs, diamonds, hearts, spades
    String wordSuit;
    // actual word for suit, in english

    public Card (int value, int suit){
        this.value = value;
        this.suit = suit;
        parse();
    }

    public String getDesc(){
        return (wordValue + " of " + wordSuit);
    }

    public int getValue(){
        return value;
    }

    public String getWordValue(){
        return wordValue;
    }

    public int getSuit(){
        return suit;
    }

    public String getWordSuit(){
        return wordSuit;
    }

    private void parse(){
        if(suit == 1){
            wordSuit = "Clubs";
        }else if(suit == 2){
            wordSuit = "Diamonds";
        }else if(suit == 3){
            wordSuit = "Hearts";
        }else if(suit == 4){
            wordSuit = "Spades";
        }

        if (value == 1){
            wordValue = "One";
        }else if(value == 2){
            wordValue = "Two";
        }else if(value == 3){
            wordValue = "Three";
        }else if(value == 4){
            wordValue = "Four";
        }else if(value == 5){
            wordValue = "Five";
        }else if(value == 6){
            wordValue = "Six";
        }else if(value == 7){
            wordValue = "Seven";
        }else if(value == 8){
            wordValue = "Eight";
        }else if(value == 9){
            wordValue = "Nine";
        }else if(value == 10){
            wordValue = "Ten";
        }else if(value == 11){
            wordValue = "Jack";
        }else if(value == 12){
            wordValue = "Queen";
        }else if(value == 13){
            wordValue = "King";
        }
    }

}