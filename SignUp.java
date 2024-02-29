package Frontend;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.InputVerifier;
//import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import javax.swing.ImageIcon;
import java.awt.Font;



public class SignUp {

    private JFrame frame;
    private JTextField TxtUsername;
    private JTextField TxtPhone;
    private JPasswordField TxtNewPassword;
    private JPasswordField TxtConfirmPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUp window = new SignUp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SignUp() {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBackground(Color.WHITE);
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel confirmPassword = new JPanel();
        confirmPassword.setBackground(Color.RED);
        frame.getContentPane().add(confirmPassword, BorderLayout.CENTER);
        confirmPassword.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(177, 174, 233, 32);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
        confirmPassword.add(lblNewLabel);

        TxtUsername = new JTextField();
        TxtUsername.setBounds(177, 204, 233, 38);
        TxtUsername.setText("Enter your username...");
        confirmPassword.add(TxtUsername);
        TxtUsername.setColumns(10);
        TxtUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TxtUsername.getText().equals("Enter your username...")){
                    TxtUsername.setText("");
                    TxtUsername.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TxtUsername.getText().isEmpty()){
                    TxtUsername.setText("Enter your username...");
                    TxtUsername.setForeground(Color.GRAY);
                }
            }
        });

        TxtUsername.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                if (TxtUsername.getText().length()< 6) {
                    JOptionPane.showMessageDialog(frame,"Error : Username must be atleast of 6 character","Alert",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        });

        JLabel Password = new JLabel("Phone or Email");
        Password.setBounds(177, 254, 233, 32);
        Password.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
        confirmPassword.add(Password);

        TxtPhone = new JTextField();
        TxtPhone.setBounds(177, 282, 233, 38);
        TxtPhone.setText("Enter your Email or Phone");
        TxtPhone.setColumns(10);
        confirmPassword.add(TxtPhone);
        TxtPhone.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                if(TxtPhone.getText().length() >= 10 || TxtPhone.getText().matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                    return true;
                }
                JOptionPane.showMessageDialog(frame,"Invalid number or email");
                return false;
            }
        });


        TxtPhone.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(TxtPhone.getText().equals("Enter your Email or Phone")){
                    TxtPhone.setText("");
                    TxtPhone.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(TxtPhone.getText().isEmpty()){
                    TxtPhone.setText("Enter your Email or Phone");
                    TxtPhone.setForeground(Color.GRAY);
                }
            }
        });


        JLabel lblNewPassword = new JLabel("New Password ");
        lblNewPassword.setBounds(177, 338, 233, 32);
        lblNewPassword.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
        confirmPassword.add(lblNewPassword);


        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setBounds(177, 417, 233, 32);
        lblConfirmPassword.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
        confirmPassword.add(lblConfirmPassword);


        JComboBox ComboCourse = new JComboBox();
        ComboCourse.setBounds(177, 528, 233, 27);
        ComboCourse.setModel(new DefaultComboBoxModel(new String[] {"Select your course", "B.IT", "Business", "Marketing"}));
        confirmPassword.add(ComboCourse);

        JComboBox ComboUserMode = new JComboBox();
        ComboUserMode.setBounds(177, 489, 233, 38);
        ComboUserMode.setModel(new DefaultComboBoxModel(new String[] {"Select user mode", "Admin", "Student", "Instructor"}));
        confirmPassword.add(ComboUserMode);
        
        TxtNewPassword = new JPasswordField();
        TxtNewPassword.setBounds(177, 370, 223, 38);
        confirmPassword.add(TxtNewPassword);
        
        TxtConfirmPassword = new JPasswordField();
        TxtConfirmPassword.setBounds(177, 450, 233, 38);
        confirmPassword.add(TxtConfirmPassword);
        
        JLabel lblNewLabel_2_1_1_2 = new JLabel("");
        lblNewLabel_2_1_1_2.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/password.png"));
        lblNewLabel_2_1_1_2.setBounds(122, 353, 43, 45);
        confirmPassword.add(lblNewLabel_2_1_1_2);
        
        JPanel panel = new JPanel();
        panel.setBounds(18, 17, 545, 656);
        panel.setBackground(Color.GRAY);
        confirmPassword.add(panel);
        panel.setLayout(null);
        
        
        JButton btnNewButton = new JButton("Sign UP");
        btnNewButton.setBounds(390, 548, 91, 55);
        btnNewButton.setBackground(new Color(204, 102, 255));
        panel.add(btnNewButton);
        
                JButton btnNewButton_1 = new JButton("Login");
                btnNewButton_1.setBounds(51, 548, 117, 55);
                btnNewButton_1.setBackground(new Color(255, 0, 255));
                panel.add(btnNewButton_1);
                
                JLabel lblNewLabel_2 = new JLabel(" SignUp Panel!!");
                lblNewLabel_2.setBounds(17, 35, 216, 72);
                lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
                panel.add(lblNewLabel_2);
                
                JLabel lblNewLabel_2_1_1_1 = new JLabel("");
                lblNewLabel_2_1_1_1.setBounds(98, 172, 48, 52);
                panel.add(lblNewLabel_2_1_1_1);
                lblNewLabel_2_1_1_1.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/username.png"));
                
                JLabel lblNewLabel_2_1_1 = new JLabel("");
                lblNewLabel_2_1_1.setBounds(98, 261, 48, 43);
                panel.add(lblNewLabel_2_1_1);
                lblNewLabel_2_1_1.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/phone.png"));
                
                JLabel lblNewLabel_2_1_1_2_1 = new JLabel("");
                lblNewLabel_2_1_1_2_1.setBounds(98, 417, 48, 52);
                panel.add(lblNewLabel_2_1_1_2_1);
                lblNewLabel_2_1_1_2_1.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/password.png"));
                
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/signup.png"));
                lblNewLabel_1.setForeground(new Color(255, 153, 255));
                lblNewLabel_1.setBounds(316, 20, 136, 124);
                panel.add(lblNewLabel_1);
                btnNewButton_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
				login lo=new login();
				frame.setVisible(false);
				lo.setVisible(true);
                    }
                });
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int x = 0;
            	String Username = TxtUsername.getText();
            	String PhoneOrEmail = TxtPhone.getText();
            	char[] newPassword = TxtNewPassword.getPassword();
            	char[] confirmPassword = TxtConfirmPassword.getPassword();
            	String s5 = new String(newPassword);
            	String s6 = new String(confirmPassword);
            	String Usermode = (String)ComboUserMode.getSelectedItem();
            	String Course = (String)ComboCourse.getSelectedItem();
            	if(s5.equals(s6)){
            		if(Usermode.equals("Admin")) {
            			try {
                			
                			Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
                            PreparedStatement ps = con.prepareStatement("insert into Admin values(default,?,?,?)");  
                            ps.setString(1, Username);  
                            ps.setString(2, PhoneOrEmail);
                            ps.setString(3, s5);
                            ps.executeUpdate();  
                            x++;
                            
                            
                            if(x>0) {
                            	JOptionPane.showMessageDialog(btnNewButton, "Sucessfully signed ");
                            }else {
                        		JOptionPane.showMessageDialog(btnNewButton, "Password does not match");
                        		
                			}
                	
                			
                		}
                		catch(Exception ex){
                			System.out.println(ex);
                			
                		}
            		}
            		
            		if(Usermode.equals("Student")) {
            		
            			try {
            			
            			Class.forName("com.mysql.cj.jdbc.Driver");  
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
                        PreparedStatement ps = con.prepareStatement("insert into Student values(default,?,?,?,?)");
                        ps.setString(1, Username);  
                        ps.setString(2, PhoneOrEmail);  
                        ps.setString(3, Course);
                        ps.setString(4, s5);
            
                        ps.executeUpdate();  
                        x++;
                        
                        if(x>0) {
                        	JOptionPane.showMessageDialog(btnNewButton, "Sucessfully Signed In");
                        }else {
            		JOptionPane.showMessageDialog(btnNewButton, "Password does not match");
            		
            			}
            	
            			
            			}
            			catch(Exception ex){
            			System.out.println(ex);
            			
            				}
            		
            		
            		}
            		
            		if(Usermode.equals("Instructor")) {
            			try {
                			
                			Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
//                            PreparedStatement dataInsert = con.prepareStatement("create table Details(Username varchar(50) NOT NULL, Email varchar(100) NOT NULL, Password varchar(100) NOT NULL)");
                            PreparedStatement ps = con.prepareStatement("insert into Instructor values(default,?,?,?)");  
//                            ps.setInt(1,1); 
                            ps.setString(1, Username);  
                            ps.setString(2, PhoneOrEmail);
                            ps.setString(3, s5);
                            ps.executeUpdate();  
                            x++;
                            
                            if(x>0) {
                            	JOptionPane.showMessageDialog(btnNewButton, "Sucessfully Signed In");
                            }else {
                        		JOptionPane.showMessageDialog(btnNewButton, "Password does not match");
                        		
                			}
                	
                			
                			}
                			catch(Exception ex){
                			System.out.println(ex);
                			
                		}
            		}
            		
            		
//            	else {
//            		JOptionPane.showMessageDialog(btnNewButton, "Password does not match");
//            		
//            			}
//            	
            		}
            	
            }
            
        });


        
        


        frame.setBounds(100, 100, 585, 719);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
	}
}
