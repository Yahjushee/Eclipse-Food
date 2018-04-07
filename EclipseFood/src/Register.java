import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Register extends JFrame{
	
	//components to be used
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JLabel lblErrorUsername;
	private JPasswordField pwdPassword;
	private JLabel lblPassword;
	private JLabel lblErrorPassword;
	private JPasswordField pwdConfirmPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblErrorConfirmPassword;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblErrorEmail;
	private JComboBox cmbAddress;
	private JLabel lblAddress;
	private JLabel lblErrorAddress;
	private JTextField txtPhoneNumber;
	private JLabel lblPhoneNumber;
	private JLabel lblErrorPhoneNumber;
	private JButton btnRegister;
	private JPanel panel;
	private JPanel change = new JPanel();
	private CardLayout card = new CardLayout();
	
	public Register()
	{
		//set title
		super("Register");
		
		change.setLayout(new CardLayout());
		panel = new JPanel();
		//7 rows, 3 columns 
		panel.setLayout(new GridBagLayout());
		
		//constraint
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		
		
		//username field
		lblUsername = new JLabel("Username *");
		txtUsername = new JTextField(30);
		lblErrorUsername = new JLabel();
		
		//set minimum size
		lblUsername.setMinimumSize(new Dimension(150,20));
		txtUsername.setMinimumSize(new Dimension(150,20));
		lblErrorUsername.setMinimumSize(new Dimension(220,20));
		
		//add username field
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblUsername,c);
		
		c.gridx = 1;
		c.gridy = 1;
		panel.add(txtUsername,c);
		
		c.gridx = 2;
		c.gridy = 1;
		panel.add(lblErrorUsername,c);
		
		//password field
		lblPassword = new JLabel("Password *");
		pwdPassword = new JPasswordField(30);
		lblErrorPassword = new JLabel();
		
		//set minimum size
		lblPassword.setMinimumSize(new Dimension(150,20));
		pwdPassword.setMinimumSize(new Dimension(150,20));
		lblErrorPassword.setMinimumSize(new Dimension(220,20));
		
		//add password field
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblPassword,c);
		
		c.gridx = 1;
		c.gridy = 2;
		panel.add(pwdPassword,c);
		
		c.gridx = 2;
		c.gridy = 2;
		panel.add(lblErrorPassword,c);
		
		//confirm password field
		lblConfirmPassword = new JLabel("Confirm Password *");
		pwdConfirmPassword = new JPasswordField(30);
		lblErrorConfirmPassword = new JLabel();
		
		//set minimum size
		lblConfirmPassword.setMinimumSize(new Dimension(150,20));
		pwdConfirmPassword.setMinimumSize(new Dimension(150,20));
		lblErrorConfirmPassword.setMinimumSize(new Dimension(220,20));
		
		//add confirm password field
		c.gridx = 0;
		c.gridy = 3;
		panel.add(lblConfirmPassword,c);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(pwdConfirmPassword,c);
		
		c.gridx = 2;
		c.gridy = 3;
		panel.add(lblErrorConfirmPassword,c);
		
		//email field
		lblEmail = new JLabel("Email *");
		txtEmail = new JTextField(50);
		lblErrorEmail = new JLabel();
		
		//set minimum size
		lblEmail.setMinimumSize(new Dimension(150,20));
		txtEmail.setMinimumSize(new Dimension(150,20));
		lblErrorEmail.setMinimumSize(new Dimension(220,20));
		
		//add email field
		c.gridx = 0;
		c.gridy = 4;
		panel.add(lblEmail,c);
		
		c.gridx = 1;
		c.gridy = 4;
		panel.add(txtEmail,c);
		
		c.gridx = 2;
		c.gridy = 4;
		panel.add(lblErrorEmail,c);
		
		//address field
		lblAddress = new JLabel("Address *");
		final String[] strAddress = {"SELECT","Glen Park","Phoenix","Vacoas"};
		cmbAddress = new JComboBox(strAddress);
		lblErrorAddress = new JLabel();
		
		//set minimum size
		lblAddress.setMinimumSize(new Dimension(150,20));
		cmbAddress.setMinimumSize(new Dimension(150,20));
		lblErrorAddress.setMinimumSize(new Dimension(220,20));
		
		//add address field
		c.gridx = 0;
		c.gridy = 5;
		panel.add(lblAddress,c);
		
		c.gridx = 1;
		c.gridy = 5;
		panel.add(cmbAddress,c);
		
		c.gridx = 2;
		c.gridy = 5;
		panel.add(lblErrorAddress,c);
		
		//phone number field
		lblPhoneNumber = new JLabel("Phone number *");
		txtPhoneNumber = new JTextField("5",8);
		lblErrorPhoneNumber = new JLabel();
		
		//set minimum size
		lblPhoneNumber.setMinimumSize(new Dimension(150,20));
		txtPhoneNumber.setMinimumSize(new Dimension(150,20));
		lblErrorPhoneNumber.setMinimumSize(new Dimension(220,20));
		
		
		//add phone number field
		c.gridx = 0;
		c.gridy = 6;
		panel.add(lblPhoneNumber,c);
		
		c.gridx = 1;
		c.gridy = 6;
		panel.add(txtPhoneNumber,c);
		
		c.gridx = 2;
		c.gridy = 6;
		panel.add(lblErrorPhoneNumber,c);
		
		
		//register button
		ButtonHandler btnHandler = new ButtonHandler();
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(btnHandler);
		
		c.gridx = 1;
		c.gridy = 7;
		panel.add(btnRegister,c);
		
		//set error labels red
		lblErrorUsername.setForeground(Color.RED);
		lblErrorPassword.setForeground(Color.RED);
		lblErrorConfirmPassword.setForeground(Color.RED);
		lblErrorEmail.setForeground(Color.RED);
		lblErrorAddress.setForeground(Color.RED);
		lblErrorPhoneNumber.setForeground(Color.RED);
		
		//add the panel
		
		change.add("Register",panel);
		
		
		this.setContentPane(change);
		
		((CardLayout) change.getLayout()).show(change, "Register");
	}
	
	private class ButtonHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event)
		{
			boolean[] blValidate = new boolean[6];//for the six fields
			
			for(int i =0;i<blValidate.length;i++)
			{
				blValidate[i] = false;
			}
			
			if(event.getSource()==btnRegister)
			{
				//validate username
				if(txtUsername.getText().equals(""))
				{
					lblErrorUsername.setText("Username cannot be blank");
					blValidate[0]=false;
				}
				else if(txtUsername.getText().length()>25)
				{
					lblErrorUsername.setText("Username should be less than 25 characters");
					blValidate[0]=false;
				}
				else
				{
					lblErrorUsername.setText("");
					blValidate[0]=true;
				}
				//validate password
				if(pwdPassword.getText().equals(""))
				{
					lblErrorPassword.setText("Password cannot be blank");
					blValidate[1]=false;
				}
				else if(pwdPassword.getText().length()>25)
				{
					lblErrorPassword.setText("Password should be less than 25 characters");
					blValidate[1] = false;
				}
				else
				{
					lblErrorPassword.setText("");
					blValidate[1]=true;
				}
				//validate confirm password
				if(!pwdConfirmPassword.getText().equals(pwdPassword.getText()))
				{
					lblErrorConfirmPassword.setText("Password is not the same as typed above");
					blValidate[2]=false;
				}
				else
				{
					lblErrorConfirmPassword.setText("");
					blValidate[2]=true;
				}
				//validate email
				if(txtEmail.getText().equals(""))
				{
					lblErrorEmail.setText("Email cannot be blank");
					blValidate[3]=false;
				}
				else if(!(txtEmail.getText().contains("@")&&txtEmail.getText().contains(".")))
				{
					lblErrorEmail.setText("Need to have both @ and .");
					blValidate[3]=false;
				}
				else
				{
					lblErrorEmail.setText("");
					blValidate[3]=true;
				}
				//validate address
				if(cmbAddress.getSelectedIndex()==0)
				{
					lblErrorAddress.setText("Please select your address");
					blValidate[4]=false;
				}
				else
				{
					lblErrorAddress.setText("");
					blValidate[4]=true;
				}
				//validate phone number
				if(txtPhoneNumber.getText().equals(""))
				{
					lblErrorPhoneNumber.setText("Phone Number cannot be blank");
					blValidate[5]=false;
				}
				else if(txtPhoneNumber.getText().length()!=8)
				{
					lblErrorPhoneNumber.setText("Phone Number should contain 8 digits");
					blValidate[5]=false;
				}
				else
				{
					try
					{
						Integer.parseInt(txtPhoneNumber.getText());
						lblErrorPhoneNumber.setText("");
						blValidate[5]=true;
					}
					catch(NumberFormatException nfe)
					{
						lblErrorPhoneNumber.setText("Phone number should contain numbers only");
						blValidate[5]=false;
					}
				}
				
				//add to database if all valid
				
				boolean blValid = true;
				//check if valid
				for(int i=0;i<blValidate.length;i++)
				{
					if(blValidate[i]==false)
					{
						blValid = false;
						break;
					}
				}
				if(blValid)
				{
					DatabaseInteraction diRegister = new DatabaseInteraction();
					diRegister.register(txtUsername.getText(), pwdPassword.getText(), cmbAddress.getSelectedItem().toString(), Integer.parseInt(txtPhoneNumber.getText()), txtEmail.getText());
				}
			}
			
		}
	}
	
	public JPanel getPanel()
	{
		return panel;
	}
	
}
