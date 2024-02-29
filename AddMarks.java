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
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class AddMarks extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton btnNewButton;
    JComboBox<String> courses;
    JComboBox<Integer> semester;
    JComboBox<Integer> year;
	private JPanel contentPane;
	private JTextField name;
	private JTextField search;
	private JTextField full;
	private JTextField obtained;
	private JTextField pass;
	private JTextField studentid;
	private JTextField module;
	private JTextField sn;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarks frame = new AddMarks();
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
	
	public AddMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1282, 851);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 102));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String selectQuery = "SELECT * FROM `Marks`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
//			System.out.println(rs.toString());
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
			scrollPane.setBounds(331, 133, 945, 357);
			contentPane.add(scrollPane);

		
			table.setBackground(new Color(192, 192, 192));
	
			
			JButton btnNewButton = new JButton("ADD");
			btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton.setBounds(380, 558, 125, 43);
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        Component parentComponent = null;
			        if (sn.getText().isEmpty() || name.getText().isEmpty() || studentid.getText().isEmpty() || full.getText().isEmpty() || pass.getText().isEmpty() || obtained.getText().isEmpty() || courses.getSelectedItem().toString().isEmpty() || module.getText().isEmpty() || year.getSelectedItem().toString().isEmpty() || semester.getSelectedItem().toString().isEmpty()) {
			            JOptionPane.showMessageDialog(parentComponent, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
			            String insertQuery = "INSERT INTO `Marks`(`SN`, `Name`, `Student Id`, `Full Marks`, `Pass Marks`, `Obtained Marks`, `Course`, `Module`, `Year`, `Semester`) VALUES (?,?,?,?,?,?,?,?,?,?)";
			            try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
			                preparedStatement.setInt(1, Integer.parseInt(sn.getText()));
			                preparedStatement.setString(2, name.getText());
			                preparedStatement.setInt(3, Integer.parseInt(studentid.getText()));
			                preparedStatement.setInt(4, Integer.parseInt(full.getText()));
			                preparedStatement.setInt(5, Integer.parseInt(pass.getText()));
			                preparedStatement.setInt(6, Integer.parseInt(obtained.getText()));
			                preparedStatement.setString(7, courses.getSelectedItem().toString());
			                preparedStatement.setString(8, module.getText());
			                preparedStatement.setInt(9, Integer.parseInt(year.getSelectedItem().toString()));
			                preparedStatement.setInt(10, Integer.parseInt(semester.getSelectedItem().toString()));

			                int rowsAffected = preparedStatement.executeUpdate();
			                if (rowsAffected > 0) {
			                    JOptionPane.showMessageDialog(parentComponent, "Marks added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			                } else {
			                    JOptionPane.showMessageDialog(parentComponent, "Failed to add marks!", "Error", JOptionPane.ERROR_MESSAGE);
			                }
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(parentComponent, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(parentComponent, "Invalid input for SN, Student Id, Full Marks, Pass Marks, Obtained Marks, Year, or Semester.", "Error", JOptionPane.ERROR_MESSAGE);
			            ex.printStackTrace();
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
			btnNewButton_2.setBounds(544, 667, 117, 48);
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Add Marks");
			lblNewLabel.setBackground(new Color(0, 153, 153));
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			lblNewLabel.setBounds(696, 18, 180, 36);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO INSTRUCTOR DASHBOARD");
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.ITALIC, 22));
			btnNewButton_2_1.setBounds(6, 6, 445, 48);
			contentPane.add(btnNewButton_2_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					InstructorDashboard adddd= new InstructorDashboard();
					dispose();
					adddd.setVisible(true);
				}
			});
			
			
			search = new JTextField();
			search.setBounds(696, 564, 244, 37);
			contentPane.add(search);
			search.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Search Student Id to be Remove");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
			lblNewLabel_1.setForeground(new Color(0, 0, 153));
			lblNewLabel_1.setBounds(696, 533, 244, 19);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton_1 = new JButton("DELETE");
			btnNewButton_1.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String studentId = search.getText();
			        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
			            // Prepare the delete query with a parameterized statement
			            String deleteQuery = "DELETE FROM Marks WHERE `Student Id` = ?";
			            try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
			                // Set the student ID as a parameter
			                preparedStatement.setInt(1, Integer.parseInt(studentId));
			                // Execute the delete query
			                int rowsAffected = preparedStatement.executeUpdate();
			                if (rowsAffected > 0) {
			                    JOptionPane.showMessageDialog(btnNewButton_1, "Marks deleted successfully.");
			                } else {
			                    JOptionPane.showMessageDialog(btnNewButton_1, "No marks found for the given student ID.", "Error", JOptionPane.ERROR_MESSAGE);
			                }
			            }
			        } catch (SQLException ex) {
			            JOptionPane.showMessageDialog(btnNewButton_1, "Failed to delete marks. Please check your database connection.", "Error", JOptionPane.ERROR_MESSAGE);
			            ex.printStackTrace();
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(btnNewButton_1, "Invalid input for Student ID.", "Error", JOptionPane.ERROR_MESSAGE);
			            ex.printStackTrace();
			        }
			    }
			});

			
			btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
			btnNewButton_1.setBounds(940, 554, 169, 43);
			contentPane.add(btnNewButton_1);
			
		
			
			JLabel lblNewLabel_3 = new JLabel("Courses");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
			lblNewLabel_3.setForeground(new Color(0, 0, 102));
			lblNewLabel_3.setBounds(19, 474, 79, 16);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_6 = new JLabel("Semester");
			lblNewLabel_6.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
			lblNewLabel_6.setForeground(new Color(0, 0, 102));
			lblNewLabel_6.setBounds(162, 569, 92, 33);
			contentPane.add(lblNewLabel_6);
			
			JLabel lblNewLabel_3_1 = new JLabel("Pass Marks");
			lblNewLabel_3_1.setForeground(new Color(0, 0, 102));
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
			lblNewLabel_3_1.setBounds(19, 365, 92, 20);
			contentPane.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_3_2 = new JLabel("Name");
			lblNewLabel_3_2.setForeground(new Color(0, 0, 102));
			lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
			lblNewLabel_3_2.setBounds(19, 200, 79, 16);
			contentPane.add(lblNewLabel_3_2);
			
			full = new JTextField();
			full.setColumns(10);
			full.setBounds(156, 300, 173, 43);
			contentPane.add(full);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("Std Id");
			lblNewLabel_3_1_1.setForeground(new Color(0, 0, 102));
			lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
			lblNewLabel_3_1_1.setBounds(19, 255, 79, 16);
			contentPane.add(lblNewLabel_3_1_1);
			
			obtained = new JTextField();
			obtained.setColumns(10);
			obtained.setBounds(156, 414, 173, 43);
			contentPane.add(obtained);
			
			pass = new JTextField();
			pass.setColumns(10);
			pass.setBounds(156, 355, 173, 43);
			contentPane.add(pass);
			

			studentid = new JTextField();
			studentid.setColumns(10);
			studentid.setBounds(110, 243, 219, 43);
			contentPane.add(studentid);
			
			name = new JTextField();
			name.setColumns(10);
			name.setBounds(110, 188, 219, 43);
			contentPane.add(name);
			
			JLabel lblNewLabel_3_4 = new JLabel("Obtained Marks");
			lblNewLabel_3_4.setForeground(new Color(0, 0, 102));
			lblNewLabel_3_4.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
			lblNewLabel_3_4.setBounds(19, 424, 130, 20);
			contentPane.add(lblNewLabel_3_4);
			
			JLabel lblNewLabel_3_5 = new JLabel("Full Marks");
			lblNewLabel_3_5.setForeground(new Color(0, 0, 102));
			lblNewLabel_3_5.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
			lblNewLabel_3_5.setBounds(19, 310, 85, 20);
			contentPane.add(lblNewLabel_3_5);
			
	        courses = new JComboBox<String>();
			courses.setForeground(new Color(0, 0, 102));
			courses.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			courses.setModel(new DefaultComboBoxModel<String>(new String[] {"Select a Course", "BSc (Hons) in CS", "International Master in BA", "BBA", "BIBM"}));
			courses.setBounds(110, 469, 219, 33);
			contentPane.add(courses);
			
			JLabel yearr = new JLabel("Year");
			yearr.setForeground(new Color(0, 0, 102));
			yearr.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
			yearr.setBounds(19, 569, 49, 33);
			contentPane.add(yearr);
			
			semester = new JComboBox<>();
			semester.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			semester.addItem(1);
			semester.addItem(2);
			semester.addItem(3);
			semester.addItem(4);
			semester.addItem(5);
			semester.addItem(6);
			semester.setForeground(Color.BLUE);
			semester.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			semester.setBounds(243, 571, 86, 33);
			contentPane.add(semester);
			
			year = new JComboBox<>();
			year.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			year.addItem(1);
			year.addItem(2);
			year.addItem(3);
			year.setForeground(Color.BLUE);
			year.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			year.setBounds(64, 571, 86, 33);
			contentPane.add(year);
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "")) {
		            String updateQuery = "UPDATE `Marks` SET `Name`=?, `Full Marks`=?, `Pass Marks`=?, `Obtained Marks`=?, `Course`=?, `Module`=?, `Year`=?, `Semester`=? WHERE `Student Id`=?";
		            try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
		                preparedStatement.setString(1, name.getText());
		                preparedStatement.setInt(2, Integer.parseInt(full.getText()));
		                preparedStatement.setInt(3, Integer.parseInt(pass.getText()));
		                preparedStatement.setInt(4, Integer.parseInt(obtained.getText()));
		                preparedStatement.setString(5, courses.getSelectedItem().toString());
		                preparedStatement.setString(6, module.getText());
		                preparedStatement.setInt(7, Integer.parseInt(year.getSelectedItem().toString()));
		                preparedStatement.setInt(8, Integer.parseInt(semester.getSelectedItem().toString()));
		                preparedStatement.setInt(9, Integer.parseInt(studentid.getText())); // Set Student Id for the WHERE clause

		                int rowsAffected = preparedStatement.executeUpdate();
		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(btnNewButton_3, "Marks updated successfully.");
		                } else {
		                    JOptionPane.showMessageDialog(btnNewButton_3, "No marks found for the given student ID.", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(btnNewButton_3, "Failed to update marks. Please check your database connection.", "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(btnNewButton_3, "Invalid input for Full Marks, Pass Marks, Obtained Marks, Year, or Semester.", "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
		    }
		});


		btnNewButton_3.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 18));
		btnNewButton_3.setBounds(532, 558, 139, 43);
		contentPane.add(btnNewButton_3);
		
		module = new JTextField();
		module.setColumns(10);
		module.setBounds(110, 514, 219, 43);
		contentPane.add(module);
		
		JLabel lblNewLabel_3 = new JLabel("Module");
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		lblNewLabel_3.setBounds(19, 526, 79, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("SN");
		lblNewLabel_3_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		lblNewLabel_3_2.setBounds(19, 145, 79, 16);
		contentPane.add(lblNewLabel_3_2);
		
		sn = new JTextField();
		sn.setColumns(10);
		sn.setBounds(110, 133, 219, 43);
		contentPane.add(sn);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/sachinadhikari/eclipse-workspace/OOPs/Images/logout.png"));
		lblNewLabel_2.setBounds(471, 669, 61, 48);
		contentPane.add(lblNewLabel_2);
		
	}

	public void addActionListener1() {
		btnNewButton.addActionListener((ActionListener) this);
    }
}
