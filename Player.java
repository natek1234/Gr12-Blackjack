// An object that represents a Player in a card game with a Hand and score.
public class Player {

	// Member variables.
	private Hand hand;
	private int score;

	// Constructor.
	public Player()
	{
		this.hand = new Hand();
		this.score = 0;
	}

	// Adds a card to the player's hand.
	public void hit(Card c)
	{
		hand.addCard(c);
	}


	// Returns the value of current hand.
	public int total()
	{
		return hand.total();
	}

	// Returns the string representation of the current hand.	  
	public String getHand()
	{
		return hand.getCards();
	}
	
	// Add given points to the players current score.
	public void addPoints(int p)
	{
		score += p;	
	}

	// Return the player's current score.
	public int getScore()
	{
		return score;
	}

	// Discard/Clear all the cards in the current player's hand so it's empty.
	public void handClear()
	{
		hand.clear();
	}




}
