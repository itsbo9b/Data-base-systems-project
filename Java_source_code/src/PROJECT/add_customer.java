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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class add_customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cid_tf;
	private JTextField cname_tf;
	private JTextField pos_tf;
	private JTextField phone_tf;
	private JButton insertbt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_customer frame = new add_customer();
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
	public add_customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add a new customer");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(191, 11, 279, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(105, 88, 115, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(105, 123, 150, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Place of stay");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(105, 159, 126, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phoneno.");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(105, 191, 115, 24);
		contentPane.add(lblNewLabel_1_3);
		
		cid_tf = new JTextField();
		cid_tf.setBounds(265, 91, 109, 26);
		contentPane.add(cid_tf);
		cid_tf.setColumns(10);
		
		cname_tf = new JTextField();
		cname_tf.setColumns(10);
		cname_tf.setBounds(265, 129, 109, 26);
		contentPane.add(cname_tf);
		
		pos_tf = new JTextField();
		pos_tf.setColumns(10);
		pos_tf.setBounds(265, 163, 109, 26);
		contentPane.add(pos_tf);
		
		phone_tf = new JTextField();
		phone_tf.setColumns(10);
		phone_tf.setBounds(265, 197, 109, 26);
		contentPane.add(phone_tf);
		
		insertbt = new JButton("Submit");
		insertbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Utility ut = new Utility();	
					ut.conn.setAutoCommit(false);
					String cid_str = cid_tf.getText();
					String phone_str = phone_tf.getText();
					
					String sql = "INSERT INTO CUSTOMER VALUES(?,?,?,?)";
					
					ut.pstmt=ut.conn.prepareStatement(sql);
					
//					int cid_int = Integer.parseInt(cid_str);
//					int phone_int = Integer.parseInt(phone_str);
//					
					ut.pstmt.setString(1, cid_str);
					ut.pstmt.setString(2, cname_tf.getText());		
					ut.pstmt.setString(3, pos_tf.getText());
					ut.pstmt.setString(4, phone_str);
					
					ut.pstmt.executeUpdate();
					int ch=JOptionPane.showConfirmDialog(null, "Save changes?" , "Press yes or no", JOptionPane.YES_NO_OPTION);
					
					if(ch==JOptionPane.YES_OPTION) {
						ut.conn.commit();
						JOptionPane.showMessageDialog(null, "Customer Succesfully added");
					}
					
					else {
						
						ut.conn.rollback();
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();

				}
				
			}
		});
		insertbt.setBounds(203, 250, 115, 24);
		contentPane.add(insertbt);
		
		JButton main_bt = new JButton("Back to home");
		main_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
			     dispose();
			}
		});
		main_bt.setBounds(331, 251, 115, 24);
		contentPane.add(main_bt);
	}
}
