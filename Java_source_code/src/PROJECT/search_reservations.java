package PROJECT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class search_reservations extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField cidtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_reservations frame = new search_reservations();
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
	public search_reservations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 638, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDelete = new JLabel("Search reservations");
		lblDelete.setForeground(Color.BLACK);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDelete.setBounds(208, 11, 223, 34);
		contentPane.add(lblDelete);
		
		JLabel lblPleaseEnterThe_1 = new JLabel("Please enter the customer ID to view reservations");
		lblPleaseEnterThe_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblPleaseEnterThe_1.setBounds(10, 52, 370, 25);
		contentPane.add(lblPleaseEnterThe_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Customer ID");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 88, 137, 21);
		contentPane.add(lblNewLabel_1_2);
		
		cidtf = new JTextField();
		cidtf.setColumns(10);
		cidtf.setBounds(157, 88, 109, 26);
		contentPane.add(cidtf);
		
		JButton submittf = new JButton("Submit");
		submittf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					Utility ut=new Utility();
					String cid = cidtf.getText();
					
					String sql="SELECT * FROM RESERVATION WHERE CID= ?";								
					PreparedStatement ps = ut.conn.prepareStatement(sql);
					ps.setString(1, cid);
					ResultSet rs =ps.executeQuery();		
										
					
					if(!rs.isBeforeFirst()) //checks if result set is empty
						JOptionPane.showMessageDialog(null, "No reservations for the entered customer ID");
					
					//if the if(!rs.isBeforeFirst()) condition is false , the records will be displayed in the table
					table.setModel(DbUtils.resultSetToTableModel(rs));
			
					
				} 
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Invalid input, please try again. ");
				}
				
			}
		});
				

		submittf.setBounds(291, 89, 115, 24);
		contentPane.add(submittf);
		
		JButton hometf = new JButton("Back to home");
		hometf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
				dispose();
			}
		});
		hometf.setBounds(416, 89, 119, 24);
		contentPane.add(hometf);
	}
}
