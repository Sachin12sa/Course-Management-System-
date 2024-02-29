package Frontend;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class publishResult extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton btnNewButton;
	private JPanel contentPane;	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					publishResult frame = new publishResult();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	public publishResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1282, 851);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String selectQuery = "SELECT * FROM `Marks`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
			
			String[][] data = null;
			try {
			      rs.last();
			      int rowCount = rs.getRow();
			      rs.beforeFirst();
			      data = new String[rowCount][10];
			      int i = 0;
			      while (rs.next()) {
			    	data[i][0] = rs.getString("SN");
			        data[i][1] = rs.getString("Name");
			        data[i][2] = Integer.toString(rs.getInt("Student Id"));
			        data[i][3] = rs.getString("Full Marks");
			        data[i][4] = rs.getString("Pass Marks");
			        data[i][5] = rs.getString("Obtained Marks");
			        data[i][6] = rs.getString("Course");
			        data[i][7] = rs.getString("Module");
			        data[i][8] =Integer.toString(rs.getInt("Year"));
			        data[i][9]=Integer.toString(rs.getInt("Semester"));
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
			String[] columnNames = {"SN", "Name", "Student Id", "Full Marks", "Pass Marks", "Obtained Marks", "Course", "Module", "Semester","Year"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
		    
		    // Table Created
		    JTable table = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBackground(new Color(192, 192, 192));
			scrollPane.setBounds(6, 121, 1270, 374);
			contentPane.add(scrollPane);

		
			table.setBackground(new Color(192, 192, 192));
	
			
			JButton btnNewButton = new JButton("PUBLISH");
			btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton.setBounds(563, 546, 139, 43);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
	
				}
			});

		      getContentPane().add(btnNewButton, BorderLayout.CENTER);
			
			
			JButton btnNewButton_2 = new JButton("EXIT");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2.setForeground(new Color(0, 0, 255));
			btnNewButton_2.setBounds(574, 658, 117, 33);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Publish Result");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(624, 17, 244, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO ADMIN DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(6, 6, 445, 47);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AdminDashboard adddd= new AdminDashboard();
					dispose();
					adddd.setVisible(true);
				}
			});
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addActionListener1() {
		btnNewButton.addActionListener((ActionListener) this);
    }
}

