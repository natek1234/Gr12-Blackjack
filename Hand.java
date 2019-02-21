// Object to represent a hand of cards used for any card game.
public class Hand {

	// Member variable to represent the hand of cards.
	private Card[] theHand;
	private int numCards;

	public Hand()
	{
		// Maximum size hand set to 11 -- very unlikely to occur!
		this.theHand = new Card[11];
		this.numCards = 0;
	}

	// Return a multi-line string representation of the current cards in the hand.
	public String getCards()
	{
		String hand = "";
		
		for(int count = 0; count < numCards; count++)
		{
			hand = hand + theHand[count].printCard() + "; ";
		}
		return hand;
	}

	// Clear the hand of its current cards.
	public void clear()
	{
		theHand = new Card[11];
		numCards = 0;
	}

	// Add a card to the hand.
	public void addCard(Card c)
	{
		theHand[numCards] = c;
		numCards++;
	}

	// Add up all the values of the cards based on rank.
	// Find the highest value of hand depending on Ace = 1 or 11 points 
	// whichever is to your benefit without going over 21!
	// Also calculate total based on all face cards (Jack, Queen, King) being 10 points.
	// Other cards in deck are based on their face value.
	public int total()
	{
		int sum = 0;
		int rank;
		int numAces = 0;
		for(int count = 0; count < numCards; count++)
		{
			rank = theHand[count].getRank();
			if(rank == 1)
			{
				numAces++;
			}
			else if (rank > 10 && rank < 14)
			{
				sum += 10;
			}
			else
			{
				sum += rank;
			}
		}
		if(numAces != 0)
		{
			if((sum + 11 + numAces - 1) <= 21)
			{
				sum = sum + 11 + numAces - 1;
			}
			else
			{
				sum += numAces;
			}
		}
		
		return sum;
	}


}
