package theGreatWalrus;

public class Card 
{
	private String name;
	private String type;
	private String text;
	private int mgtCost;
	private int sprCost;
	private int agiCost;
	private int intCost;
	
	public Card()
	{
		name = "";
		type = "";
		text = "";
		mgtCost = 0;
		sprCost = 0;
		agiCost = 0;
		intCost = 0;
	}
	
	public Card(String inputName, String inputType, String inputCosts, String inputText)
	{
		name = inputName;
		type = inputType;
		agiCost = Integer.parseInt(inputCosts.substring(0,1));
		intCost = Integer.parseInt(inputCosts.substring(1,2));
		mgtCost = Integer.parseInt(inputCosts.substring(2,3));
		sprCost = Integer.parseInt(inputCosts.substring(3,4));
		text = inputText;
	}
	
	public String print()
	{
		String output = "";
		output += "***************************************************************\n";
		output += name + " \n";
		output += type + " \n";
		output += "Agi: " + agiCost + " Int: " + intCost + " Mgt: " + mgtCost + " Spr: " + sprCost + "\n";
		output += text +"\n";
		output += "***************************************************************";
		
		return output;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getText()
	{
		return text;
	}
	
	public String getType()
	{
		return type;
	}
	
}
