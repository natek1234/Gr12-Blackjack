import java.util.*;

// Main represents playing one game of the Blackjack card game
public class BlackJackGame 
{

	private Deck theDeck;
	private Dealer theDealer;
	private Player thePlayer;

	public BlackJackGame()
	{
		this.theDeck = new Deck();
		this.theDealer = new Dealer();
		this.thePlayer = new Player();

	}




	// Initialize a BlackJack hand with 2 cards
	public void createInitialHand(Player p, Deck d)
	{
		for (int i=0; i < 2; i++)
		{
			p.hit(d.deal());
		}
	}

	// Clear the given player's hand of any cards.
	public void resetHand(Player p)
	{
		p.handClear();
	}

	public void play()
	{
		Scanner sc = new Scanner(System.in);
		String userChoice = "";
		boolean validInput = false;

		// Play the game repeatedly dealing hands until the deck is almost used up.
		while (this.theDeck.closeToEmpty() == false)
		{
			System.out.println("Welcome to Black Jack!");
			
			// Deal each player two cards.
			this.createInitialHand(this.theDealer, this.theDeck);
			this.createInitialHand(this.thePlayer, this.theDeck);

			do
			{
				// Keep asking for input until we get 'h' or 's'
				validInput = false;
				while (!validInput)
				{

					// Let user see their hand
					System.out.println("Player hand: " + this.thePlayer.getHand());

					// Ask user if they want to hit or stay.
					System.out.println("Do you want to (h)it or (s)tay?");	      
					userChoice = sc.next();
					if (userChoice.equals("h") || userChoice.equals("s"))
					{
						validInput = true;
					}
					else
					{
						System.out.println("That's not valid input!");
					}

				}

				if (userChoice.equals("h"))
				{
					this.thePlayer.hit(this.theDeck.deal());
				}
			} while (!userChoice.equals("s") && this.thePlayer.total() <= 21);


			System.out.println("\nYour final hand is: " + this.thePlayer.getHand());

			if (this.thePlayer.total() > 21)
			{
				System.out.println("You went bust! Better luck next time!");
			}
			else
			{
				// Dealer needs to try to beat the player!
				this.theDealer.autoPlay(this.theDeck);
				System.out.println("Dealer's final hand is: " + this.theDealer.getHand());
			}


			// Check who won the hand
			// Human player is higher than dealer hand or dealer hand has gone bust (over 21)
			if (this.thePlayer.total() <= 21 && (this.thePlayer.total() > this.theDealer.total() || this.theDealer.total() > 21))
			{
				this.thePlayer.addPoints(1);
				System.out.println("Player won " + this.thePlayer.total() +" to " + this.theDealer.total());
			}

			// Human and dealer have the same hand so human wins
			else if (this.thePlayer.total() <=21 && this.thePlayer.total() == this.theDealer.total())
			{
				this.thePlayer.addPoints(1);
				System.out.println("Player won " + this.thePlayer.total() + " to " + this.thePlayer.total());
			}

			// Dealer hand is higher than human or human hand has gone bust (over 21)
			else if (this.thePlayer.total() <= 21 && (this.theDealer.total() > this.thePlayer.total() || this.thePlayer.total() > 21))
			{
				this.theDealer.addPoints(1);
				System.out.println("Dealer won " + this.theDealer.total() + " to " + this.thePlayer.total());
			}	       

			// Reset hands
			this.resetHand(this.thePlayer);
			this.resetHand(this.theDealer);
			System.out.println("\n");
		}

		// The loop only exits when the deck is near empty.
		System.out.println("Your deck is close to empty so this table is closed.");

		System.out.println("\nCurrent Scores:");
		System.out.println("Player - " + this.thePlayer.getScore());
		System.out.println("Dealer - " + this.theDealer.getScore());

	}

	public static void main(String[] args){
		// Create the game.
		BlackJackGame game = new BlackJackGame();
		game.play();




	}







}
