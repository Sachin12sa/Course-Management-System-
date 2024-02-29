package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.ImageIcon;

public class StudentDashboard {

	private JFrame frmStudentDashboard;
	private JSplitPane mainSplitPane;
	private JButton btnNewButton;
	private CardLayout cl_cardPanel = new CardLayout(0, 0);
	private JPanel cardPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard window = new StudentDashboard();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentDashboard = new JFrame();
		frmStudentDashboard.setVisible(true);
		frmStudentDashboard.setForeground(new Color(0, 255, 0));
		frmStudentDashboard.setFont(new Font("Dialog", Font.BOLD, 20));
		frmStudentDashboard.setBackground(Color.LIGHT_GRAY);
		frmStudentDashboard.setTitle("Herald College Kathmandu    &    The University Partner ~  University of Wolverhampton\n");
		frmStudentDashboard.setBounds(100, 100, 1198, 718);
		mainSplitPane = new JSplitPane();
		mainSplitPane.setDividerSize(0);
		frmStudentDashboard.setContentPane(mainSplitPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 255, 255));
		mainSplitPane.setLeftComponent(panel_1);

		btnNewButton = new JButton("Student");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel,"name_6865940377300");
			
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/std.png"));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(new Color(204, 0, 0));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lg = new login();
				lg.setVisible(true);
				lg.dispose();
				
			}
		});
		btnLogOut.setFont(new Font("Lucida Grande", Font.ITALIC, 17));
		
		JLabel lblNewLabel_6 = new JLabel(" \"Embrace the unknown");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JLabel lblNewLabel_6_1 = new JLabel(" for it is the gateway");
		lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JLabel lblNewLabel_6_2 = new JLabel("to growth and opportunity.\"");
		lblNewLabel_6_2.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/logout.png"));
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
									.addGap(17)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(102)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_6_2, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(115)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_6_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(88)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainSplitPane.setRightComponent(splitPane);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		cardPanel = new JPanel();
		splitPane.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);
		
		JPanel StudentPanel = new JPanel();
		StudentPanel.setBackground(new Color(102, 204, 153));
		cardPanel.add(StudentPanel, "name_6865940377300");
		StudentPanel.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Student View");
		btnNewButton_4.setBounds(337, 26, 302, 73);
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		StudentPanel.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 255));
		panel_2.setBounds(109, 164, 774, 430);
		StudentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_3_11 = new JButton("Check Assignment");
		btnNewButton_3_11.setForeground(new Color(0, 0, 0));
		btnNewButton_3_11.setBounds(471, 138, 179, 50);
		panel_2.add(btnNewButton_3_11);
		btnNewButton_3_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAssignment VA=new ViewAssignment();
				VA.setVisible(true);
			}
		});
		btnNewButton_3_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(526, 62, 64, 64);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/assignment.png"));
		
		
		JButton btnNewButton_3_11_1 = new JButton("Modules");
		btnNewButton_3_11_1.setForeground(new Color(0, 0, 0));
		btnNewButton_3_11_1.setBounds(127, 138, 179, 50);
		panel_2.add(btnNewButton_3_11_1);
		btnNewButton_3_11_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewModule vm=new ViewModule();
				frmStudentDashboard.setVisible(false);
				vm.setVisible(true);
			}
		});
		btnNewButton_3_11_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(181, 76, 62, 50);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/module.png"));
		
		
		JButton btnNewButton_3_11_1_1 = new JButton("View Result");
		btnNewButton_3_11_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_3_11_1_1.setBounds(137, 306, 181, 50);
		panel_2.add(btnNewButton_3_11_1_1);
		btnNewButton_3_11_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewReport vr = new ViewReport();
				frmStudentDashboard.setVisible(false);
				vr.setVisible(true);
			}
		});
		btnNewButton_3_11_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(194, 220, 72, 74);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/icons8-add-properties-50.png"));
		
		JButton btnNewButton_3_11_1_1_1 = new JButton("Class Schedule\n");
		btnNewButton_3_11_1_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_3_11_1_1_1.setBounds(471, 306, 179, 50);
		panel_2.add(btnNewButton_3_11_1_1_1);
		btnNewButton_3_11_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassSchedule CS = new ClassSchedule();
				frmStudentDashboard.setVisible(false);
				CS.setVisible(true);
			}
		});
		btnNewButton_3_11_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(540, 247, 50, 50);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/class.png"));
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.setBounds(442, 607, 117, 50);
		StudentPanel.add(btnNewButton_2);

		frmStudentDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
