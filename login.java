package Frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class login {

    private JFrame frame;
    private JTextField Username;
    private JPasswordField password;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
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
    public login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBackground(Color.WHITE);
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("Button.select"));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(119, 151, 50, 50);
        lblNewLabel.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/login.png"));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblNewLabel);

        Username = new JTextField();
        Username.setBounds(186, 151, 280, 41);
        Username.setText("Enter your Username...");
        Username.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(Username);
        Username.setColumns(10);
        Username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Username.getText().equals("Enter your Username...")) {
                    Username.setText("");
                    Username.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Username.getText().isEmpty()) {
                    Username.setText("Enter your Username...");
                    Username.setForeground(Color.GRAY);
                }
            }
        });

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(119, 228, 50, 50);
        lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/src/Images/password.png")));
        panel.add(lblNewLabel_1);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
        comboBox.setBounds(186, 290, 280, 41);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Your action handling code here
            }
        });
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Select User Mode ", "Admin", "Instructor", "Student" }));
        panel.add(comboBox);

        password = new JPasswordField();
        password.setBounds(186, 237, 280, 41);
        panel.add(password);

        JLabel lblNewLabel_2_1_1_2 = new JLabel("");
        lblNewLabel_2_1_1_2.setBounds(147, 140, 27, 52);
        panel.add(lblNewLabel_2_1_1_2);

        JLabel lblNewLabel_2_1_1_2_1 = new JLabel("");
        lblNewLabel_2_1_1_2_1.setBounds(147, 221, 27, 52);
        panel.add(lblNewLabel_2_1_1_2_1);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(254, 16, 0, 0);
        panel.add(lblNewLabel_3);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(112, 128, 144));
        panel_1.setBounds(16, 16, 593, 554);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JButton btnCreateANew = new JButton("Create a new account");
        btnCreateANew.setBounds(170, 459, 280, 47);
        panel_1.add(btnCreateANew);
        btnCreateANew.setForeground(Color.BLACK);
        btnCreateANew.setBackground(new Color(0, 0, 255));

        JLabel lblNewLabel_2 = new JLabel("OR");
        lblNewLabel_2.setBounds(258, 412, 61, 22);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnNewButton = new JButton("LogIn");
        btnNewButton.setBounds(212, 337, 142, 47);
        panel_1.add(btnNewButton);
        btnNewButton.setBackground(new Color(255, 102, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = Username.getText();
                char[] pass = password.getPassword();
                String pa = new String(pass);
                String usermode = (String) comboBox.getSelectedItem();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
                    java.sql.Statement state = con.createStatement();
                    if (usermode.equals("Admin")) {
                        String query = ("SELECT * FROM Admin");
                        ResultSet rs = state.executeQuery(query);
                        int x = 0;
                        while (rs.next()) {
                            String user = rs.getString("Username");
                            String pword = rs.getString("Password");
                            if (user.equalsIgnoreCase(username) && pword.equals(pa)) {
                                JOptionPane.showMessageDialog(btnNewButton , "Welcome" + " " + user);
                                MainDashboard dashboard = new MainDashboard();
                                frame.setVisible(false);
                                dashboard.setVisible(true);
                                x++;
                                break;
                            }
                        }
                        if (x == 0) {
                            JOptionPane.showMessageDialog(btnNewButton, "Error!!! Wrong Username or Password!");
                        }
                    }

                    if (usermode.equals("Student")) {
                        String query = ("Select * from Student");
                        ResultSet rs = state.executeQuery(query);
                        int x = 0;
                        while (rs.next()) {
                            String user = rs.getString("Username");
                            String password = rs.getString("Password");
                            if (user.equalsIgnoreCase(username) && password.equals(pa)) {
                                JOptionPane.showMessageDialog(btnNewButton, "Welcome" + " " + user);
                                frame.setVisible(false);
                                StudentDashboard studentDashboard = new StudentDashboard();
                                studentDashboard.setVisible(true);
                                x++;
                                break;
                            }
                        }
                        if (x == 0) {
                            JOptionPane.showMessageDialog(btnNewButton, "Error!!! Wrong Username or Password!");
                        }
                    }

                    if (usermode.equals("Instructor")) {
                        String query = ("Select * from Instructor");
                        ResultSet rs = state.executeQuery(query);
                        int x = 0;
                        while (rs.next()) {
                            String user = rs.getString("Username");
                            String password = rs.getString("Password");
                            if (user.equalsIgnoreCase(username) && password.equals(pa)) {
                                JOptionPane.showMessageDialog(btnNewButton, "Welcome" + " " + user);
                                frame.setVisible(false);
                                InstructorDashboard tutorDashboard = new InstructorDashboard();
                                tutorDashboard.setVisible(true);
                                x++;
                                break;
                            }
                        }
                        if (x == 0) {
                            JOptionPane.showMessageDialog(btnNewButton, "Error!!! Wrong Username or Password!");
                        }
                    }

                } catch (Exception ex) {
                    System.out.println(e);
                }

            }
        });
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(100, 149, 237));

        JLabel lblNewLabel_5 = new JLabel("Welcome to HCK Login Page!!");
        lblNewLabel_5.setBounds(90, 47, 400, 31);
        panel_1.add(lblNewLabel_5);
        lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setBounds(465, 6, 103, 90);
        panel_1.add(lblNewLabel_4);
        lblNewLabel_4.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/degree.png"));
        btnCreateANew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp signUp = new SignUp();
                frame.setVisible(false);
                signUp.setVisible(true);
            }
        });

        frame.setBounds(100, 100, 629, 616);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b) {
        frame.setVisible(true);
    }

    public void dispose() {
    }
}

