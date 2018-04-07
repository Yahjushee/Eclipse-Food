import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CustomizeSalad extends JFrame
{
	private JList lstSelectIngredients;
	private JList lstSelectEggType;
	private JList lstSelectCheese;
	private JList lstSelectAnimal;
	private JList lstSelectFruits;
	private JList lstSelectAdditons;
	private JLabel lblSelect7;
	private JLabel lblSelect4;
	private JLabel lblIngredients;
	private JLabel lblEggType;
	private JLabel lblAnimal;
	private JLabel lblCheese;
	private JLabel lblFruits;
	private JLabel lblAdditions;
	private JPanel panel;
	private Salad sldSalad;
	private Additions addSalad;
	private JList lstSelectedIngred;
	private DefaultListModel lmIngred;
	private JList lstSelectedAddition;
	private DefaultListModel lmAddition;
	private JLabel lblPriceTag;
	private JLabel lblPrice;
	private JButton btnCalculatePrice;
	private JButton btnAddCart;
	
	public CustomizeSalad()
	{
		super("Customize Salad");
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		//option to customize
		lblSelect7 = new JLabel("Choose 7 ingredients");
		lblSelect7.setPreferredSize(new Dimension(200,20));
		
		lblSelect4 = new JLabel("Choose 4 additions(optional)");
		lblSelect4.setPreferredSize(new Dimension(200,20));
		
		sldSalad = new Salad("customize");
		//fill list for customization
		lblAnimal = new JLabel("MEAT (Rs 25 each):");
		lstSelectAnimal = new JList(sldSalad.getAnimalsArray());
		lstSelectAnimal.setVisibleRowCount(5);
		lstSelectAnimal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionIngred igredListener = new ListSelectionIngred();
		lstSelectAnimal.addListSelectionListener(igredListener);
		
		lblFruits = new JLabel("FRUITS (Rs 10 each):");
		lstSelectFruits = new JList(sldSalad.getFruitsArray());
		lstSelectFruits.setVisibleRowCount(5);
		lstSelectFruits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSelectFruits.addListSelectionListener(igredListener);
		
		lblEggType = new JLabel("EGG TYPE (Rs 5 each):");
		lstSelectEggType = new JList(sldSalad.getEggTypeArray());
		lstSelectEggType.setVisibleRowCount(5);
		lstSelectEggType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSelectEggType.addListSelectionListener(igredListener);
		
		lblIngredients = new JLabel("OTHER INGREDIENTS (Rs 20 each):");
		lstSelectIngredients = new JList(sldSalad.getIngredientsArray());
		lstSelectIngredients.setVisibleRowCount(5);
		lstSelectIngredients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSelectIngredients.addListSelectionListener(igredListener);
		
		lblCheese = new JLabel("CHEESE (Rs 15 each):");
		lstSelectCheese = new JList(sldSalad.getCheeseArray());
		lstSelectCheese.setVisibleRowCount(5);
		lstSelectCheese.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSelectCheese.addListSelectionListener(igredListener);
		
		
		addSalad = new Additions("customize");
		lblAdditions = new JLabel("ADDITIONS (Rs 10 additional):");
		lstSelectAdditons = new JList(addSalad.getAdditionsArray());
		lstSelectAdditons.setVisibleRowCount(5);
		lstSelectAdditons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionAddition addListener = new ListSelectionAddition();
		lstSelectAdditons.addListSelectionListener(addListener);
		
		lmIngred = new DefaultListModel();
		lstSelectedIngred = new JList(lmIngred);
		lstSelectedIngred.setVisibleRowCount(8);
		lmIngred.addElement("INGREDIENTS SELECTED: ");
		lstSelectedIngred.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectedRemove rmvListener = new ListSelectedRemove();
		lstSelectedIngred.addListSelectionListener(rmvListener);
		
		lmAddition = new DefaultListModel();
		lstSelectedAddition = new JList(lmAddition);
		lstSelectedAddition.setVisibleRowCount(5);
		lmAddition.addElement("ADDITIONS SELECTED: ");
		lstSelectedAddition.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSelectedAddition.addListSelectionListener(rmvListener);
		
		//display price
		lblPriceTag = new JLabel("Total Price");
		lblPrice = new JLabel();
		lblPrice.setPreferredSize(new Dimension(100,20));
		
		//to calculate the price
		btnCalculatePrice = new JButton("Calculate Price");
		ButtonHandler btnHandler = new ButtonHandler();
		btnCalculatePrice.addActionListener(btnHandler);
		
		btnAddCart = new JButton("Add to cart");
		btnAddCart.addActionListener(btnHandler);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		
		//option customize
		c.gridx = 1;
		c.gridy = 0;
		panel.add(lblSelect7,c);
		
		//choose ingredients
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblIngredients,c);
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(new JScrollPane(lstSelectIngredients),c);
		
		//choose animal
		c.gridx = 1;
		c.gridy = 2;
		panel.add(lblAnimal,c);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(new JScrollPane(lstSelectAnimal),c);
		
		//choose fruits
		c.gridx = 2;
		c.gridy = 2;
		panel.add(lblFruits,c);
		
		c.gridx = 2;
		c.gridy = 3;
		panel.add(new JScrollPane(lstSelectFruits),c);
		
		//choose egg type
		c.gridx = 3;
		c.gridy = 2;
		panel.add(lblEggType,c);
		
		c.gridx = 3;
		c.gridy = 3;
		panel.add(new JScrollPane(lstSelectEggType),c);
		
		//choose cheese
		c.gridx = 4;
		c.gridy = 2;
		panel.add(lblCheese,c);
		
		c.gridx = 4;
		c.gridy = 3;
		panel.add(new JScrollPane(lstSelectCheese),c);
		
		//instruction for addition
		c.gridx = 5;
		c.gridy = 0;
		panel.add(lblSelect4,c);
		
		//choose additions
		c.gridx = 5;
		c.gridy = 2;
		panel.add(lblAdditions,c);
		
		c.gridx = 5;
		c.gridy = 3;
		panel.add(new JScrollPane(lstSelectAdditons),c);
		
		//display selected ingredients
		c.gridx = 1;
		c.gridy = 4;
		panel.add(new JScrollPane(lstSelectedIngred),c);
		
		//display selected additions
		c.gridx = 5;
		c.gridy = 4;
		panel.add(new JScrollPane(lstSelectedAddition),c);
		
		//to display price
		c.gridx = 1;
		c.gridy = 5;
		panel.add(lblPriceTag,c);
		
		c.gridx = 2;
		c.gridy = 5;
		panel.add(lblPrice,c);
		
		//to calculate price
		c.gridx = 4;
		c.gridy = 5;
		panel.add(btnCalculatePrice,c);
		
		//add to cart
		c.gridx = 5;
		c.gridy = 5;
		panel.add(btnAddCart,c);
		
		add(panel);
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
	
	private class ListSelectionAddition implements ListSelectionListener
	{
		
		public void valueChanged(ListSelectionEvent event) 
		{
			boolean contains=false;
			String value = (String) lstSelectAdditons.getSelectedValue();
			if(lmAddition.size()>=5)
			{
				lblSelect4.setText("Maximum additions choosen");
				lblSelect4.setForeground(Color.RED);
			}
			else
			{
				for(int i=0;i<lmAddition.size();i++)
				{
					if(lmAddition.contains(value))
					{
						contains=true;
					}
				}
				if(contains==false)
				{
					lmAddition.addElement(value);
				}
			}
			
		}
		
	}
	
	private class ListSelectionIngred implements ListSelectionListener
	{

		public void valueChanged(ListSelectionEvent event) 
		{
			boolean contains=false;
			String value = "";
			if(event.getSource()==lstSelectAnimal)
			{
				value = (String) lstSelectAnimal.getSelectedValue();
			}
			else if(event.getSource()==lstSelectIngredients)
			{
				value = (String) lstSelectIngredients.getSelectedValue();
			}
			else if(event.getSource()==lstSelectFruits)
			{
				value = (String) lstSelectFruits.getSelectedValue();
			}
			else if(event.getSource()==lstSelectEggType)
			{
				value = (String) lstSelectEggType.getSelectedValue();
			}
			else if(event.getSource()==lstSelectCheese)
			{
				value = (String) lstSelectCheese.getSelectedValue();
			}
			if(lmIngred.size()>=8)
			{
				lblSelect7.setText("Maximum ingredients choosen");
				lblSelect7.setForeground(Color.RED);
			}
			else
			{
				for(int i=0;i<lmIngred.size();i++)
				{
					if(lmIngred.contains(value))
					{
						contains=true;
					}
				}
				if(contains==false)
				{
					if(!value.equals(""))
					{
						lmIngred.addElement(value);
					}	
				}
			}
			
		}
		
	}
	
	private class ListSelectedRemove implements ListSelectionListener
	{

		public void valueChanged(ListSelectionEvent event) 
		{
			int index;
			if(event.getSource()==lstSelectedIngred)
			{
				index = lstSelectedIngred.getSelectedIndex();
				if(index!=0 && index!=-1)
				{
					lblSelect7.setText("Choose 7 ingredients");
					lblSelect7.setForeground(Color.BLACK);
					lmIngred.remove(index);
				}
				
			}
			else if(event.getSource()==lstSelectedAddition)
			{
				index = lstSelectedAddition.getSelectedIndex();
				if(index!=0 && index!=-1)
				{
					lblSelect4.setText("Choose 4 additions(optional)");
					lblSelect4.setForeground(Color.BLACK);
					lmAddition.remove(index);
				}
				
			}
		}
		
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int sizeAddition = lmAddition.size();
			int sizeIngredients = lmIngred.size();
			String[] arrIngred = sldSalad.getIngredientsArray();
			String[] arrFruits = sldSalad.getFruitsArray();
			String[] arrEggType = sldSalad.getEggTypeArray();
			String[] arrAnimal = sldSalad.getAnimalsArray();
			String[] arrCheese = sldSalad.getCheeseArray();
			boolean check = false;
			int price = 0;
			
			if(event.getSource()==btnCalculatePrice)
			{
				if(sizeIngredients<8)
				{
					JOptionPane.showMessageDialog(null, "Add a total of 7 ingredients");
					check=false;
				}
				else if(sizeAddition>1&&sizeAddition<5)
				{
					JOptionPane.showMessageDialog(null, "Either add 4 additions or remove the additons");
					check = false;
				}
				else
				{
					check = true;
					if(sizeAddition==5)
					{
						price+=10;
					}
					for(int i=1;i<lmIngred.size();i++)
					{
						//find ingredients
						for(int j=0;j<arrIngred.length;j++)
						{
							if(lmIngred.getElementAt(i).equals(arrIngred[j]))
							{
								price+=20;
							}
						}
						for(int j=0;j<arrFruits.length;j++)
						{
							if(lmIngred.getElementAt(i).equals(arrFruits[j]))
							{
								price+=10;
							}
						}
						for(int j=0;j<arrEggType.length;j++)
						{
							if(lmIngred.getElementAt(i).equals(arrEggType[j]))
							{
								price+=5;
							}
						}
						for(int j=0;j<arrAnimal.length;j++)
						{
							if(lmIngred.getElementAt(i).equals(arrAnimal[j]))
							{
								price+=25;
							}
						}
						for(int j=0;j<arrCheese.length;j++)
						{
							if(lmIngred.getElementAt(i).equals(arrCheese[j]))
							{
								price+=15;
							}
						}
					}
					lblPrice.setText("Rs "+Integer.toString(price));
				}
			}
			
			if(event.getSource()==btnAddCart)
			{
				btnCalculatePrice.doClick();
				
			}
		}
	}
	
	public static void main(String[]args)
	{
		CustomizeSalad m = new CustomizeSalad();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setSize(700,500);
		m.setVisible(true);
	}

	
}
