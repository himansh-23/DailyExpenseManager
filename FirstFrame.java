import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.imageio.ImageIO;

import java.awt.Color;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import javafx.scene.layout.Border;

public class FirstFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFrame frame = new FirstFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public FirstFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(85, 107, 47), 5, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		textField = new JTextField();
		textField.setBounds(248, 141, 135, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMonthlyDatabaseSystem = new JLabel("Monthly DataBase System");
		lblMonthlyDatabaseSystem.setForeground(new Color(240, 255, 240));
		lblMonthlyDatabaseSystem.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		lblMonthlyDatabaseSystem.setBounds(113, 43, 252, 28);
		contentPane.add(lblMonthlyDatabaseSystem);
		
		JLabel lblUsername = new JLabel("UserName:-");
		lblUsername.setForeground(new Color(240, 248, 255));
		lblUsername.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		lblUsername.setBounds(83, 138, 135, 31);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password:-");
		
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		lblNewLabel.setBounds(83, 187, 135, 31);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(248, 190, 135, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1=textField.getText();
				String s2=new String(textField_1.getPassword());
			//	System.out.println(s1+"  "+s2);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/manage","root", "");
					Statement stmt=conn.createStatement();
					ResultSet rst=stmt.executeQuery("select * from login where username ='"+s1+"' and password ='"+s2+"'");
					if(rst.next())
					{
					stmt.close();
					conn.close();
					rst.close();
					JOptionPane.showMessageDialog(FirstFrame.this, "Login Successfully", "Login", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new FinalFrames(s1);
					}
					else
					{
					stmt.close();
					conn.close();
					rst.close();
					JOptionPane.showMessageDialog(FirstFrame.this, "Invalid user or password", "Login", JOptionPane.INFORMATION_MESSAGE);
					}	
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBackground(Color.CYAN);
		btnLogin.setBounds(83, 240, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignup = new JButton("Sign-Up");
		btnSignup.setForeground(Color.WHITE);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}
		});
		btnSignup.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 13));
		btnSignup.setBackground(Color.CYAN);
		btnSignup.setBounds(266, 240, 99, 23);
		contentPane.add(btnSignup);
		JLabel lblXx = new JLabel("");
		lblXx.setBackground(new Color(0, 0, 0));
		lblXx.setIcon(new ImageIcon("C:\\\\Users\\\\himan\\\\eclipse-workspace\\\\DatabaseProject\\\\src\\\\Images\\\\\\\\desk.jpg"));
		
		lblXx.setBounds(169, 70, 99, 67);
		contentPane.add(lblXx);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\back3.jpg"));
		label.setBackground(Color.WHITE);
		
   

		label.setBounds(23, 28, 405, 239);
		contentPane.add(label);
		
		
		//ImageIcon ii=new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\\\desk.jpg");
		//ImageIcon ii2=new ImageIcon(ii.getImage().getScaledInstance(108, 61, JLabel.CENTER));
	}
}

 class FinalFrames extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	int Total=0,AmountRemaining=0,cloths=0,travel=0,food=0,health=0,gifts=0,phone=0,saving=0;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	public FinalFrames(String username) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(169, 169, 169));
		frame.setBounds(100, 100, 575, 493);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(ClassNotFoundException ex)
		{
			
		}
		System.out.println("hello");
		try {
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/manage","root","");
			
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from login where username='"+username+"'");
			rst.next();
			//System.out.println(rst.getInt("total"));
			Total=rst.getInt("total"); cloths=rst.getInt("cloths");
			travel=rst.getInt("travel"); food=rst.getInt("food");
			health=rst.getInt("health"); gifts=rst.getInt("gifts");
			phone=rst.getInt("phone"); AmountRemaining=rst.getInt("remaining");
			saving=rst.getInt("saving");
			
			stmt.close();
			conn.close();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		System.out.println("bye");
		JLabel lblNewLabel = new JLabel("");
		ImageIcon i23=new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\head.png");
		ImageIcon i22=new ImageIcon(i23.getImage().getScaledInstance(462, 86, JLabel.CENTER));
		lblNewLabel.setIcon(i22);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(97, 0, 462, 86);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(376, 173, 168, 52);
		frame.getContentPane().add(textField);
		textField.setEditable(false);
		textField.setText(AmountRemaining+"");
		textField.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.MAGENTA);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setStringPainted(true);
		progressBar.setString("Cloths");
		progressBar.setValue(cloths);
		progressBar.setBounds(134, 298, 32, 137);
	//	progressBar.setMinimum(1);
		//progressBar.setMaximum(101);
		frame.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setOrientation(SwingConstants.VERTICAL);
		progressBar_1.setForeground(Color.MAGENTA);
		progressBar_1.setStringPainted(true);
		progressBar_1.setString("Travel");
		progressBar_1.setValue(travel);
		progressBar_1.setBounds(200, 298, 32, 137);
		frame.getContentPane().add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setOrientation(SwingConstants.VERTICAL);
		progressBar_2.setForeground(Color.MAGENTA);
		progressBar_2.setStringPainted(true);
		progressBar_2.setString("Food");
		progressBar_2.setValue(food);
		progressBar_2.setBounds(264, 298, 32, 137);
		frame.getContentPane().add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setOrientation(SwingConstants.VERTICAL);
		progressBar_3.setForeground(Color.MAGENTA);
		progressBar_3.setStringPainted(true);
		progressBar_3.setString("Health");
		progressBar_3.setValue(health);
		progressBar_3.setBounds(330, 298, 32, 137);
		frame.getContentPane().add(progressBar_3);
		
		JProgressBar progressBar_4 = new JProgressBar();
		progressBar_4.setOrientation(SwingConstants.VERTICAL);
		progressBar_4.setForeground(Color.MAGENTA);
		progressBar_4.setStringPainted(true);
		progressBar_4.setString("Gifts");
		progressBar_4.setValue(gifts);
		progressBar_4.setBounds(387, 298, 32, 137);
		frame.getContentPane().add(progressBar_4);
		
		JProgressBar progressBar_5 = new JProgressBar();
		progressBar_5.setOrientation(SwingConstants.VERTICAL);
		progressBar_5.setForeground(Color.MAGENTA);
		progressBar_5.setStringPainted(true);
		progressBar_5.setString("Phone");
		progressBar_5.setValue(phone);
		progressBar_5.setBounds(453, 298, 32, 137);
		frame.getContentPane().add(progressBar_5);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\desk.jpg"));
		label.setBounds(-1, 0, 102, 86);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FinalFrames.class.getResource("/Images/total.png")));
		lblNewLabel_1.setBounds(134, 110, 197, 52);
		frame.getContentPane().add(lblNewLabel_1);

		JTextField lblNewLabel_2 = new JTextField("");
		lblNewLabel_2.setBounds(376, 110, 167, 52);
		lblNewLabel_2.setEditable(false);
		lblNewLabel_2.setText(Total+"");
		//
		textField.setText(AmountRemaining+"");
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FinalFrames.class.getResource("/Images/remain.png")));
		lblNewLabel_3.setBounds(134, 162, 197, 75);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(134, 235, 197, 52);
		frame.getContentPane().add(lblNewLabel_4);
		ImageIcon it1=new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\save.png");
		ImageIcon it2=new ImageIcon(it1.getImage().getScaledInstance(197, 52, JLabel.CENTER));
		lblNewLabel_4.setIcon(it2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(376, 237, 168, 50);
		frame.getContentPane().add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setText(saving+"");
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(-1, 85, 98, 379);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("Cloths  ");
		btnNewButton_1.setBounds(0, 5, 92, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String s=JOptionPane.showInputDialog("Enter Amount");
			int x=Integer.parseInt(s);
			if(AmountRemaining-x<saving)
			{
				JOptionPane.showMessageDialog(frame, "Not allow to more Expense", "Saving", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
			float temp=x/(float)Total;
			temp=temp*100;
			int barvalue=progressBar.getValue()+(int)temp;
			progressBar.setValue(barvalue);
			AmountRemaining=AmountRemaining-x;
			textField.setText(AmountRemaining+"");
			}
		  }
		});
		panel.setLayout(null);
		panel.add(btnNewButton_1);
		
				JButton btnNewButton_2 = new JButton("Travel  ");
				btnNewButton_2.setBounds(0, 33, 92, 23);
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String s=JOptionPane.showInputDialog("Enter Amount");
						int x=Integer.parseInt(s);
						if(AmountRemaining-x<saving)
						{
							JOptionPane.showMessageDialog(frame, "Not allow to more Expense", "Saving", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
						float temp=x/(float)Total;
						temp=temp*100;
						int barvalue=progressBar_1.getValue()+(int)temp;
						progressBar_1.setValue(barvalue);
						AmountRemaining=AmountRemaining-x;
						textField.setText(AmountRemaining+"");
						}
					}
				});
				panel.add(btnNewButton_2);
				
				JButton btnNewButton_3 = new JButton("Food    ");
				btnNewButton_3.setBounds(0, 61, 92, 23);
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s=JOptionPane.showInputDialog("Enter Amount");
						int x=Integer.parseInt(s);
						float temp=x/(float)Total;
						temp=temp*100;
						int barvalue=progressBar_2.getValue()+(int)temp;
						progressBar_2.setValue(barvalue);
						
						AmountRemaining=AmountRemaining-x;
						textField.setText(AmountRemaining+"");
						
					}
				});
				panel.add(btnNewButton_3);
				
				JButton btnNewButton_4 = new JButton("Health ");
				btnNewButton_4.setBounds(0, 89, 92, 23);
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s=JOptionPane.showInputDialog("Enter Amount");
						int x=Integer.parseInt(s);
						if(AmountRemaining-x<saving)
						{
							JOptionPane.showMessageDialog(frame, "Not allow to more Expense", "Saving", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
						float temp=x/(float)Total;
						temp=temp*100;
						int barvalue=progressBar_3.getValue()+(int)temp;
						progressBar_3.setValue(barvalue);
						AmountRemaining=AmountRemaining-x;
						textField.setText(AmountRemaining+"");
						}
					}
				});
				panel.add(btnNewButton_4);
				
				JButton btnNewButton = new JButton("Gifts   ");
				btnNewButton.setBounds(0, 117, 92, 23);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s=JOptionPane.showInputDialog("Enter Amount");
						int x=Integer.parseInt(s);
						if(AmountRemaining-x<saving)
						{
							JOptionPane.showMessageDialog(frame, "Not allow to more Expense", "Saving", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
						float temp=x/(float)Total;
						temp=temp*100;
						int barvalue=progressBar_4.getValue()+(int)temp;
						progressBar_4.setValue(barvalue);
						AmountRemaining=AmountRemaining-x;
						textField.setText(AmountRemaining+"");
						}
					}
				});
				panel.add(btnNewButton);
				
				JButton btnNewButton_5 = new JButton("Phone  ");
				btnNewButton_5.setBounds(0, 145, 92, 23);
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s=JOptionPane.showInputDialog("Enter Amount");
						int x=Integer.parseInt(s);
						if(AmountRemaining-x<saving)
						{
							JOptionPane.showMessageDialog(frame, "Not allow to more Expense", "Saving", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
						float temp=x/(float)Total;
						temp=temp*100;
						int barvalue=progressBar_5.getValue()+(int)temp;
						progressBar_5.setValue(barvalue);
						AmountRemaining=AmountRemaining-x;
						textField.setText(AmountRemaining+"");
						}
					}
				});
				panel.add(btnNewButton_5);
				
				JButton btnNewButton_6 = new JButton("Add Income");
				btnNewButton_6.setBounds(0, 201, 92, 23);
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					//	JOptionPane.showInputDialog();
					String x=JOptionPane.showInputDialog("enter Amount");
					Total=Integer.parseInt(x);
					
					AmountRemaining=Total;
					progressBar.setValue(0); progressBar_1.setValue(0); progressBar_2.setValue(0); progressBar_3.setValue(0); progressBar_4.setValue(0);
					progressBar_5.setValue(0);
					lblNewLabel_2.setText(x);
					textField.setText(AmountRemaining+"");
					}
				});
				panel.add(btnNewButton_6);
				
				JButton btnReset = new JButton("Reset");
				btnReset.setBounds(0, 229, 92, 23);
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AmountRemaining=0;
						Total=0;
						saving=0;
						lblNewLabel_2.setText(Total+"");
						textField.setText(AmountRemaining+"");
						textField_1.setText(saving+"");
						progressBar.setValue(0); progressBar_1.setValue(0); progressBar_2.setValue(0); progressBar_3.setValue(0); progressBar_4.setValue(0);
						progressBar_5.setValue(0); 
					}
				});
				panel.add(btnReset);
				
				JButton btnAddSaving = new JButton("Add Saving");
				btnAddSaving.setBounds(0, 173, 92, 23);
				btnAddSaving.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String s=JOptionPane.showInputDialog("Enter Amount");
						int x=Integer.parseInt(s);
						saving=x;
						textField_1.setText(saving+"");
						
					}
				});
				panel.add(btnAddSaving);
		
		frame.addWindowListener(new WindowAdapter() 
				{
					public void windowClosed(WindowEvent we)
					{
						try {
							Class.forName("com.mysql.jdbc.Driver");
							
						}
						catch(ClassNotFoundException ex)
						{
							
						}
						
						try {
							
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/manage","root","");
							
							
							Statement stmt=conn.createStatement();
						
							String s="update login set total ="+Total+" where username ='"+username+"'";
							stmt.executeUpdate(s);//,remaining ="+AmountRemaining+",cloths ="+progressBar.getValue()+",travel ="+progressBar_1.getValue()+"where username ='"+username+"'");
							s="update login set remaining ="+AmountRemaining+" where username ='"+username+"'";
							stmt.executeUpdate(s);
							s="update login set cloths ="+progressBar.getValue()+" where username ='"+username+"'";
							stmt.executeUpdate(s);
							s="update login set travel ="+progressBar_1.getValue()+" where username ='"+username+"'";
							stmt.executeUpdate(s);
							s="update login set food ="+progressBar_2.getValue()+" where username ='"+username+"'";
							stmt.executeUpdate(s);
							s="update login set health ="+progressBar_3.getValue()+" where username ='"+username+"'";
							stmt.executeUpdate(s);
							s="update login set gifts ="+progressBar_4.getValue()+" where username ='"+username+"'";
							stmt.executeUpdate(s);
							s="update login set phone ="+progressBar_5.getValue()+" where username ='"+username+"'";
							stmt.executeUpdate(s);
							s="update login set saving ="+saving+" where username ='"+username+"'";
							stmt.executeUpdate(s);
							stmt.close();
							conn.close();
						}
						catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					
					}
				});
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

