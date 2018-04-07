import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Mainmain extends JFrame
{
	private JLabel header;
	private JLabel lblSalad;
	private JLabel lblPizza;
	private JLabel lblLunch;
	private JLabel lblBreakfast;
	private JButton btnSalad;
	private JButton btnPizza;
	private JButton btnLunch;
	private JButton btnBreakfast;
	private JPanel panel;
	private JPanel change = new JPanel();
	private JPanel login;
	private JPanel panelAll;
	private static JButton btnLogin;
	private JButton btnBack;
	private static JLabel lblWelcome;
	private static boolean blLogin = false;
	
	public Mainmain()
	{
		super("EclipseFood");
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		change.setLayout(new CardLayout());
		
		login = new JPanel();
		login.setLayout(new FlowLayout());
		
		panelAll = new JPanel();
		panelAll.setLayout(new GridBagLayout());
		
		//define labels
		header = new JLabel("Choose ");
		header.setFont(new Font("Serif", Font.BOLD,20));
		
		lblSalad = new JLabel("Salad");
		lblPizza = new JLabel("Pizza");
		lblLunch = new JLabel("Lunch");
		lblBreakfast = new JLabel("Breakfast");
		
		//handler
		ButtonHandler handler = new ButtonHandler();
		
		
		//define images
		Icon saladIcn1 = new ImageIcon(getClass().getResource("salad1.jpg"));
		Icon saladIcn2 = new ImageIcon(getClass().getResource("salad2.jpg"));
		btnSalad = new JButton(saladIcn1);
		btnSalad.setRolloverIcon(saladIcn2);
		btnSalad.addActionListener(handler);
		
		Icon pizzaIcn1 = new ImageIcon(getClass().getResource("pizza1.jpg"));
		Icon pizzaIcn2 = new ImageIcon(getClass().getResource("pizza2.jpg"));
		btnPizza = new JButton(pizzaIcn1);
		btnPizza.setRolloverIcon(pizzaIcn2);
		btnPizza.addActionListener(handler);
		
		Icon lunchIcn1 = new ImageIcon(getClass().getResource("lunch1.jpg"));
		Icon lunchIcn2 = new ImageIcon(getClass().getResource("lunch2.jpg"));
		btnLunch = new JButton(lunchIcn1);
		btnLunch.setRolloverIcon(lunchIcn2);
		btnLunch.addActionListener(handler);
		
		Icon breakfastIcn1 = new ImageIcon(getClass().getResource("breakfast1.jpg"));
		Icon breakfastIcn2 = new ImageIcon(getClass().getResource("breakfast2.jpg"));
		btnBreakfast = new JButton(breakfastIcn1);
		btnBreakfast.setRolloverIcon(breakfastIcn2);
		btnBreakfast.addActionListener(handler);
		
		
		btnBack = new JButton("Back");
		btnBack.setVisible(false);
		btnBack.addActionListener(handler);
		login.add(btnBack);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(handler);
		login.add(btnLogin);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		
		//adding components
		
		//add header
		c.gridx = 2;
		c.gridy = 1;
		panel.add(header,c);
		
		//add for salad
		c.gridx = 1;
		c.gridy = 2;
		panel.add(lblSalad,c);
		
		c.gridx = 2;
		c.gridy = 2;
		panel.add(btnSalad,c);
		
		//add for pizza
		c.gridx = 1;
		c.gridy = 3;
		panel.add(lblPizza,c);
		
		c.gridx = 2;
		c.gridy = 3;
		panel.add(btnPizza,c);
		
		//add for lunch
		c.gridx = 1;
		c.gridy = 4;
		panel.add(lblLunch,c);
		
		c.gridx = 2;
		c.gridy = 4;
		panel.add(btnLunch,c);
		
		//add for breakfast
		c.gridx = 1;
		c.gridy = 5;
		panel.add(lblBreakfast,c);
		
		c.gridx = 2;
		c.gridy = 5;
		panel.add(btnBreakfast,c);
		
		change.add(panel);
		
		change.add("Choose",panel);
		
		//add classes to panel
		Main mSalad = new Main();
		change.add("Salad", mSalad.getPanel());
		
		Login l = new Login();
		change.add("Login", l.getPanel());
		
		c.gridx = 1;
		c.gridy = 1;
		panelAll.add(login,c);
		
		c.gridx = 1;
		c.gridy = 2;
		panelAll.add(change,c);
		
		
		c.gridx = 1;
		c.gridy = 0;
		lblWelcome = new JLabel("You are not logged in");
		lblWelcome.setFont(new Font("serif", Font.ITALIC+Font.BOLD,14));
		panelAll.add(lblWelcome,c);
		
		add(new JScrollPane(panelAll));
		
		((CardLayout) change.getLayout()).show(change, "Choose");
		
		
	}
	
	public JPanel getPanel()
	{
		return panelAll;
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			if(event.getSource()==btnSalad)
			{
				btnBack.setVisible(true);
				btnLogin.setVisible(false);
				((CardLayout) change.getLayout()).show(change, "Salad");
			}
			else if(event.getSource()==btnLogin)
			{
				if(blLogin)
				{
					
					lblWelcome.setText("You are not logged in");
					btnLogin.setText("Login");
					blLogin = false;
				}
				else
				{
					btnBack.setVisible(true);
					btnLogin.setVisible(false);
					((CardLayout) change.getLayout()).show(change, "Login");
					
				}
			}
			else if(event.getSource()==btnBack)
			{
				btnBack.setVisible(false);
				btnLogin.setVisible(true);
				((CardLayout) change.getLayout()).show(change, "Choose");
			}
		}
		
	}
	
	public static void setLogin(boolean login,String username)
	{
		blLogin = login;
		lblWelcome.setText("Welcome "+username);
		btnLogin.setText("Logout");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args [])
	{
		Mainmain m = new Mainmain();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setSize(700,500);
		m.setVisible(true);
	}

	
	
}
