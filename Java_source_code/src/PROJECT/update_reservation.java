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

public class update_reservation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rnotf;
	private JTextField rdatetf;
	private JTextField rtidtf;
	private JTextField rstatustf;
	private JTextField rcidtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_reservation frame = new update_reservation();
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
	public update_reservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Update reservation");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(234, 11, 166, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the reservation number to update the reservation");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblPleaseEnterThe.setBounds(10, 36, 390, 25);
		contentPane.add(lblPleaseEnterThe);
		
		JLabel lblNewLabel_2 = new JLabel("Reservation no.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(149, 72, 102, 27);
		contentPane.add(lblNewLabel_2);
		
		rnotf = new JTextField();
		rnotf.setColumns(10);
		rnotf.setBounds(377, 77, 96, 20);
		contentPane.add(rnotf);
		
		JLabel lblNewLabel_2_1 = new JLabel("Trip ID (reserved trip)");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(149, 162, 139, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Status (confirmed or cancelled)");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(149, 200, 197, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_5 = new JLabel("Reservation date");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(149, 124, 109, 27);
		contentPane.add(lblNewLabel_2_5);
		
		rdatetf = new JTextField();
		rdatetf.setColumns(10);
		rdatetf.setBounds(377, 129, 96, 20);
		contentPane.add(rdatetf);
		
		rtidtf = new JTextField();
		rtidtf.setColumns(10);
		rtidtf.setBounds(377, 167, 96, 20);
		contentPane.add(rtidtf);
		
		rstatustf = new JTextField();
		rstatustf.setColumns(10);
		rstatustf.setBounds(377, 205, 96, 20);
		contentPane.add(rstatustf);
		
		JButton tsearchbt = new JButton("search");
		tsearchbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {		
					
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);
	
	
					String rno = rnotf.getText();	

					
					String sql = "SELECT RDATE , TID, STATUS, CID FROM RESERVATION WHERE RNO= ?";
					PreparedStatement ps = ut.conn.prepareStatement(sql);
					ps.setString(1, rno);
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						rnotf.setEditable(false);
						
						//assigning values to each column
						String rdate = rs.getString("RDATE");
                        String tid = rs.getString("TID");
                        String status = rs.getString("STATUS");             
                        String cid = rs.getString("CID");    
                        
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); //To make the date format like the one in the DB
        				java.sql.Date sql_tdate = null;
        				    				
        				try {   					
        			        java.util.Date old_date = df.parse(rdate); //converts it to date object
        			        sql_tdate = new java.sql.Date(old_date.getTime()); //converts date object to sqldate object
        				}
        				
        				
        				catch (ParseException e1) {
        					JOptionPane.showMessageDialog(null, "Invalid input, please try again. ");			       
        			    }
        			    

        				String string_date = df.format(sql_tdate);
         	           
        				//setting values
        	            
        	            rdatetf.setText(string_date);
        	            rtidtf.setText(tid);
        	            rstatustf.setText(status);
        	            rcidtf.setText(cid);
        	            
        	            rcidtf.setEditable(false); }
					
					else {
						JOptionPane.showMessageDialog(null, "No records found for reservation. ");
					}
					
		
					
				}
				
					catch (SQLException e1) {					
						JOptionPane.showMessageDialog(null, "Invalid input, please try again. "); }
				
        				
			
			
			}});
									
        	            
		
		tsearchbt.setBounds(505, 74, 121, 27);
		contentPane.add(tsearchbt);
		
		JButton tupdate = new JButton("Update");
		tupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				String rno = rnotf.getText();
				String rdate = rdatetf.getText();
                String tid = rtidtf.getText();
                String status =  rstatustf.getText();                                  


				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss"); //To make the date format like the one in the DB
				java.sql.Date sql_rdate = null;
				
			 	//to just convert the date string retrieved from the date text field to a sql date object in a specific format 		
				try {				
			        java.util.Date old_rdate = df.parse(rdate); //converts it to date object
			        sql_rdate = new java.sql.Date(old_rdate.getTime()); }//converts date object to sqldate object
			     
						
				catch (ParseException e1) {
			        e1.printStackTrace();			       
			    }
					
								
						
				try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);

                    String sql = "UPDATE RESERVATION SET RDATE=? , TID=? , STATUS=? WHERE RNO= ?";
                    PreparedStatement ps = ut.conn.prepareStatement(sql);
                    ps.setDate(1, sql_rdate); //using the date string we converted to a sqldate object above (line 197)
                    ps.setString(2, tid);
                    ps.setString(3, status);
                    ps.setString(4, rno);
                    
                    int rp = ps.executeUpdate();
                    
                    if (rp>0) {
                    	
                    int ch = JOptionPane.showConfirmDialog(null, "Do you wish to save changes? " , "Press yes or no", JOptionPane.YES_NO_OPTION);
                    	
                    	if (ch==JOptionPane.YES_OPTION) {
                    		ut.conn.commit();
                    		JOptionPane.showMessageDialog(null, "Reservation no. " + rno +" succcesfully updated");
                    		
                    	}
                   	
                    	else
                    		ut.conn.rollback();
      	
                    	
                    }                  
                    else {
                    	JOptionPane.showMessageDialog(null, "No records found for reservation no.  " + rno);
                    }
          
				
				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Invalid input, please try again. ");
				}
				
	
			}
		});
		tupdate.setBounds(505, 204, 121, 27);
		contentPane.add(tupdate);
		
		JButton homebt = new JButton("Back to home");
		homebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
				dispose();
			}
		});
		homebt.setBounds(505, 243, 121, 27);
		contentPane.add(homebt);
		
		rcidtf = new JTextField();
		rcidtf.setColumns(10);
		rcidtf.setBounds(377, 246, 96, 20);
		contentPane.add(rcidtf);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Customer ID");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(149, 238, 197, 27);
		contentPane.add(lblNewLabel_2_2_1);
	}
}