class SignUp extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;

	/**
	 * Create the dialog.
	 */
	private SignUp Pointer=this;
	public SignUp() {
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setTitle("Sign-Up");
	
		
		{
			ImageIcon image=new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\username.png");
			ImageIcon image2=new ImageIcon(image.getImage().getScaledInstance(35, 35, 0));
			JLabel lblUsername = new JLabel("Username:-",image2,JLabel.CENTER);
			lblUsername.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
			lblUsername.setIconTextGap(0);
			
			lblUsername.setBounds(55, 16, 123, 33);
			contentPanel.add(lblUsername);
		}
		{
			ImageIcon image=new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\password.jpg");
			ImageIcon image2=new ImageIcon(image.getImage().getScaledInstance(35, 35, 0));
			JLabel lblNewLabel = new JLabel("Password:-",image2,JLabel.CENTER);
			lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
			lblNewLabel.setBounds(55, 65, 123, 33);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(254, 24, 123, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JPasswordField();
			textField_1.setBounds(254, 73, 123, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JPasswordField();
			textField_2.setBounds(254, 115, 123, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			ImageIcon image=new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\password.jpg");
			ImageIcon image2=new ImageIcon(image.getImage().getScaledInstance(35, 35, 0));
			JLabel lblNewLabel_1 = new JLabel("ReType :-",image2,JLabel.CENTER);
			lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
			lblNewLabel_1.setBounds(55, 109, 123, 33);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnNewButton = new JButton("Create");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				//	System.out.println("Not Not Match");
					String s1=textField.getText();
					String s2=textField_1.getText();
					String s3=textField_2.getText();
						if(s1.length()<8 || s2.length()<8)
						{
							JOptionPane.showMessageDialog(Pointer,"Password and UserName should be greter than 8 character", "Login", JOptionPane.INFORMATION_MESSAGE);
						}
					
						else if(s2.equals(s3) )
						{
							//System.out.println("if me hai");
							try {
								Class.forName("com.mysql.jdbc.Driver");
								
							}
							catch(ClassNotFoundException ex)
							{
								
							}
							try {
							//	System.out.println("query se pahle");
								Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/manage","root","");
							//	System.out.println("hello");
								Statement stmt=conn.createStatement();
								//db.runOtherQuery("insert into users(user,pass) values('"+s1+"','"+s2+"')");
					//			System.out.println("Connection made");
								ResultSet rst=stmt.executeQuery("select * from login where username='"+s1+"'");
								if(rst.next())
								{
									JOptionPane.showMessageDialog(Pointer,"UserName already taken", "Login", JOptionPane.ERROR_MESSAGE);
								}
								else
								{
								stmt.executeUpdate("insert into login(username,password) values('"+s1+"','"+s2+"')");
					//			System.out.println("query ke baad me ");
								JOptionPane.showMessageDialog(Pointer,"Your signup is successfull!! , you may proceed to login", "Login", JOptionPane.INFORMATION_MESSAGE);
								dispose();
								}
								stmt.close();
								conn.close();
							}
							catch(SQLException e1)
							{
								e1.printStackTrace();
							}
							
						}
						else 
						{
							JOptionPane.showMessageDialog(Pointer,"Password Not Match", "Login", JOptionPane.ERROR_MESSAGE);
							//System.out.println("");
						}
					
				}
			});
			btnNewButton.setBounds(55, 175, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Cancel");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton_1.setBounds(256, 175, 89, 23);
			contentPanel.add(btnNewButton_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel();
			
			ImageIcon ii=new ImageIcon("C:\\Users\\himan\\eclipse-workspace\\DatabaseProject\\src\\Images\\\\back.jpg");
			ImageIcon ii2=new ImageIcon(ii.getImage().getScaledInstance(425, 261, JLabel.CENTER));
			lblNewLabel_2.setIcon(ii2);
			
			lblNewLabel_2.setBounds(0, 0, 425, 261);
			contentPanel.add(lblNewLabel_2);
		}
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
