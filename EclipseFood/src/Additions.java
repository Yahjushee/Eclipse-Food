import java.util.*;

public class Additions {
	
	private final Salad sldSalad;
	private String strName;
	private List <String> lstAdditons = new ArrayList<String>();
	private List<String> lstEdit = new ArrayList<String>();
	
	public Additions(String name)
	{
		sldSalad = new Salad(name);
		this.setIngredients();
	}
	
	public void setIngredients()
	{
		strName = sldSalad.getName();
		if(strName.equalsIgnoreCase("caesar"))
		{
			lstAdditons.add("Olive Oil");
			lstAdditons.add("Ground Black Pepper");
			lstAdditons.add("Mayonnaise");
			lstAdditons.add("Salt");
		}
		else if(strName.equalsIgnoreCase("customize"))
		{

			lstAdditons.add("Olive Oil");
			lstAdditons.add("Ground Black Pepper");
			lstAdditons.add("Mayonnaise");
			lstAdditons.add("Salt");
			lstAdditons.add("Chili");
			lstAdditons.add("Vinegar");
			lstAdditons.add("Salad Cream");
			lstAdditons.add("Lemon Juice");
			lstAdditons.add("Mustard");
		}
		else if(strName.equalsIgnoreCase("Fruit"))
		{
			lstAdditons.add("Vinegar");
			lstAdditons.add("Ground Black Pepper");
			lstAdditons.add("Lemon Juice");
			lstAdditons.add("Salt");
		}
		else if(strName.equalsIgnoreCase("Seafood"))
		{
			lstAdditons.add("Olive Oil");
			lstAdditons.add("Ground Black Pepper");
			lstAdditons.add("Salad Cream");
			lstAdditons.add("Salt");
		}
		else if(strName.equalsIgnoreCase("Chicken"))
		{
			lstAdditons.add("Olive Oil");
			lstAdditons.add("Ground Black Pepper");
			lstAdditons.add("Mustard");
			lstAdditons.add("Salt");
		}
		Collections.sort(lstAdditons);
		
		lstEdit.add("ADDITIONS : ");
		lstEdit.addAll(lstAdditons);
		lstEdit.add("");
		lstEdit.add("INGREDIENTS : ");
		lstEdit.addAll(sldSalad.getIngredients());
	}
	
	public List<String> getIngredients()
	{
		return lstEdit;
	}
	
	public String[] getIngredientsArray()
	{
		
		String[] strIngred = new String[lstEdit.size()];
		strIngred = lstEdit.toArray(strIngred);
		return strIngred;
	}
	
	public String[] getAdditionsArray()
	{
		
		String[] strAdditions = new String[lstAdditons.size()];
		strAdditions = lstAdditons.toArray(strAdditions);
		return strAdditions;
	}
}
