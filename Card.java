// Class that represents a playing card with a suit and value.

public class Card {

	// Member variables declared private so that no other classes
	// can modify them.
	private String suit;
	private int rank;


	// Constructor receives the suit and rank as parameters.
	public Card (String s, int r)
	{
		this.suit = s;
		this.rank = r;
	}


	// Returns the rank of the current card.
	public int getRank()
	{
		return this.rank;
	}


	// Returns the string that represents the card (ex. Ace of Spades)
	public String printCard()
	{
		String s = "";

		if (this.rank == 1)
		{
			s += "Ace";
		}
		else if (this.rank == 11)
		{
			s += "Jack";
		}
		else if (this.rank == 12)
		{
			s += "Queen";
		}
		else if (this.rank == 13)
		{
			s += "King";
		}
		else
		{
			s += this.rank;
		}

		s += " of " + this.suit;
		return s;

	}




}
