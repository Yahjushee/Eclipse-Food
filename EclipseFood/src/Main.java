import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

//salad so main

public class Main extends JFrame
{
	private JPanel change = new JPanel();
	private JButton btnChooseSalad;
	private JButton btnCustomize;
	private JPanel panel;
	private JPanel panelAll;
	
	public Main()
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		setVisible(true);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panelAll = new JPanel();
		panelAll.setLayout(new GridBagLayout());
		
		change.setLayout(new CardLayout());
		ChooseSalad cs = new ChooseSalad();
		CustomizeSalad custS = new CustomizeSalad();
		
		btnChooseSalad = new JButton("Choose Salad");
		btnCustomize = new JButton("Customize Salad");
		ButtonHandler handler = new ButtonHandler();
		btnChooseSalad.addActionListener(handler);
		btnCustomize.addActionListener(handler);
		
		
		panel.add(btnChooseSalad);
		panel.add(btnCustomize);

		change.add("ChooseSalad",cs.getPanel());
		change.add("CustomizeSalad",custS.getPanel());
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		
		c.gridx = 1;
		c.gridy = 1;
		panelAll.add(panel,c);
		
		c.gridx = 1;
		c.gridy = 2;
		panelAll.add(change,c);
		
		add(panelAll);
		
		//this.setContentPane(change);
		
		((CardLayout) change.getLayout()).show(change, "ChooseSalad");
		btnChooseSalad.setVisible(false);
	
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==btnCustomize)
			{
				btnChooseSalad.setVisible(true);
				btnCustomize.setVisible(false);
				((CardLayout) change.getLayout()).show(change, "CustomizeSalad");
			}
			else if(event.getSource()==btnChooseSalad)
			{
				btnCustomize.setVisible(true);
				btnChooseSalad.setVisible(false);
				((CardLayout) change.getLayout()).show(change, "ChooseSalad");
			}
		}
	}
	
	public JPanel getPanel()
	{
		return panelAll;
	}
	
	public static void main(String[]args)
	{
		Main m = new Main();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setSize(700,500);
		m.setVisible(true);
	}
}
