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

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStudentsList extends JFrame {
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
					ViewStudentsList frame = new ViewStudentsList();
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
	
	public ViewStudentsList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1282, 851);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 90, 205));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS","root" , "");
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			String selectQuery = "SELECT * FROM `StudentList`";
			
			ResultSet rs = statement.executeQuery(selectQuery);
			
//			System.out.println(rs.toString());
			String[][] data = null;
			try {
			      rs.last();
			      int rowCount = rs.getRow();
			      rs.beforeFirst();
			      data = new String[rowCount][9];
			      int i = 0;
			      while (rs.next()) {
			        data[i][0] = rs.getString("Name");
			        data[i][1] = Integer.toString(rs.getInt("Student Id"));
			        data[i][2] = rs.getString("Mail Id");
			        data[i][3] = rs.getString("Gender");
			        data[i][4] = rs.getString("Course");
			        data[i][5]=Integer.toString(rs.getInt("Year"));
			        data[i][6] =Integer.toString(rs.getInt("Semester"));
			        i++;
			      }
			    } catch (SQLException e) {
			      System.out.println(e);
			    }
			String[] columnNames = {"Name", "Student Id", "Mail Id", "Gender", "Course", "Year", "Semester"};
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
		    contentPane.setLayout(null);
		    
		    // Table Created
		    JTable table = new JTable(model);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(110, 133, 1063, 420);
			scrollPane.setBackground(new Color(192, 192, 192));
			contentPane.add(scrollPane);

		
			table.setBackground(new Color(192, 192, 192));
			
			
			JButton btnNewButton_2 = new JButton("EXIT");
			btnNewButton_2.setBounds(585, 667, 117, 50);
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton_2.setForeground(new Color(0, 0, 255));
			contentPane.add(btnNewButton_2);
			
			JLabel lblNewLabel = new JLabel("Students List");
			lblNewLabel.setBounds(613, 15, 244, 36);
			lblNewLabel.setForeground(new Color(255, 255, 0));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton_2_1 = new JButton("< RETURN TO INSTRUCTOR DASHBOARD");
			btnNewButton_2_1.setBounds(6, 15, 445, 33);
			btnNewButton_2_1.setForeground(Color.BLUE);
			btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			contentPane.add(btnNewButton_2_1);
			
			JButton btnNewButton_1 = new JButton("New button");
			btnNewButton_1.addActionListener(new ActionListener() {
				private Window frmViewStudentsList;

				public void actionPerformed(ActionEvent e) {
					StudentsList SL = new StudentsList();
					frmViewStudentsList.setVisible(false);
					SL.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(185, 645, 117, 29);
			contentPane.add(btnNewButton_1);
			btnNewButton_2_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					InstructorDashboard adddd= new InstructorDashboard();
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
