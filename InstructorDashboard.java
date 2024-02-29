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
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Window;
import javax.swing.ImageIcon;
public class InstructorDashboard {

	protected static final Window frameToClose = null;
	private JFrame frmInstructorDashboard;
	private JSplitPane mainSplitPane;
	private JButton btnNewButton_2;
	private CardLayout cl_cardPanel = new CardLayout(0, 0);
	private JPanel cardPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new InstructorDashboard();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InstructorDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInstructorDashboard = new JFrame();
		frmInstructorDashboard.setVisible(true);
		frmInstructorDashboard.setForeground(new Color(0, 255, 0));
		frmInstructorDashboard.setFont(new Font("Dialog", Font.BOLD, 20));
		frmInstructorDashboard.setBackground(Color.LIGHT_GRAY);
		frmInstructorDashboard.setTitle("Herald College Kathmandu    &    The University Partner ~  University of Wolverhampton\n");
		frmInstructorDashboard.setBounds(100, 100, 1280, 852);
		mainSplitPane = new JSplitPane();
		mainSplitPane.setDividerSize(0);
		frmInstructorDashboard.setContentPane(mainSplitPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 255, 204));
		mainSplitPane.setLeftComponent(panel_1);

		btnNewButton_2 = new JButton("Instructor");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 19));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_6885489673700");
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/src/Images/instructor.png")));
		
		JLabel lblNewLabel_6 = new JLabel(" \"Embrace the unknown");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JLabel lblNewLabel_6_1 = new JLabel(" for it is the gateway");
		lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JLabel lblNewLabel_6_2 = new JLabel("to growth and opportunity.\"");
		lblNewLabel_6_2.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lg = new login();
				lg.setVisible(true);
				lg.dispose();
			}
		});
		btnLogOut.setFont(new Font("Lucida Grande", Font.ITALIC, 17));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6_2, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(55)
					.addComponent(btnLogOut)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(66)
					.addComponent(lblNewLabel)
					.addGap(64)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_6_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(249, Short.MAX_VALUE))
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
		
		JPanel InstructorPanel = new JPanel();
		InstructorPanel.setBackground(new Color(204, 204, 255));
		cardPanel.add(InstructorPanel, "name_6885489673700");
		InstructorPanel.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("Instructor View");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(366, 44, 226, 82);
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnNewButton_6.setForeground(new Color(0, 0, 255));
		btnNewButton_6.setBackground(new Color(0, 255, 0));
		
		InstructorPanel.add(btnNewButton_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(112, 179, 807, 416);
		panel_2.setBackground(new Color(238, 232, 170));
		InstructorPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(117, 141, 64, 64);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/Studengts.png"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(365, 147, 64, 64);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(InstructorDashboard.class.getResource("/src/Images/assignment.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(622, 157, 50, 50);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/icons8-add-properties-50.png"));
		
		
		JButton btnStudents = new JButton("Students List");
		btnStudents.setFont(new Font("Lucida Grande", Font.ITALIC, 17));
		btnStudents.setBounds(68, 242, 161, 58);
		btnStudents.setBackground(new Color(0, 0, 255));
		panel_2.add(btnStudents);
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudentsList ss = new ViewStudentsList();
				frmInstructorDashboard.setVisible(false);
				ss.setVisible(true);
			}
		});
		
		JButton btnStudents_1 = new JButton("Add Assignments");
		btnStudents_1.setFont(new Font("Lucida Grande", Font.ITALIC, 17));
		btnStudents_1.setBounds(323, 242, 161, 64);
		panel_2.add(btnStudents_1);
		btnStudents_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAssignment aa = new AddAssignment();
				frmInstructorDashboard.setVisible(false);
				aa.setVisible(true);
			}
		});
		
		JButton btnStudents_2 = new JButton("Add Marks");
		btnStudents_2.setFont(new Font("Lucida Grande", Font.ITALIC, 17));
		btnStudents_2.setBounds(587, 236, 133, 64);
		panel_2.add(btnStudents_2);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBackground(new Color(204, 255, 153));
		btnNewButton_1.setBounds(446, 706, 69, 34);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInstructorDashboard.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnNewButton_1.setForeground(new Color(0, 51, 255));
		InstructorPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/teach.png"));
		lblNewLabel_4.setBounds(280, 48, 74, 82);
		InstructorPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/exit.png"));
		lblNewLabel_5.setBounds(446, 680, 93, 73);
		InstructorPanel.add(lblNewLabel_5);
		btnStudents_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMarks aa = new AddMarks();
				frmInstructorDashboard.setVisible(false);
				aa.setVisible(true);
			}
		});
		

		frmInstructorDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		
	}
}
