package PROJECT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class reservations_report1 extends JFrame {

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
					reservations_report1 frame = new reservations_report1();
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
	public reservations_report1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel rreport = new JLabel("Reservations report");
		rreport.setFont(new Font("Tahoma", Font.BOLD, 20));
		rreport.setBounds(215, 11, 221, 25);
		contentPane.add(rreport);
		
		JLabel lblNewLabel_1 = new JLabel("Please click on the following button to display a report of all reservations");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 47, 439, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton showbt = new JButton("Display");
		showbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Utility ut = new Utility();					
					String sql="SELECT * FROM RESERVATIONS";
					ut.stmt = ut.conn.createStatement();
					ut.rs=ut.stmt.executeQuery(sql);
					
										
					
					if(!ut.rs.isBeforeFirst()) //checks if result set is empty
						JOptionPane.showMessageDialog(null, "No reservations available. ");
					
					//if the if(!rs.isBeforeFirst()) condition is false , the records will be displayed in the table
					table.setModel(DbUtils.resultSetToTableModel(ut.rs));
					
					
					
				} catch (SQLException e1) {
				
					e1.printStackTrace();;
				}
				
	 
			
			}
		});
			

		showbt.setBounds(322, 84, 114, 25);
		contentPane.add(showbt);
		
		JButton homebt = new JButton("Back to home");
		homebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
				dispose();
			}
		});
		homebt.setBounds(198, 84, 114, 25);
		contentPane.add(homebt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 122, 628, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
