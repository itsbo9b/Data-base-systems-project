package PROJECT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Trips_report1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trips_report1 frame = new Trips_report1();
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
	public Trips_report1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trips report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(255, 11, 147, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please click on the following button to display a report of all trips.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 47, 419, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton treport_bt = new JButton("Disaplay");
		treport_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Utility ut=new Utility();
					
					String sql="SELECT * FROM TRIPS_REPORT";
					Statement st=ut.conn.createStatement();
					ResultSet rs=st.executeQuery(sql);
					
			
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
		
					
				} 
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
			
		
		treport_bt.setBounds(274, 83, 114, 25);
		contentPane.add(treport_bt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 119, 658, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton homebt = new JButton("Back to home");
		homebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
			     dispose();
			}
		});
		homebt.setBounds(150, 83, 114, 25);
		contentPane.add(homebt);
	}
}
