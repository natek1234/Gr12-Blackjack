// Creates a Dealer object inherited from a Player object.
// This Dealer is specific to Black Jack and will only play a BlackJack hand.
public class Dealer extends Player{

	// Constructor comes from the Player object
	public Dealer()
	{
		super();
	}


	// Simulates a black jack dealer who continually adds cards to their hand until
	// their hand point value is 16 or greater.
	public void autoPlay(Deck d)
	{
		// Keep dealing until we're 16 or greater.
		while (this.total() < 16)
		{
			this.hit(d.deal());
		}
	}

}
