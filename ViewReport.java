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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewReport extends JFrame {
  private static final long serialVersionUID = 1L;
JButton searchButton;
  private JPanel contentPane;
  private JTextField searchName;
  private JTextField searchStudentId;

  /**
   * Launch the application.
   */

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ViewReport frame = new ViewReport();
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
	
	public ViewReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1282, 851);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//			System.out.println(rs.toString());
			
			JButton btnNewButton_2 = new JButton("EXIT");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2.setForeground(new Color(0, 0, 255));
			btnNewButton_2.setBounds(585, 667, 117, 33);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Result Sheet");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(512, 18, 244, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO STUDENT DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(6, 6, 445, 33);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					StudentDashboard adddd= new StudentDashboard();
					dispose();
					adddd.setVisible(true);
				}
			});
			
			
			JButton searchButton;

			// Add search button and text fields to capture inputs for name and student id
			searchButton = new JButton("SEARCH");
			searchButton.setForeground(new Color(106, 90, 205));
			searchButton.setBounds(492, 154, 100, 43);
			contentPane.add(searchButton);

			searchName = new JTextField();
			searchName.setBounds(79, 154, 190, 43);
			contentPane.add(searchName);

			searchStudentId = new JTextField();
			searchStudentId.setBounds(300, 154, 169, 43);
			contentPane.add(searchStudentId);

			
			// Add action listener for search button to retrieve and display data based on name and student id inputs
			searchButton.addActionListener(new ActionListener() {
				@SuppressWarnings("unused")
				public void actionPerformed(ActionEvent e) {
					String StudentId = searchStudentId.getText();
					String Name = searchName.getText();
					
//					// Clear the table
//					tableModel.setRowCount(0);

					try {
						// Connect to the database
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "");
						Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

						// Build the query
						String query = "SELECT * FROM Marks WHERE";
						boolean whereClauseAdded = false;
						if (!StudentId.isEmpty()) {
						    query += "`Student Id` = " + Integer.parseInt(searchStudentId.getText());
						    whereClauseAdded = true;
						}
						if (!Name.isEmpty()) {
						    if (whereClauseAdded) {
						        query += " AND";
						    }
						    query += " `Name` = '" + searchName.getText() + "'";
						    whereClauseAdded = true;
						}
						if (!whereClauseAdded) {
						    query = "SELECT * FROM Marks";
						}


						// Execute the query
						Statement statement11 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = statement11.executeQuery(query);


						// Populate the table with the results
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
						    } catch (SQLException e1) {
						      System.out.println(e1);
						    }
						String[] columnNames = {"SN", "Name", "Student Id", "Full Marks", "Pass Marks", "Obtained Marks", "Course", "Module", "Semester","Year"};
						DefaultTableModel model = new DefaultTableModel(data, columnNames);
						
					    // Table Created
					    JTable table = new JTable(model);
						
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBackground(new Color(192, 192, 192));
						scrollPane.setBounds(6, 241, 1270, 374);
						contentPane.add(scrollPane);
						table.setBackground(new Color(192, 192, 192));
						

						// Close the connection
						connection.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});

			
			JLabel lblNewLabel_3_2 = new JLabel("Name");
			lblNewLabel_3_2.setForeground(Color.GREEN);
			lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_2.setBounds(150, 126, 79, 16);
			contentPane.add(lblNewLabel_3_2);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("Std Id");
			lblNewLabel_3_1_1.setForeground(Color.GREEN);
			lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel_3_1_1.setBounds(357, 126, 79, 16);
			contentPane.add(lblNewLabel_3_1_1);
		
	}

	public void addActionListener1() {
		searchButton.addActionListener((ActionListener) this);
    }
}
