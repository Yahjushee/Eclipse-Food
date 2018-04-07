import java.util.*;

public class Ingredients {
	
	//ingredients that can be present
	private List<String> lstIngredients = new ArrayList<String>();
	private List<String> lstFruits = new ArrayList<String>();
	private List<String> lstEggType = new ArrayList<String>();
	private List<String> lstAnimal = new ArrayList<String>();
	private List<String> lstCheese = new ArrayList<String>();
	
	//salad,pizza,breakfast or lunch
	private String strTypeFood;
	
	public Ingredients(String strTypeFood)
	{
		this.strTypeFood= strTypeFood;
		this.setIngredients();
		this.setFruits();
		this.setEggType();
		this.setAnimal();
		this.setCheese();
	}
	
	public void setFruits()
	{
		lstFruits.add("Mango");
		lstFruits.add("Pineapple");
		lstFruits.add("Avocado");
		lstFruits.add("Banana");
		lstFruits.add("Cherry");
		lstFruits.add("Grape");
		lstFruits.add("Strawberry");
		lstFruits.add("Pear");
		lstFruits.add("Lychee");
		lstFruits.add("Peach");
		lstFruits.add("Orange");
	}
	
	public void setEggType()
	{
		lstEggType.add("Boiled Egg");
		lstEggType.add("Poached Egg");
		lstEggType.add("Scrambled Egg");
		lstEggType.add("Fried Egg");
	}
	
	public void setAnimal()
	{
		lstAnimal.add("Chicken");
		lstAnimal.add("Turkey");
		lstAnimal.add("Duck");
		lstAnimal.add("Bacon");
		lstAnimal.add("Fish");
		lstAnimal.add("Oyster");
		lstAnimal.add("Lamb");
		lstAnimal.add("Shrimp");
		lstAnimal.add("Pepperoni");
		
	}
	
	public void setIngredients()
	{
		if(strTypeFood.equalsIgnoreCase("salad"))
		{
			lstIngredients.add("Green Olives");
			lstIngredients.add("Cherry Tomatoes");
			lstIngredients.add("Carrots");
			lstIngredients.add("Cucumbers");
			lstIngredients.add("Spinach");
			lstIngredients.add("Mushrooms");
			lstIngredients.add("Onions");
			lstIngredients.add("Lettuces");
			lstIngredients.add("Peppers");
			lstIngredients.add("Corns");
			lstIngredients.add("Cabbages");
			lstIngredients.add("Baby Corns");
			lstIngredients.add("Black Olives");
			lstIngredients.add("Grapes");;
			lstIngredients.add("Jalapenos");
			
		}
		else if(strTypeFood.equalsIgnoreCase("breakfast"))
		{
			lstIngredients.add("Pancakes");
			lstIngredients.add("Cereals");
			lstIngredients.add("Griled Bread");
			lstIngredients.add("Croissant");
			lstIngredients.add("Weetabix");
		}
		
		else if(strTypeFood.equalsIgnoreCase("pizza"))
		{
			lstIngredients.add("Tomatoes");
			lstIngredients.add("Peppers");
			lstIngredients.add("Jalapenos");
			lstIngredients.add("Corn");
			lstIngredients.add("Peppers");
			lstIngredients.add("Olives");
			lstIngredients.add("Black Onions");
			lstIngredients.add("Spinach");
			lstIngredients.add("Feta");
			lstIngredients.add("Pineapple");
		}
		
		else if(strTypeFood.equalsIgnoreCase("lunch"))
		{
			lstIngredients.add("Panini");
			lstIngredients.add("Fried Rice");
			lstIngredients.add("Fried Noodles");
			lstIngredients.add("Boiled Noodles");
			lstIngredients.add("Bread");
		}
	}
	
	public void setCheese()
	{
		lstCheese.add("Feta");
		lstCheese.add("Goat Cheese");
		lstCheese.add("Mozarella");
		lstCheese.add("Cheddar");
		lstCheese.add("Parmesan Cheese");
	}
	
	public List<String> getIngredients()
	{
		Collections.sort(lstIngredients);
		return lstIngredients;
	}
	
	public List<String> getCheese()
	{
		Collections.sort(lstCheese);
		return lstCheese;
	}
	
	public List<String> getFruits()
	{
		Collections.sort(lstFruits);
		return lstFruits;
	}
	
	public List<String> getEggType()
	{
		Collections.sort(lstEggType);
		return lstEggType;
	}
	
	public List<String> getAnimal()
	{
		Collections.sort(lstAnimal);
		return lstAnimal;
	}
}
