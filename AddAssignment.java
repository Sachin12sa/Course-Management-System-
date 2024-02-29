package Frontend;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddAssignment extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static final int JTextField = 0;
	JButton btnNewButton;
    JComboBox<String> courses;
	private JPanel contentPane;
	private JTextField search;
	private JTextField time;
	private JTextField date;
	private JTextField module;
	private JTextField day;
	private JTextField description;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAssignment frame = new AddAssignment();
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
	
	public AddAssignment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 853);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			String selectQuery = "SELECT * FROM `Assignment`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
//			System.out.println(rs.toString());
			String[][] data = null;
			try {
			      rs.last();
			      int rowCount = rs.getRow();
			      rs.beforeFirst();
			      data = new String[rowCount][6];
			      int i = 0;
			      while (rs.next()) {
			        data[i][0] = rs.getString("Course");
			        data[i][1] = rs.getString("Module");
			        data[i][2] = rs.getString("Day");
			        data[i][3] = rs.getString("Due Date");
			        data[i][4] = rs.getString("Time");
			        data[i][5] = rs.getString("Description");
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
			String[] columnNames = {"Course", "Module", "Day", "Due Date", "Time", "Description"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
		    
		    // Table Created
		    JTable table = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBackground(new Color(192, 192, 192));
			scrollPane.setBounds(19, 93, 1243, 282);
			contentPane.add(scrollPane);

		
			table.setBackground(new Color(192, 192, 192));
	
			
			JButton btnNewButton = new JButton("ADD");
			btnNewButton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        Component parentComponent = null; // You can set a proper parent component here
			        if (courses.getSelectedItem().toString().isEmpty() || module.getText().isEmpty() || date.getText().isEmpty() || time.getText().isEmpty() || day.getText().isEmpty() || description.getText().isEmpty()) {
			            JOptionPane.showMessageDialog(parentComponent, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
			            return; // Exit the method if any field is empty
			        }

			        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
			            String insertQuery = "INSERT INTO `Assignment`(`Course`, `Module`, `Due Date`, `Time`, `Day`, `Description`) VALUES (?,?,?,?,?,?)";
			            try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
			                preparedStatement.setString(1, courses.getSelectedItem().toString());
			                preparedStatement.setString(2, module.getText());
			                preparedStatement.setString(3, date.getText());
			                preparedStatement.setString(4, time.getText());
			                preparedStatement.setString(5, day.getText());
			                preparedStatement.setString(6, description.getText());

			                int rowsAffected = preparedStatement.executeUpdate();
			                if (rowsAffected > 0) {
			                    JOptionPane.showMessageDialog(parentComponent, "Assignment added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			                } else {
			                    JOptionPane.showMessageDialog(parentComponent, "Failed to add assignment!", "Error", JOptionPane.ERROR_MESSAGE);
			                }
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(parentComponent, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			});

			JButton btnNewButton_2 = new JButton("EXIT");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2.setForeground(new Color(0, 0, 255));
			btnNewButton_2.setBounds(684, 732, 117, 33);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Add Assignment");
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(623, 15, 257, 52);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO INSTRUCTOR DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2_1.setBounds(19, 18, 445, 33);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					InstructorDashboard iddd= new InstructorDashboard();
					dispose();
					iddd.setVisible(true);
				}
			});
			
			
			search = new JTextField();
			search.setBounds(755, 625, 231, 39);
			contentPane.add(search);
			search.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Search Date for deleting Assignment");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblNewLabel_1.setForeground(new Color(255, 255, 0));
			lblNewLabel_1.setBounds(755, 600, 412, 19);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton_1 = new JButton("DELETE");
			btnNewButton_1.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String dueDate = search.getText();
			        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
			            String deleteQuery = "DELETE FROM `Assignment` WHERE `Due Date` = ?";
			            try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
			                preparedStatement.setString(1, dueDate);

			                int rowsAffected = preparedStatement.executeUpdate();
			                if (rowsAffected > 0) {
			                    JOptionPane.showMessageDialog(null, "Assignment deleted successfully!");
			                } else {
			                    JOptionPane.showMessageDialog(null, "No assignment found with the specified due date.");
			                }
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			});

			
			btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton_1.setBounds(998, 625, 169, 43);
			contentPane.add(btnNewButton_1);
			
		
			
			JLabel lblNewLabel_3 = new JLabel("Courses");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
			lblNewLabel_3.setForeground(new Color(0, 255, 0));
			lblNewLabel_3.setBounds(169, 398, 105, 37);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_3_1 = new JLabel("Date");
			lblNewLabel_3_1.setForeground(Color.GREEN);
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
			lblNewLabel_3_1.setBounds(169, 475, 105, 27);
			contentPane.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_3_4 = new JLabel("Module");
			lblNewLabel_3_4.setForeground(Color.GREEN);
			lblNewLabel_3_4.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
			lblNewLabel_3_4.setBounds(551, 391, 105, 33);
			contentPane.add(lblNewLabel_3_4);
			
			JLabel lblNewLabel_3_5 = new JLabel("Time");
			lblNewLabel_3_5.setForeground(Color.GREEN);
			lblNewLabel_3_5.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
			lblNewLabel_3_5.setBounds(385, 475, 79, 27);
			contentPane.add(lblNewLabel_3_5);
			
	        courses = new JComboBox<String>();
			courses.setForeground(new Color(0, 0, 255));
			courses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			courses.setModel(new DefaultComboBoxModel<String>(new String[] {"Select a Course", "BSc (Hons) in CS", "International Master in BA", "BBA", "BIBM"}));
			courses.setBounds(102, 436, 283, 38);
			contentPane.add(courses);
		
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setForeground(new Color(152, 251, 152));
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
		btnNewButton.setBounds(489, 600, 152, 52);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Component parentComponent = null;
		        if (courses.getSelectedItem().toString().isEmpty() || module.getText().isEmpty() || date.getText().isEmpty() || time.getText().isEmpty() || day.getText().isEmpty() || description.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(parentComponent, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
		            String insertQuery = "INSERT INTO `Assignment`(`Course`, `Module`, `Due Date`, `Time`, `Day`, `Description`) VALUES (?,?,?,?,?,?)";
		            try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
		                preparedStatement.setString(1, courses.getSelectedItem().toString());
		                preparedStatement.setString(2, module.getText());
		                preparedStatement.setString(3, date.getText());
		                preparedStatement.setString(4, time.getText());
		                preparedStatement.setString(5, day.getText());
		                preparedStatement.setString(6, description.getText());

		                int rowsAffected = preparedStatement.executeUpdate();
		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(parentComponent, "Assignment added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(parentComponent, "Failed to add assignment!", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(parentComponent, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});


		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.setForeground(new Color(144, 238, 144));
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Component parentComponent = null; // You can set a proper parent component here
		        if (courses.getSelectedItem().toString().isEmpty() || module.getText().isEmpty() || time.getText().isEmpty() || day.getText().isEmpty() || description.getText().isEmpty() || date.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(parentComponent, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
		            return; // Exit the method if any field is empty
		        }

		        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
		            String updateQuery = "UPDATE `Assignment` SET `Module`=?, `Time`=?, `Description`=? WHERE `Due Date`=?";
		            try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
		                preparedStatement.setString(1, module.getText());
		                preparedStatement.setString(2, time.getText());
		                preparedStatement.setString(3, description.getText());
		                preparedStatement.setString(4, date.getText()); // Update based on Due Date

		                int rowsAffected = preparedStatement.executeUpdate();
		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(parentComponent, "Assignment updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(parentComponent, "Failed to update assignment!", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(parentComponent, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});



	


		
		
		
		btnNewButton_3.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
		btnNewButton_3.setBounds(189, 600, 183, 61);
		contentPane.add(btnNewButton_3);
		
		time = new JTextField();
		time.setColumns(10);
		time.setBounds(319, 502, 203, 43);
		contentPane.add(time);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(104, 502, 203, 43);
		contentPane.add(date);
		
		module = new JTextField();
		module.setColumns(10);
		module.setBounds(443, 436, 293, 43);
		contentPane.add(module);
		
		day = new JTextField();
		day.setColumns(10);
		day.setBounds(534, 502, 203, 43);
		contentPane.add(day);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(786, 437, 418, 116);
		contentPane.add(description);
		
		JLabel lblNewLabel_3_5 = new JLabel("Day");
		lblNewLabel_3_5.setForeground(Color.GREEN);
		lblNewLabel_3_5.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
		lblNewLabel_3_5.setBounds(600, 475, 79, 27);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("Description");
		lblNewLabel_3_5_1.setForeground(Color.GREEN);
		lblNewLabel_3_5_1.setFont(new Font("Lucida Grande", Font.ITALIC, 19));
		lblNewLabel_3_5_1.setBounds(967, 406, 117, 20);
		contentPane.add(lblNewLabel_3_5_1);
		
	}

	public void addActionListener1() {
		btnNewButton.addActionListener((ActionListener) this);
    }
}
