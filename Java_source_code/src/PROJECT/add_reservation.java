package PROJECT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class add_reservation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel_1 = new JLabel("Add reservation");
	private JTextField rdatetf;
	private JTextField tidtf;
	private JTextField rsatustf;
	private JTextField cidtf;
	private JTextField pnotf;

	/**
	 * Launch the application.
	 */
	
	
	
	private String user;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_reservation frame = new add_reservation();
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
	public add_reservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel_1.setBounds(231, 11, 154, 41);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel = new JLabel("Please enter the reservation information ");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 63, 370, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Reservation date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 111, 119, 27);
		contentPane.add(lblNewLabel_2);
		
		rdatetf = new JTextField();
		rdatetf.setColumns(10);
		rdatetf.setBounds(231, 116, 96, 20);
		contentPane.add(rdatetf);
		
		tidtf = new JTextField();
		tidtf.setColumns(10);
		tidtf.setBounds(231, 147, 96, 20);
		contentPane.add(tidtf);
		
		rsatustf = new JTextField();
		rsatustf.setColumns(10);
		rsatustf.setBounds(231, 178, 96, 20);
		contentPane.add(rsatustf);
		
		cidtf = new JTextField();
		cidtf.setColumns(10);
		cidtf.setBounds(231, 207, 96, 20);
		contentPane.add(cidtf);
		
		JLabel lblNewLabel_2_1 = new JLabel("Trip ID (for the reservation)");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 142, 181, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Status (confirmed or cancelled)");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 173, 202, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Customer ID ");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(10, 204, 96, 27);
		contentPane.add(lblNewLabel_2_3);
		
		JButton submitbt = new JButton("Submit");
		submitbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String rdate = rdatetf.getText();
				
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy"); //To make the date format like the one in the DB
				java.sql.Date sql_rdate = null;
				 
				
				try {   					
			        java.util.Date old_date = df.parse(rdatetf.getText()); //converts it to date object
			        sql_rdate = new java.sql.Date(old_date.getTime()); //converts date object to sqldate object
				}
				
				
				catch (ParseException e1) {
					e1.printStackTrace();			       
			    }
			    
				
				
				try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);
					
			
					//rdate already stored in rdate variable above
					String rtid = tidtf.getText();
					String rstatus = rsatustf.getText();
					String cid = cidtf.getText();
					String pno = pnotf.getText();
					
					String sql = "INSERT INTO RESERVATION VALUES(RNO_SQ.NEXTVAL, TO_DATE(?) , ?, ? , ?, ?, (SELECT AID FROM LOGIN WHERE USERNAME= ?))";
					
				
					PreparedStatement ps0 = ut.conn.prepareStatement(sql);
					
					ps0.setDate(1, sql_rdate);
					ps0.setString(2, rtid);
					ps0.setString(3, rstatus);
					ps0.setString(4, cid);
					ps0.setString(5, pno);
					ps0.setString(6, "HA2203150");


					int c = ps0.executeUpdate();
		
					if (c>0) {
					int v=JOptionPane.showConfirmDialog(null, "Save changes? ","Press yes or no",JOptionPane.YES_NO_OPTION);
					
					if(v==JOptionPane.YES_OPTION) {
						String sql2 = "INSERT INTO CUSTOMER_PACKAGES VALUES(?,?)";
						PreparedStatement ps1 = ut.conn.prepareStatement(sql2);
						
						ps1.setString(1, cid);
						ps1.setString(2, pno);				
						ps1.executeUpdate();
						
						ut.conn.commit();
						
						
						JOptionPane.showMessageDialog(null,"Reservation succefully added");		}			
					}
					
					else 
						ut.conn.rollback();
					
				} 
				
				catch (SQLException e1) {
						e1.printStackTrace();
				}
				
			}
		});
		submitbt.setBounds(214, 282, 121, 27);
		contentPane.add(submitbt);
		
		JButton homebt = new JButton("Back to home");
		homebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainmenu.main(null);
			      dispose();
			}
		});
		homebt.setBounds(345, 282, 121, 27);
		contentPane.add(homebt);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Package no. (for the trip)");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(10, 233, 181, 27);
		contentPane.add(lblNewLabel_2_3_1);
		
		pnotf = new JTextField();
		pnotf.setColumns(10);
		pnotf.setBounds(231, 238, 96, 20);
		contentPane.add(pnotf);
	}
}
