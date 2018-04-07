import java.util.*;

public class Salad {
	
	private Ingredients igdSalad = new Ingredients("salad");
	
	private List <String> lstIngredients = new ArrayList<String>();
	private List<String> lstAnimals = new ArrayList<String>();
	private List<String> lstCheese = new ArrayList<String>();
	private List<String> lstFruits = new ArrayList<String>();
	private List<String> lstEggType = new ArrayList<String>();
	
	private String name;
	
	public Salad(String name)
	{
		this.name = name;
		this.setIngredients();
	}
	
	
	
	public void setIngredients()
	{
		if(name.equalsIgnoreCase("customize"))
		{
			lstAnimals.addAll(igdSalad.getAnimal());
			lstCheese.addAll(igdSalad.getCheese());
			lstFruits.addAll(igdSalad.getFruits());
			lstEggType.addAll(igdSalad.getEggType());
			lstIngredients.addAll(igdSalad.getIngredients());
		}
		
		else if(name.equalsIgnoreCase("Caesar"))
		{
			lstIngredients.add("Parmesan Cheese");
			lstIngredients.add("Boiled Egg");
			lstIngredients.add("Lettuce");
			lstIngredients.add("Bacon");
			lstIngredients.add("Corn");
			lstIngredients.add("Carrots");
			lstIngredients.add("Tomato");
			
			Collections.sort(lstIngredients);
		}
		else if(name.equalsIgnoreCase("Chicken"))
		{
			lstIngredients.add("Boiled Egg");
			lstIngredients.add("Lettuce");
			lstIngredients.add("Chicken");
			lstIngredients.add("Tomato");
			lstIngredients.add("Carrots");
			lstIngredients.add("Feta");
			lstIngredients.add("Corn");
			
			Collections.sort(lstIngredients);
		}
		else if(name.equalsIgnoreCase("Seafood"))
		{
			lstIngredients.add("Shrimp");
			lstIngredients.add("Tomato");
			lstIngredients.add("Fish");
			lstIngredients.add("Lettuce");
			lstIngredients.add("Carrots");
			lstIngredients.add("Feta");
			lstIngredients.add("Oyster");
			
			Collections.sort(lstIngredients);
		}
		else if(name.equalsIgnoreCase("Fruit"))
		{
			lstIngredients.add("Mango");
			lstIngredients.add("Lettuce");
			lstIngredients.add("Peach");
			lstIngredients.add("Apple");
			lstIngredients.add("Carrots");
			lstIngredients.add("Spinach");
			lstIngredients.add("Orange");
			
			Collections.sort(lstIngredients);
		}
	}
	
	public List<String> getIngredients()
	{
		return lstIngredients;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String[] getIngredientsArray()
	{
		
		String[] strIngred = new String[lstIngredients.size()];
		strIngred = lstIngredients.toArray(strIngred);
		return strIngred;
	}
	
	public String[] getFruitsArray()
	{
		String[] strFruits = new String[lstFruits.size()];
		strFruits = lstFruits.toArray(strFruits);
		return strFruits;
	}
	
	public String[] getEggTypeArray()
	{
		String[] strEggType = new String[lstEggType.size()];
		strEggType = lstEggType.toArray(strEggType);
		return strEggType;
	}
	
	public String[] getAnimalsArray()
	{
		String[] strAnimal = new String[lstAnimals.size()];
		strAnimal = lstAnimals.toArray(strAnimal);
		return strAnimal;
	}
	public String[] getCheeseArray()
	{
		String[] strCheese = new String[lstCheese.size()];
		strCheese = lstCheese.toArray(strCheese);
		return strCheese;
	}
	
}
