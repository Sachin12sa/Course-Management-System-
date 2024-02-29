package Frontend;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class MainDashboard {

	private JFrame frmDashboard;
	private JTextField textField;
	private JTextField tf_ts;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDashboard window = new MainDashboard();
					window.frmDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDashboard = new JFrame();
		frmDashboard.setTitle("Herald College Kathmandu & The University Partner ~ University of Wolverhampton");
		frmDashboard.getContentPane().setBackground(Color.WHITE);
		frmDashboard.setBackground(new Color(255, 0, 51));
		frmDashboard.setBounds(100, 100, 1280, 814);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboard.getContentPane().setLayout(null);
		frmDashboard.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 153));
		panel.setBounds(0, 0, 223, 780);
		frmDashboard.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				layeredPane.removeAll()
			}
		});
		btnNewButton.setBounds(28, 127, 142, 55);
		panel.add(btnNewButton);
		
		JButton adminPanel = new JButton("Course Admin");
		adminPanel.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		adminPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard ad = new AdminDashboard();
				frmDashboard.setVisible(false);
				ad.setVisible(true);
			}
		});
		adminPanel.setBounds(30, 248, 140, 55);
		panel.add(adminPanel);
		
		JButton btnTutor = new JButton("Instructor");
		btnTutor.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		btnTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructorDashboard idd = new InstructorDashboard();
				frmDashboard.setVisible(false);
				idd.setVisible(true);
			}
		});
		
		btnTutor.setBounds(25, 384, 145, 65);
		panel.add(btnTutor);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		btnStudents.setBounds(25, 528, 145, 65);
		panel.add(btnStudents);
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDashboard sdd = new StudentDashboard();
				frmDashboard.setVisible(false);
				sdd.setVisible(true);
			}
		});
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Lucida Grande", Font.ITALIC, 17));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lg = new login();
				lg.setVisible(true);
			}
		});
		btnLogOut.setBounds(30, 664, 155, 55);
		panel.add(btnLogOut);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/dashboard.png"));
		lblNewLabel_3.setBounds(55, 37, 81, 78);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/course.png"));
		lblNewLabel_4.setBounds(68, 197, 68, 50);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel(" ");
		lblNewLabel_4_1.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/instructor.png"));
		lblNewLabel_4_1.setBounds(55, 325, 74, 55);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel(" ");
		lblNewLabel_4_2.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/std.png"));
		lblNewLabel_4_2.setBounds(55, 461, 81, 65);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel(" ");
		lblNewLabel_4_3.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/logout.png"));
		lblNewLabel_4_3.setBounds(68, 616, 68, 51);
		panel.add(lblNewLabel_4_3);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(168, 6, -12, 669);
		frmDashboard.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel DashboardPanel = new JPanel();
		DashboardPanel.setBackground(new Color(0, 204, 255));
		DashboardPanel.setBounds(218, 0, 1056, 780);
		frmDashboard.getContentPane().add(DashboardPanel);
		DashboardPanel.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(102, 204, 153));
		panel_7.setBounds(869, 0, 181, 788);
		DashboardPanel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Notifications");
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(6, 6, 169, 34);
		panel_7.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("TO DO LIST");
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_6_1_1_1.setBounds(16, 287, 159, 47);
		panel_7.add(lblNewLabel_6_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1.setBackground(SystemColor.windowBorder);
		panel_1.setBounds(16, 52, 159, 53);
		panel_7.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("New Student Registered...");
		lblNewLabel_3_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2.setBounds(6, 21, 150, 15);
		panel_1.add(lblNewLabel_3_2_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_3.setBackground(SystemColor.windowBorder);
		panel_1_3.setBounds(16, 117, 159, 53);
		panel_7.add(panel_1_3);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("New Student Registered...");
		lblNewLabel_3_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_1.setBounds(6, 19, 150, 15);
		panel_1_3.add(lblNewLabel_3_2_2_1);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4.setBackground(SystemColor.windowBorder);
		panel_1_4.setBounds(16, 186, 159, 53);
		panel_7.add(panel_1_4);
		
		JLabel lblNewLabel_3_2_2_2 = new JLabel("New Student Registered...");
		lblNewLabel_3_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_2.setBounds(6, 19, 150, 15);
		panel_1_4.add(lblNewLabel_3_2_2_2);
		
		JPanel panel_1_4_1 = new JPanel();
		panel_1_4_1.setName("");
		panel_1_4_1.setLayout(null);
		panel_1_4_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_1.setBackground(SystemColor.windowBorder);
		panel_1_4_1.setBounds(16, 346, 159, 53);
		panel_7.add(panel_1_4_1);
		
		JLabel lblNewLabel_3_2_2_3 = new JLabel("Assignement Week-2");
		lblNewLabel_3_2_2_3.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_3.setBounds(6, 18, 150, 15);
		panel_1_4_1.add(lblNewLabel_3_2_2_3);
		
		JPanel panel_1_4_2 = new JPanel();
		panel_1_4_2.setLayout(null);
		panel_1_4_2.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_2.setBackground(SystemColor.windowBorder);
		panel_1_4_2.setBounds(16, 428, 159, 53);
		panel_7.add(panel_1_4_2);
		
		JLabel lblNewLabel_3_2_2_3_1 = new JLabel("Assignement Week-8\n");
		lblNewLabel_3_2_2_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_3_1.setBounds(6, 20, 150, 15);
		panel_1_4_2.add(lblNewLabel_3_2_2_3_1);
		
		JPanel panel_1_4_3 = new JPanel();
		panel_1_4_3.setLayout(null);
		panel_1_4_3.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_3.setBackground(SystemColor.windowBorder);
		panel_1_4_3.setBounds(16, 504, 159, 53);
		panel_7.add(panel_1_4_3);
		
		JLabel lblNewLabel_3_2_2_3_2 = new JLabel("Assignement Week-10\n");
		lblNewLabel_3_2_2_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2_2_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblNewLabel_3_2_2_3_2.setBounds(6, 19, 150, 15);
		panel_1_4_3.add(lblNewLabel_3_2_2_3_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(106, 90, 205));
		panel_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_2.setBounds(367, 89, 225, 187);
		DashboardPanel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setText("3");
		textField_11.setColumns(10);
		textField_11.setBounds(30, 79, 164, 78);
		panel_1_2.add(textField_11);
		
		JLabel lblNewLabel_2_2 = new JLabel("Total Courses");
		lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
		lblNewLabel_2_2.setBounds(61, 25, 133, 28);
		panel_1_2.add(lblNewLabel_2_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(106, 90, 205));
		panel_1_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaptionBorder, null, null));
		panel_1_1_1.setBounds(647, 358, 218, 187);
		DashboardPanel.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Students");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(39, 6, 143, 46);
		panel_1_1_1.add(lblNewLabel_2);
		
		tf_ts = new JTextField();
		tf_ts.setHorizontalAlignment(SwingConstants.CENTER);
		tf_ts.setText("7");
		tf_ts.setBounds(23, 64, 159, 74);
		panel_1_1_1.add(tf_ts);
		tf_ts.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(106, 90, 205));
		panel_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.activeCaption, SystemColor.activeCaptionBorder, null, null));
		panel_1_1.setBounds(95, 340, 218, 205);
		DashboardPanel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setText("5");
		textField_10.setColumns(10);
		textField_10.setBounds(39, 79, 145, 74);
		panel_1_1.add(textField_10);
		
		JLabel tf_tt = new JLabel("Total Teachers");
		tf_tt.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
		tf_tt.setBounds(39, 27, 145, 20);
		panel_1_1.add(tf_tt);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 204, 153));
		panel_3.setBounds(-23, 6, 896, 64);
		DashboardPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Dashboard");
		lblNewLabel.setBounds(365, 6, 192, 52);
		panel_3.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 28));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		JPanel CoursePanel = new JPanel();
		CoursePanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Courses");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(6, 6, 150, 39);
		CoursePanel.add(lblNewLabel_1);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBackground(SystemColor.windowBorder);
		panel_7_1.setBounds(619, 6, 181, 657);
		CoursePanel.add(panel_7_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Notifications");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_5_1.setBounds(6, 6, 169, 34);
		panel_7_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1_1_1_1 = new JLabel("TO DO LIST");
		lblNewLabel_6_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_6_1_1_1_1.setBounds(16, 287, 159, 47);
		panel_7_1.add(lblNewLabel_6_1_1_1_1);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_5.setBackground(SystemColor.windowBorder);
		panel_1_5.setBounds(16, 52, 159, 53);
		panel_7_1.add(panel_1_5);
		
		JPanel panel_1_3_1 = new JPanel();
		panel_1_3_1.setLayout(null);
		panel_1_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_3_1.setBackground(SystemColor.windowBorder);
		panel_1_3_1.setBounds(16, 117, 159, 53);
		panel_7_1.add(panel_1_3_1);
		
		JPanel panel_1_4_4 = new JPanel();
		panel_1_4_4.setLayout(null);
		panel_1_4_4.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_4.setBackground(SystemColor.windowBorder);
		panel_1_4_4.setBounds(16, 186, 159, 53);
		panel_7_1.add(panel_1_4_4);
		
		JPanel panel_1_4_1_1 = new JPanel();
		panel_1_4_1_1.setLayout(null);
		panel_1_4_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_1_1.setBackground(SystemColor.windowBorder);
		panel_1_4_1_1.setBounds(16, 346, 159, 53);
		panel_7_1.add(panel_1_4_1_1);
		
		JPanel panel_1_4_2_1 = new JPanel();
		panel_1_4_2_1.setLayout(null);
		panel_1_4_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_2_1.setBackground(SystemColor.windowBorder);
		panel_1_4_2_1.setBounds(16, 428, 159, 53);
		panel_7_1.add(panel_1_4_2_1);
		
		JPanel panel_1_4_3_1 = new JPanel();
		panel_1_4_3_1.setLayout(null);
		panel_1_4_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.activeCaption, SystemColor.activeCaption, null, null));
		panel_1_4_3_1.setBackground(SystemColor.windowBorder);
		panel_1_4_3_1.setBounds(16, 504, 159, 53);
		panel_7_1.add(panel_1_4_3_1);
		
		textField = new JTextField();
		textField.setBounds(6, 43, 241, 42);
		CoursePanel.add(textField);
		textField.setColumns(10);
		
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	}