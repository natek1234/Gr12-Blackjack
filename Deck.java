import java.util.*;

// Object to represent a standard deck of playing cards
//	4 suits - Spades, hearts, Clubs, Diamonds
//	13 cards per suit - Ace through King
public class Deck {

	// Member vars.
	private Card[] theDeck;
	private String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
	private int currCard;	// Controls the index of the next card to be dealt.

	// Constructor
	public Deck()
	{
		// Create the deck.
		theDeck = new Card[52];

		int numCards = 0;
		for (int s = 0; s < suits.length; s++)
		{
			for (int r = 0; r < 13; r++)
			{
				theDeck[numCards++] = new Card(suits[s], r+1);
			}
		}

		// Shuffle the deck.
		this.shuffle();
	}


	// Shuffles the deck in random order.
	public void shuffle()
	{
		Collections.shuffle(Arrays.asList(this.theDeck));
	}


	// Returns a card for dealing.
	public Card deal()
	{
		return this.theDeck[currCard++];
	}


	// Returns true if we're close to running out of cards (less than 10).
	public boolean closeToEmpty()
	{
		if (52 - currCard < 10)
			return true;

		return false;
	}

}
