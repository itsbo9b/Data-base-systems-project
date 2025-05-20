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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class remove_customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cid_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					remove_customer frame = new remove_customer();
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
	public remove_customer() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRemoveACustomer = new JLabel("Remove a customer");
		lblRemoveACustomer.setForeground(Color.BLACK);
		lblRemoveACustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRemoveACustomer.setBounds(210, 11, 223, 34);
		contentPane.add(lblRemoveACustomer);

		JLabel lblNewLabel_2 = new JLabel("Please enter the Customer ID of the customer you wish to remove");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(10, 90, 686, 31);
		contentPane.add(lblNewLabel_2);

		cid_tf = new JTextField();
		cid_tf.setColumns(10);
		cid_tf.setBounds(238, 132, 109, 26);
		contentPane.add(cid_tf);

		JLabel lblNewLabel_1_2 = new JLabel("Customer ID");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(118, 132, 122, 21);
		contentPane.add(lblNewLabel_1_2);

		JButton remove_bt = new JButton("Submit");
		remove_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);
					String cid_str = cid_tf.getText();

					// Delete records from RESERVATION (to aviod integrity constraint)
					String reservation_del_sql = "DELETE FROM RESERVATION WHERE CID = ?";
					PreparedStatement ps1 = ut.conn.prepareStatement(reservation_del_sql);
					ps1.setString(1, cid_str);
					ps1.executeUpdate();

					// Delete records from CUSTOMERPACKAGES
					String customer_packs_del_sql = "DELETE FROM CUSTOMER_PACKAGES WHERE CID = ?";
					PreparedStatement ps2 = ut.conn.prepareStatement(customer_packs_del_sql);
					ps2.setString(1, cid_str);
					ps2.executeUpdate();

					// delete record from CUSTOMER
					String customer_del_sql = "DELETE FROM CUSTOMER WHERE CID = ?";
					PreparedStatement ps_cust_del = ut.conn.prepareStatement(customer_del_sql);
					ps_cust_del.setString(1, cid_str);
					int rd = ps_cust_del.executeUpdate();
					
					
					//check if records got deleted
					if (rd > 0) {
						int ch = JOptionPane.showConfirmDialog(null, "Save Changes?", "Press yes or no",
								JOptionPane.YES_NO_OPTION);

						if (ch == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null, "Customer Successfully deleted");
							ut.conn.commit();
						}

						else {
							ut.conn.rollback();
						}

					}

					else {
						JOptionPane.showMessageDialog(null, "No records found for the Customer ID.");
					}

				}

				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Invalid input, please try again. ");
				}
			}
		});

		remove_bt.setBounds(250, 178, 115, 24);
		contentPane.add(remove_bt);

		JButton main_bt = new JButton("Back to home");
		main_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
				dispose();
			}
		});
		main_bt.setBounds(121, 178, 119, 24);
		contentPane.add(main_bt);
	}
}
