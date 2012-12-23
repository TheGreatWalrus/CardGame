package theGreatWalrus;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game 
{
	public static void main(String[] args) throws IOException{

		String deckPath = "sampleDeck.txt";
		String cardPath = "cardList.txt";
		Scanner s = null;
		Scanner t = null;	
		Scanner in = new Scanner(System.in);
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Card> deck = new ArrayList<Card>();
		ArrayList<Card> deckCopy = (ArrayList<Card>) deck.clone();
		ArrayList<Card> hand = new ArrayList<Card>();
		Random rand = new Random();
		boolean stillPlaying = true;
		int health = 40;



		try
		{
			s = new Scanner(new BufferedReader(new FileReader(cardPath)));

			while(s.hasNextLine())
			{
				System.out.println("Collecting cards");
				String inputName = s.nextLine();
				String inputType = s.nextLine();
				String inputCost = s.nextLine();
				String inputText = s.nextLine();

				Card inputCard = new Card(inputName, inputType, inputCost, inputText);
				cards.add(inputCard);
			}
		}
		finally
		{
			//s.close();
		}

		try
		{
			t = new Scanner(new BufferedReader(new FileReader(deckPath)));

			while(t.hasNextLine())
			{
				String tempName = t.nextLine();
				System.out.println("Making a deck with card: " + tempName);
				for(int i = 0; i < cards.size(); i++)
				{
					if(cards.get(i).getName().equals(tempName))
					{
						deck.add(cards.get(i));
					}
				}
			}
		}
		finally
		{
			t.close();
		}
		
		deckCopy = deck;
		System.out.println("Commands:");
		System.out.println("help: shows the list of commands");
		System.out.println("draw: draws 1 card");
		System.out.println("shuffle: shuffles the deck");
		System.out.println("hand: Displays the information about each of the cards in your hand");
		System.out.println("discard: Discards a random card from your hand.");
		System.out.println("take: Prompts you to enter an amount of damage taken");
		System.out.println("heal: Prompts you to enter an amount of damage healed");
		
		while(stillPlaying == true)
		{
			deck = deckCopy;

			//Main loop
			System.out.println("Entering main loop");
			while(health > 0)
			{
				System.out.println("Enter a command");
				int tempInt = 0;
				String input = in.nextLine();

				//Shuffles the deck
				if(input.equals("shuffle"))
				{
					for(int i = 0; i < deck.size()*2; i++)
					{
						tempInt = rand.nextInt(deck.size());
						deck.add(deck.remove(tempInt));
					}
				}

				//Displays all the cards in the hand
				if(input.equals("hand"))
				{
					for(int i = 0; i < hand.size(); i++)
					{
						System.out.println(i);
						System.out.println(hand.get(i).print());
					}
				}

				//Draws a card
				if(input.equals("draw"))
				{
					hand.add(deck.remove(0));
				}

				//Discards a random card from your hand
				if(input.equals("discard"))
				{
					tempInt = rand.nextInt(hand.size());
					System.out.println( hand.remove(tempInt).getName() +  " was discarded. ");
				}

				if(input.equals("take"))
				{
					System.out.println("How much damage?");
					tempInt = in.nextInt();
					if(tempInt < 0)
					{
						System.out.println("You crafty bastard.");
					}
					else
					{
						health = health - tempInt;
					}
				}
				
				if(input.equals("heal"))
				{
					System.out.println("How much health?");
					tempInt = in.nextInt();
					health = health + tempInt;
				}
				
				if(input.equals("play"))
				{
					System.out.println("Which card?");
					for(int i = 0; i < hand.size(); i++)
					{
						System.out.println(i + " " + hand.get(i));
					}
					tempInt = in.nextInt();
					if(tempInt < hand.size() && tempInt >= 0)
					{
						hand.remove(tempInt);
					}
				}
				
				if(input.equals("status"))
				{
					System.out.println("Health: " + health);
					System.out.println("Cards in hand: " + hand.size());
				}


				if(input.equals("help"))
				{
					System.out.println("Commands:");
					System.out.println("help: shows the list of commands");
					System.out.println("draw: draws 1 card");
					System.out.println("shuffle: shuffles the deck");
					System.out.println("hand: Displays the information about each of the cards in your hand");
					System.out.println("discard: Discards a random card from your hand.");
					System.out.println("take: Prompts you to enter an amount of damage taken");
					System.out.println("heal: Prompts you to enter an amount of damage healed");
					
				}

			}
			
			System.out.println("Play again? yes/no");
			if(in.next().equals("no"))
			{
				stillPlaying = false;
				in.close();
			}
		}

	}


}

