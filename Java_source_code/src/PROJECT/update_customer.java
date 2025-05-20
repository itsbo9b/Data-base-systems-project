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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class update_customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cidtf;
	private JTextField nametf;
	private JTextField postf;
	private JTextField phonetf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_customer frame = new update_customer();
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
	public update_customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel u = new JLabel("Update a customer");
		u.setForeground(Color.BLACK);
		u.setFont(new Font("Tahoma", Font.BOLD, 20));
		u.setBounds(185, 11, 223, 34);
		contentPane.add(u);
		
		JLabel lblNewLabel_2 = new JLabel("Please enter the Customer ID of the customer whose information you want to update");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(10, 76, 686, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Customer ID");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(146, 118, 126, 21);
		contentPane.add(lblNewLabel_1_2);
		
		cidtf = new JTextField();
		cidtf.setColumns(10);
		cidtf.setBounds(311, 119, 109, 26);
		contentPane.add(cidtf);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Customer name");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(146, 196, 146, 21);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Place of stay");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2.setBounds(146, 228, 126, 21);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Phoneno.");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_3.setBounds(146, 260, 126, 21);
		contentPane.add(lblNewLabel_1_2_3);
		
		nametf = new JTextField();
		nametf.setColumns(10);
		nametf.setBounds(311, 197, 109, 26);
		contentPane.add(nametf);
		
		postf = new JTextField();
		postf.setColumns(10);
		postf.setBounds(311, 229, 109, 26);
		contentPane.add(postf);
		
		phonetf = new JTextField();
		phonetf.setColumns(10);
		phonetf.setBounds(311, 261, 109, 26);
		contentPane.add(phonetf);
		
		JButton search_bt = new JButton("Search");
		search_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Utility ut = new Utility();
					String cid = cidtf.getText();
					ut.conn.setAutoCommit(false);
					
					
					String sql = "SELECT CNAME , HOTEL, PHONENO FROM CUSTOMER WHERE CID =?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, cid);
					ResultSet rs = ut.pstmt.executeQuery();

					if(rs.next()) {
						cidtf.setEditable(false);
						String name = rs.getString("CNAME");
                        String pos = rs.getString("HOTEL");
                        String phone = rs.getString("PHONENO");
                        
                        nametf.setText(name);
                        postf.setText(pos);
                        phonetf.setText(phone);
					}
					
					else {
						 JOptionPane.showMessageDialog(null, "Customer not found");
					}
								
				} catch (SQLException e1) {					
					JOptionPane.showMessageDialog(null, "Invalid input, please try again. ");
				}
			}
		});
		search_bt.setBounds(463, 118, 119, 25);
		contentPane.add(search_bt);
		
		JButton home_bt = new JButton("Back to home");
		home_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
			      dispose();
			}
		});
		home_bt.setBounds(463, 154, 119, 25);
		contentPane.add(home_bt);
		
		JButton update_bt = new JButton("Update");
		update_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);
					
					String cid = cidtf.getText();
					String name = nametf.getText();
					String pos = postf.getText();
					String phone = phonetf.getText();
					String sql = "UPDATE CUSTOMER SET CNAME =?, HOTEL=?, PHONENO=? WHERE CID=?";
					
					ut.pstmt = ut.conn.prepareStatement(sql);
					
					ut.pstmt.setString(1, name);
					ut.pstmt.setString(2, pos);	
					ut.pstmt.setString(3, phone);
					ut.pstmt.setString(4, cid);
					
					
					int rp = ut.pstmt.executeUpdate();
					
					
					
					
					if(rp>0){
						int ch=JOptionPane.showConfirmDialog(null, "Save changes?" , "Press yes or no", JOptionPane.YES_NO_OPTION);
						
						if(ch==JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null, "Customer information updated successfully");
						ut.conn.commit();}
						else
							ut.conn.rollback();
							
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Failed to update customer information");
					}
					
	
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		update_bt.setBounds(463, 262, 119, 25);
		contentPane.add(update_bt);
	}
}
