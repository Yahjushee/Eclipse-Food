import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Login extends JFrame
{
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblErrorUsername;
	private JLabel lblPassword;
	private JPasswordField pwdPassword;
	private JLabel lblErrorPassword;
	private JButton btnSubmit;
	private JLabel lblMessage;
	private JButton btnRegister;
	private JPanel panel;
	private JPanel change = new JPanel();
	private CardLayout card = new CardLayout();
	private JPanel panelButtons;
	private JButton btnLogin;
	private JPanel panelAll = new JPanel();
	
	public Login()
	{
		//set title
		super("Login");
		panelAll.setLayout(new GridBagLayout());
		change.setLayout(new CardLayout());
		panel = new JPanel();
		//set layout
		panel.setLayout(new GridBagLayout());
		
		//Set button panel
		panelButtons = new JPanel();
		panelButtons.setLayout(new FlowLayout());
		
		//constraint
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		
		
		//username field
		lblUsername = new JLabel("Username");
		txtUsername = new JTextField(15);
		lblErrorUsername = new JLabel();
		
		//set minimum size
		lblUsername.setMinimumSize(new Dimension(150,20));
		txtUsername.setMinimumSize(new Dimension(150,20));
		lblErrorUsername.setPreferredSize(new Dimension(220,20));
				
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
		lblPassword = new JLabel("Password");
		pwdPassword = new JPasswordField(15);
		lblErrorPassword = new JLabel();
		
		//set minimum size
		lblPassword.setMinimumSize(new Dimension(150,20));
		pwdPassword.setMinimumSize(new Dimension(150,20));
		lblErrorPassword.setPreferredSize(new Dimension(220,20));
		
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
		
		//submit button
		btnSubmit = new JButton("Submit");
		ButtonHandler btnHandler = new ButtonHandler();
		btnSubmit.addActionListener(btnHandler);
		btnSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(btnSubmit,c);
		
		//message to register
		lblMessage = new JLabel("Don't have an account?");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		c.gridx = 1;
		c.gridy = 4;
		panel.add(lblMessage,c);
		
		//set error labels red
		lblErrorUsername.setForeground(Color.red);
		lblErrorPassword.setForeground(Color.red);
		
		//add the panel
		change.add("Login",panel);
		
		Register r = new Register();
		JPanel p = new JPanel();
		p=r.getPanel();
		change.add("Register",p);
		
		c.gridx = 1;
		c.gridy = 1;
		panelAll.add(change,c);
		
		//register page button
		btnRegister = new JButton("Register Page");
		btnRegister.addActionListener(btnHandler);
		
		//login page button
		btnLogin = new JButton("Login Page");
		btnLogin.addActionListener(btnHandler);
		btnLogin.setVisible(false);
		
		panelButtons.add(btnLogin);
		panelButtons.add(btnRegister);
		
		c.gridx = 1;
		c.gridy = 2;
		panelAll.add(panelButtons,c);
		
		add(panelAll);
		((CardLayout) change.getLayout()).show(change, "Login");
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==btnSubmit)
			{
				boolean blUsername = false;
				boolean blPassword = false;
				if(txtUsername.getText().equals(""))
				{
					lblErrorUsername.setText("Enter username");
					blUsername = false;
				}
				else
				{
					lblErrorUsername.setText("");
					blUsername = true;
				}
				if(pwdPassword.getText().equals(""))
				{
					lblErrorPassword.setText("Enter password");
					blPassword = false;
				}
				else
				{
					lblErrorPassword.setText("");
					blPassword = true;
				}
				
				if(blPassword&&blUsername)
				{
					DatabaseInteraction diLogin = new DatabaseInteraction();
					if(!diLogin.login(txtUsername.getText(), pwdPassword.getText()))
					{
						JOptionPane.showMessageDialog(null, "Invalid username or password");
						txtUsername.setText("");
						pwdPassword.setText("");
					}
					else
					{
						Mainmain.setLogin(true,txtUsername.getText());
					}
				}
				
				
			}
			else if(event.getSource()==btnRegister)
			{
				btnLogin.setVisible(true);
				btnRegister.setVisible(false);
				((CardLayout) change.getLayout()).show(change, "Register");
				
			}
			else if(event.getSource()==btnLogin)
			{
				btnLogin.setVisible(false);
				btnRegister.setVisible(true);
				((CardLayout) change.getLayout()).show(change, "Login");
			}
		}
	}
	
	public JPanel getPanel()
	{
		return panelAll;
	}
	
	public static void main(String[]args)
	{
		Login l = new Login();
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setSize(700,500);
		l.setVisible(true);
		
	}
}
