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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.awt.event.ActionEvent;

public class trip_update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tidtf;
	private JTextField pnotf;
	private JTextField tdesttf;
	private JTextField tloctf;
	private JTextField tdatetf;
	private JTextField ttimetf;
	private JTextField tdurtf;
	private JTextField tpricetf;
	private JTextField gidtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trip_update frame = new trip_update();
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
	public trip_update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the trip ID to update trip information");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 69, 370, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update trip");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(243, 11, 109, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Trip ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(196, 105, 57, 27);
		contentPane.add(lblNewLabel_2);
		
		tidtf = new JTextField();
		tidtf.setBounds(309, 110, 96, 20);
		contentPane.add(tidtf);
		tidtf.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Package no.");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(196, 160, 76, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Trip destination");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(196, 184, 109, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Trip location");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(196, 209, 87, 27);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Trip date");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(196, 233, 57, 27);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Trip time");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(196, 260, 66, 27);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Trip duration");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4_1.setBounds(196, 282, 87, 27);
		contentPane.add(lblNewLabel_2_4_1);
		
		pnotf = new JTextField();
		pnotf.setBounds(309, 165, 96, 20);
		contentPane.add(pnotf);
		pnotf.setColumns(10);
		
		tdesttf = new JTextField();
		tdesttf.setColumns(10);
		tdesttf.setBounds(309, 189, 96, 20);
		contentPane.add(tdesttf);
		
		tloctf = new JTextField();
		tloctf.setColumns(10);
		tloctf.setBounds(309, 214, 96, 20);
		contentPane.add(tloctf);
		
		tdatetf = new JTextField();
		tdatetf.setColumns(10);
		tdatetf.setBounds(309, 238, 96, 20);
		contentPane.add(tdatetf);
		
		ttimetf = new JTextField();
		ttimetf.setColumns(10);
		ttimetf.setBounds(309, 265, 96, 20);
		contentPane.add(ttimetf);
		
		tdurtf = new JTextField();
		tdurtf.setColumns(10);
		tdurtf.setBounds(309, 287, 96, 20);
		contentPane.add(tdurtf);
		
		tpricetf = new JTextField();
		tpricetf.setColumns(10);
		tpricetf.setBounds(309, 315, 96, 20);
		contentPane.add(tpricetf);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Trip price");
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4_1_1.setBounds(196, 313, 87, 20);
		contentPane.add(lblNewLabel_2_4_1_1);
		
		JButton tomebt = new JButton("Back to home");
		tomebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				mainmenu.main(null);
			    dispose();
			}
		});
		
		
		tomebt.setBounds(492, 262, 121, 27);
		contentPane.add(tomebt);
		
		JButton tupdatebt = new JButton("Update");
		tupdatebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//to be able to add it to the DB by converting it to a DATE object
				
				String date = tdatetf.getText(); //will get the date string after searching for a specific trip ID from the textfield
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss"); //To make the date format like the one in the DB
				java.sql.Date sql_tdate = null;
			
				try {
					
			        java.util.Date old_date = df.parse(date); //converts it to date object
			        sql_tdate = new java.sql.Date(old_date.getTime()); //converts date object to sql date object
			    } 
						
				catch (ParseException e1) {
			        e1.printStackTrace();			       
			    }
				
				

				try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);
					
					String tid = tidtf.getText();
					String pno = pnotf.getText();
					String dest = tdesttf.getText();
				 	String loc = tloctf.getText();
				    //trip date	(sql date) in line 178
					String time = ttimetf.getText();
					String dura = tdurtf.getText();
					String price= tpricetf.getText();
					String guide = gidtf.getText();
					
					String sql = "UPDATE TRIP SET PNUM =?, DESTINATION =?, LOCATION= ?, TDATE = TO_DATE(?) , TIME=? ,DURATION=? ,  PRICE=?, GID= ? WHERE TID=?";
					
					ut.pstmt = ut.conn.prepareStatement(sql);

					ut.pstmt.setString(1, pno);
					ut.pstmt.setString(2, dest);	
					ut.pstmt.setString(3, loc);
					ut.pstmt.setDate(4, sql_tdate);
					ut.pstmt.setString(5, time);
					ut.pstmt.setString(6, dura);
					ut.pstmt.setString(7, price);
					ut.pstmt.setString(8, guide);
					ut.pstmt.setString(9, tid);
						
					int rp = ut.pstmt.executeUpdate();
					
					if(rp>0){
						int ch=JOptionPane.showConfirmDialog(null, "Save changes?" , "Press yes or no", JOptionPane.YES_NO_OPTION);
						
						if(ch==JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null, "Trip information updated successfully");
							ut.conn.commit();}
							
						else {
							ut.conn.rollback();	
						}
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Failed to update trip information");
					}
					
					
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		tupdatebt.setBounds(492, 300, 121, 27);
		contentPane.add(tupdatebt);
		
		JButton tsearchbt = new JButton("search");
		tsearchbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
//				String date2 = tdatetf.getText();
				
				
				try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);
					
					
					String tid = tidtf.getText();					
					String sql = "SELECT TID , PNUM , DESTINATION, LOCATION , TDATE , TIME, DURATION, PRICE, GID FROM TRIP WHERE TID= ?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, tid);
					ResultSet rs = ut.pstmt.executeQuery();
			
					
					if (rs.next()) {
						tidtf.setEditable(false);
						
						//assigning values
						String pno = rs.getString("PNUM");
                        String desti = rs.getString("DESTINATION");
                        String loc = rs.getString("LOCATION");             
                        String date = rs.getString("TDATE");
                        String time = rs.getString("TIME");                                            
                        String dur = rs.getString("DURATION");
                        String price = rs.getString("PRICE");
                        String guide = rs.getString("GID");
                        //to just change the format of the trip date that will appear in the textfield 
                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); //To make the date format like the one in the DB
        				java.sql.Date sql_tdate = null;
        				
        				try {   					
        			        java.util.Date old_date2 = df.parse(date); //converts it(the date string)  to a java.util.date object
        			        sql_tdate = new java.sql.Date(old_date2.getTime()); //converts date object to java.sql.sqldate object
        			        
        			    } 
        						
        				catch (ParseException e1) {
        			        e1.printStackTrace();			       
        			    }
        				
        	            String newdate = df.format(sql_tdate);
                        
                        
                        //setting values
                        pnotf.setText(pno);
                        tdesttf.setText(desti);
                        tloctf.setText(loc);
                        tdatetf.setText(newdate);
                        ttimetf.setText(time);
                        tdurtf.setText(dur);
                        tpricetf.setText(price);   
                        gidtf.setText(guide);  
					}
					
				  else {
						 JOptionPane.showMessageDialog(null, "Trip not found");
					}
					
				} catch (SQLException e1) {
					
					JOptionPane.showMessageDialog(null, "Invalid input, please try again. ");
				}
				
			}
		});
		tsearchbt.setBounds(492, 107, 121, 27);
		contentPane.add(tsearchbt);
		
		JLabel lblNewLabel_2_4_1_2 = new JLabel("Guide ID");
		lblNewLabel_2_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_4_1_2.setBounds(427, 160, 87, 27);
		contentPane.add(lblNewLabel_2_4_1_2);
		
		gidtf = new JTextField();
		gidtf.setColumns(10);
		gidtf.setBounds(492, 165, 96, 20);
		contentPane.add(gidtf);
	}
}
