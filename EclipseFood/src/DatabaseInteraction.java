import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseInteraction {
	private Connection con;
	public static int id = 0;
	
	public boolean connection()
	{
		try
		{
			//connection with sql server
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//define server used
			String server = "YAHJUSHEE-HP\\SQLQW";
			//define port used by sql server
			int port = 11612;
			//define database to be used
			String database = "OOSD";
			
			//connection string
			String jdbcURL = "jdbc:sqlserver://"+server+":"+port+";databaseName="+database+";integratedSecurity=true";
			
			//connect to the database
			con = DriverManager.getConnection(jdbcURL);
			
			return true;
			
		}
		catch(Exception err)
		{
			System.out.println("ERROR: "+err);
			return false;
		}
	}
	
	public boolean register(String strUsername,String strPassword,String strAddress,int intPhoneNumber,String strEmail)
	{
		if(connection())
		{
			try
			{
				//to create statement
				Statement st = con.createStatement();
				
				st.execute("SELECT ID FROM Account where Username = '"+strUsername+"'");
				
				ResultSet rs = st.getResultSet();
				
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null, "Username already taken. Select another username");
				}
				else
				{
					st.execute("Insert into Account(Username,Password,Address,PhoneNumber,Email) values('"+strUsername+"','"+strPassword+"','"+strAddress+"',"+intPhoneNumber+",'"+strEmail+"')");
					JOptionPane.showMessageDialog(null, "Registration successful");
				}
				
				st.close();
				con.close();
				return true;
			}
			catch(Exception err)
			{
				System.out.println("ERROR: "+err);
				return false;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Unsuccessful connection with server");
			return false;
		}
		
	}
	
	public boolean login(String strUsername,String strPassword)
	{
		if(connection())
		{
			try
			{
				Statement st = con.createStatement();
				
				st.execute("Select Password,ID from Account where Username = '"+strUsername+"'");
				
				ResultSet rs = st.getResultSet();
				if(rs!=null)
				{
					while(rs.next())
					{
						if(strPassword.equals(rs.getString("Password")))
						{
							id=rs.getInt("ID");
							JOptionPane.showMessageDialog(null,"Welcome "+strUsername);
							st.close();
							con.close();
							return true;
						}
					}
				}
				st.close();
				con.close();
				return false;
			}
			catch(Exception err)
			{
				System.out.println("ERROR: "+err);
				return false;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Unsuccessful connection with server");
			return false;
		}
		
	}
}
