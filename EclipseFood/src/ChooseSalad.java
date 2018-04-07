import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseSalad extends JFrame
{
	private JPanel panel;
	private JList lstNames;
	private JLabel lblInstruction;
	private Salad sldSalad;
	private JList lstSelected;
	private DefaultListModel lmIngred;
	private JLabel lblFoundIngred;
	private JCheckBox cbAddition;
	private Additions addSalad;
	private JLabel lblPriceTag;
	private JLabel lblPrice;
	private JButton btnAddCart;
	
	public ChooseSalad()
	{
		super("Choose salad");
		setLayout(new CardLayout());
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		//to select salad
		String[] arrName = {"Caesar Salad (Rs 125)","Chicken Salad (Rs 125)","Fruit Salad (Rs 100)","Seafood Salad (Rs 150)"};
		
		lblInstruction = new JLabel("Select salad:");
		
		lstNames = new JList(arrName);
		lstNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstNames.setVisibleRowCount(4);
		ListListener listener = new ListListener();
		lstNames.addListSelectionListener(listener);
		
		//with addition or not
		cbAddition = new JCheckBox("With Addition (Rs 10 additional)");
		CheckBoxListener cbListener = new CheckBoxListener();
		cbAddition.addItemListener(cbListener);
		
		//found ingredients
		lmIngred = new DefaultListModel();
		lstSelected = new JList(lmIngred);
		lstSelected.setVisibleRowCount(10);
		lstSelected.setSelectionModel(new NoSelectionModel());//prevent selection of items
		lstSelected.setFixedCellWidth(150);
		lstSelected.setFixedCellHeight(20);
		JScrollPane spScrollSelected = new JScrollPane(lstSelected);
		spScrollSelected.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		lblFoundIngred = new JLabel("Contains the following ingredients:");
		
		lblPriceTag = new JLabel("Total Price: ");
		lblPrice = new JLabel();
		lblPrice.setPreferredSize(new Dimension(200,20));
		
		btnAddCart = new JButton("Add to cart");
		ButtonHandler btnHandler = new ButtonHandler();
		btnAddCart.addActionListener(btnHandler);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		
		//instruction to select salad from list
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblInstruction,c);
		
		//list of salad names
		c.gridx = 0;
		c.gridy = 2;
		panel.add(new JScrollPane(lstNames),c);
		
		//checkbox
		c.gridx = 1;
		c.gridy = 2;
		panel.add(cbAddition,c);
		
		//information to know ingredients
		c.gridx = 0;
		c.gridy = 3;
		panel.add(lblFoundIngred,c);
		
		//list of ingredients found
		c.gridx = 0;
		c.gridy = 4;
		panel.add(spScrollSelected,c);
		
		//display price
		c.gridx = 0;
		c.gridy = 5;
		panel.add(lblPriceTag,c);
		
		c.gridx = 1;
		c.gridy = 5;
		panel.add(lblPrice,c);
		
		//add to cart
		c.gridx = 2;
		c.gridy = 5;
		panel.add(btnAddCart,c);
		
		add(panel);
		
	}
	
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent arg0) 
		{
			changeControl();	
		}
			
	}
	
	private class CheckBoxListener implements ItemListener
	{

		public void itemStateChanged(ItemEvent arg0) 
		{
			changeControl();
		}
		
	}
	public void changeControl()
	{
		String strSaladName = null;
		String[] arrIngred;
		int price = 0;
		
		//get index on list
		if(lstNames.getSelectedIndex()==0)
		{
			lmIngred.clear();
			strSaladName="caesar";
			price = 125;
		}
		else if(lstNames.getSelectedIndex()==1)
		{
			lmIngred.clear();
			strSaladName="chicken";
			price = 125;
		}
		else if(lstNames.getSelectedIndex()==2)
		{
			lmIngred.clear();
			strSaladName="Fruit";
			price = 100;
		}
		else if(lstNames.getSelectedIndex()==3)
		{
			lmIngred.clear();
			strSaladName="seafood";
			price = 150;
			
		}
		
		//check if check box is selected or not
		if(cbAddition.isSelected())
		{
			addSalad = new Additions(strSaladName);
			arrIngred = addSalad.getIngredientsArray();
			price+=10;
		}
		else
		{
			sldSalad = new Salad(strSaladName);
			arrIngred = sldSalad.getIngredientsArray();
		}
			
		//add array items to the list of found ingredients
		for(String ingred : arrIngred)
		{
			lmIngred.addElement(ingred);
		}
		
		lblPrice.setText("Rs "+Integer.toString(price));
		
	}
	
	//to prevent list from being selected  reference:https://stackoverflow.com/questions/31669350/disable-jlist-cell-selection-property
	private static class NoSelectionModel extends DefaultListSelectionModel 
	{

		   @Override
		   public void setAnchorSelectionIndex(final int anchorIndex) {}

		   @Override
		   public void setLeadAnchorNotificationEnabled(final boolean flag) {}

		   @Override
		   public void setLeadSelectionIndex(final int leadIndex) {}

		   @Override
		   public void setSelectionInterval(final int index0, final int index1) { }
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==btnAddCart)
			{
				if(lstNames.isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Select a salad first");
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		ChooseSalad s = new ChooseSalad();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(500, 500);
		s.setVisible(true);
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
}
