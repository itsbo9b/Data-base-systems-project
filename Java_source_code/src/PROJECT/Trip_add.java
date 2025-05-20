package PROJECT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Trip_add extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pnotf;
	private JTextField desttf;
	private JTextField loctf;
	private JTextField datetf;
	private JTextField timetf;
	private JTextField pricetf;
	private JTextField gidtf;
	private JTextField sitetf;
	private JTextField nltf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trip_add frame = new Trip_add();
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
	public Trip_add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddTrips = new JLabel("Add Trips");
		lblAddTrips.setForeground(Color.BLACK);
		lblAddTrips.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddTrips.setBounds(255, 11, 130, 34);
		contentPane.add(lblAddTrips);
		
		JLabel lblNewLabel_1_2 = new JLabel("Package no.");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 81, 126, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Destination");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(10, 113, 126, 21);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Location");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2.setBounds(10, 145, 126, 21);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Date");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_3.setBounds(10, 177, 126, 21);
		contentPane.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Time");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_4.setBounds(10, 209, 126, 21);
		contentPane.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Duration");
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_5.setBounds(10, 241, 126, 21);
		contentPane.add(lblNewLabel_1_2_5);
		
		JLabel lblNewLabel_1_2_6 = new JLabel("Price");
		lblNewLabel_1_2_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_6.setBounds(10, 273, 126, 21);
		contentPane.add(lblNewLabel_1_2_6);
		
		pnotf = new JTextField();
		pnotf.setColumns(10);
		pnotf.setBounds(151, 81, 109, 26);
		contentPane.add(pnotf);
		
		desttf = new JTextField();
		desttf.setColumns(10);
		desttf.setBounds(151, 116, 109, 26);
		contentPane.add(desttf);
		
		loctf = new JTextField();
		loctf.setColumns(10);
		loctf.setBounds(151, 148, 109, 26);
		contentPane.add(loctf);
		
		datetf = new JTextField();
		datetf.setColumns(10);
		datetf.setBounds(151, 180, 109, 26);
		contentPane.add(datetf);
		
		timetf = new JTextField();
		timetf.setColumns(10);
		timetf.setBounds(151, 212, 109, 26);
		contentPane.add(timetf);
		
		JTextField durtf = new JTextField();
		durtf.setColumns(10);
		durtf.setBounds(151, 244, 109, 26);
		contentPane.add(durtf);
		
		pricetf = new JTextField();
		pricetf.setColumns(10);
		pricetf.setBounds(151, 276, 109, 26);
		contentPane.add(pricetf);
		
		JButton Addbt = new JButton("Submit");
		Addbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy"); //To make the date format like the one in the DB
				java.sql.Date sqldate = null;
			
				try {
					
			        java.util.Date date = df.parse(datetf.getText()); //converts it to date object
			        sqldate = new java.sql.Date(date.getTime()); //converts date object to sqldate object
			    } 
				
			
				
				catch (ParseException e1) {
					e1.printStackTrace();		       
			    }
			
				
				try {
					
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);
					
					String sql = "INSERT INTO TRIP VALUES(TID_SQ.NEXTVAL, ?, ?, ?, TO_DATE(?), ? ,?, ?,?)";
					
					PreparedStatement ps = ut.conn.prepareStatement(sql);

					
					ps.setString(1, pnotf.getText());
					ps.setString(2, desttf.getText());
					ps.setString(3, loctf.getText());
					ps.setDate(4, sqldate);
					ps.setString(5, timetf.getText());
					ps.setString(6, durtf.getText());
					ps.setString(7, pricetf.getText());
					ps.setString(8, gidtf.getText());
					
					int ra = ps.executeUpdate();
					
					//inserts the site and nearest landmark in the SITE table
					String sql2 = "INSERT INTO SITE VALUES(TID_SQ.CURRVAL, ?, ?)";
					PreparedStatement ps2 = ut.conn.prepareStatement(sql2);
									
					ps2.setString(1, sitetf.getText());
					ps2.setString(2, nltf.getText());
									
					int ra2 = ps2.executeUpdate();
					
					if (ra>0) {
					int y=JOptionPane.showConfirmDialog(null, "Save changes?","Yes or no", JOptionPane.YES_NO_OPTION);
						
						if(y==JOptionPane.YES_OPTION) {
							ut.conn.commit();
						JOptionPane.showMessageDialog(null, "Tour trip added successfully");}
						
						else
							ut.conn.rollback();
						
					}
	
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Invalid input, please try again. ");
				}
				
				
				
			}
		});
		Addbt.setBounds(333, 275, 119, 25);
		contentPane.add(Addbt);
		
		JButton search_bt = new JButton("Back to home");
		search_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
			      dispose();
			}
		});
		search_bt.setBounds(467, 275, 119, 25);
		contentPane.add(search_bt);
		
		JLabel lblNewLabel_2 = new JLabel("Please enter the Trip information ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(10, 41, 686, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2_7 = new JLabel("Guide ID(assigned to trip)");
		lblNewLabel_1_2_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_7.setBounds(281, 81, 249, 21);
		contentPane.add(lblNewLabel_1_2_7);
		
		gidtf = new JTextField();
		gidtf.setColumns(10);
		gidtf.setBounds(511, 81, 109, 26);
		contentPane.add(gidtf);
		
		JLabel lblNewLabel_1_2_8 = new JLabel("Site name");
		lblNewLabel_1_2_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_8.setBounds(280, 119, 130, 21);
		contentPane.add(lblNewLabel_1_2_8);
		
		sitetf = new JTextField();
		sitetf.setColumns(10);
		sitetf.setBounds(511, 116, 109, 26);
		contentPane.add(sitetf);
		
		nltf = new JTextField();
		nltf.setColumns(10);
		nltf.setBounds(511, 151, 109, 26);
		contentPane.add(nltf);
		
		JLabel lblNewLabel_1_2_8_1 = new JLabel("nearest landmark ");
		lblNewLabel_1_2_8_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_8_1.setBounds(281, 151, 159, 21);
		contentPane.add(lblNewLabel_1_2_8_1);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("(site trip will pass)");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1.setBounds(364, 117, 137, 21);
		contentPane.add(lblNewLabel_1_2_2_1);
	}
}
