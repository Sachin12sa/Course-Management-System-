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
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.ImageIcon;


public class AdminDashboard {

	private JFrame frmAdminDashboard;
	private JSplitPane mainSplitPane;
	private JButton btnNewButton_1;
	private CardLayout cl_cardPanel = new CardLayout(0, 0);
	private JPanel cardPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public AdminDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminDashboard = new JFrame();
		frmAdminDashboard.setVisible(true);
		frmAdminDashboard.setForeground(new Color(0, 255, 0));
		frmAdminDashboard.setFont(new Font("Dialog", Font.BOLD, 20));
		frmAdminDashboard.setBackground(Color.LIGHT_GRAY);
		frmAdminDashboard.setTitle("Herald College Kathmandu    &    The University Partner ~  University of Wolverhampton\n");
		frmAdminDashboard.setBounds(100, 100, 1280, 814);
		mainSplitPane = new JSplitPane();
		mainSplitPane.setDividerSize(0);
		frmAdminDashboard.setContentPane(mainSplitPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 255, 255));
		mainSplitPane.setLeftComponent(panel_1);

		btnNewButton_1 = new JButton("Course Admin");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cardPanel.show(cardPanel, "name_6884456073600");
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/admin.png"));
		
		JButton btnNewButton_4 = new JButton("Return to Dashboard");
		btnNewButton_4.setBackground(new Color(102, 204, 153));
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 19));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainDashboard mdd = new MainDashboard();
				frmAdminDashboard.setVisible(false);
				mdd.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel(" \"Embrace the unknown");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JLabel lblNewLabel_6_1 = new JLabel(" for it is the gateway");
		lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		JLabel lblNewLabel_6_2 = new JLabel("to growth and opportunity.\"");
		lblNewLabel_6_2.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(71))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(48)
					.addComponent(btnNewButton_4)
					.addContainerGap(70, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(140, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(126))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6_2, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(62)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addGap(32))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addComponent(lblNewLabel)
					.addGap(64)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_6_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(153, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainSplitPane.setRightComponent(splitPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		splitPane.setLeftComponent(panel);
		
		cardPanel = new JPanel();
		splitPane.setRightComponent(cardPanel);
		cardPanel.setLayout(cl_cardPanel);
		
		
		JPanel CourseAdminPanel = new JPanel();
		CourseAdminPanel.setForeground(new Color(255, 204, 51));
		CourseAdminPanel.setBackground(new Color(102, 204, 153));
		cardPanel.add(CourseAdminPanel, "name_6884456073600");
		
		JButton btnNewButton_5 = new JButton("Course-Admin View");
		btnNewButton_5.setBounds(337, 44, 303, 45);
		btnNewButton_5.setForeground(new Color(0, 0, 255));
		btnNewButton_5.setBackground(new Color(0, 255, 0));
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CourseAdminPanel.setLayout(null);
		CourseAdminPanel.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Courses");
		btnNewButton_3.setBounds(124, 291, 164, 39);
		btnNewButton_3.setForeground(new Color(204, 0, 0));
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBackground(Color.BLUE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course c =new Course();
				frmAdminDashboard.setVisible(false);
				c.setVisible(true);
			}
		});
		CourseAdminPanel.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("Set Exam");
		btnNewButton_7.setForeground(new Color(204, 0, 0));
		btnNewButton_7.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_7.setBounds(450, 390, 92, 57);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetExam SE=new SetExam();
				frmAdminDashboard.setVisible(false);
				SE.setVisible(true);
			}
		});
		CourseAdminPanel.add(btnNewButton_7);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(177, 169, 92, 73);
		lblNewLabel_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/src/Images/icons8-knowledge-sharing-50.png")));
		CourseAdminPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(745, 198, 84, 50);
		lblNewLabel_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/src/Images/icons8-add-properties-50.png")));
		CourseAdminPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(738, 381, 70, 66);
		lblNewLabel_4.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/Studengts.png"));
		CourseAdminPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(193, 396, 100, 100);
		lblNewLabel_3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/src/Images/instructor.png")));
		CourseAdminPanel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.setBounds(452, 642, 140, 50);
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(106, 90, 205));
		CourseAdminPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(458, 290, 64, 64);
		lblNewLabel_5.setIcon(new ImageIcon(AdminDashboard.class.getResource("/src/Images/icons8-exam-64.png")));
		CourseAdminPanel.add(lblNewLabel_5);
     
		
		JButton btnNewButton_9 = new JButton("Publish Result");
		btnNewButton_9.setForeground(new Color(204, 0, 0));
		btnNewButton_9.setBounds(682, 254, 187, 23);
		btnNewButton_9.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		CourseAdminPanel.add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				publishResult pr = new publishResult();
				frmAdminDashboard.setVisible(false);
				pr.setVisible(true);
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("View Students List");
		btnNewButton_2.setForeground(new Color(204, 0, 0));
		btnNewButton_2.setBounds(671, 502, 198, 50);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		CourseAdminPanel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentsList SL = new StudentsList();
				frmAdminDashboard.setVisible(false);
				SL.setVisible(true);
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("View Teachers List");
		btnNewButton_2_1.setForeground(new Color(204, 0, 0));
		btnNewButton_2_1.setBounds(162, 502, 188, 50);
		btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		CourseAdminPanel.add(btnNewButton_2_1);
		
		JButton btnNewButton_6 = new JButton("hello");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello World");
			}
		});
		btnNewButton_6.setBounds(309, 198, 117, 29);
		CourseAdminPanel.add(btnNewButton_6);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersList tl = new TeachersList();
				frmAdminDashboard.setVisible(false);
				tl.setVisible(true);
			}
		});
		
		    
		frmAdminDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
