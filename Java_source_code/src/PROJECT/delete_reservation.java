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

public class delete_reservation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rdeltf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_reservation frame = new delete_reservation();
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
	public delete_reservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDelete = new JLabel("delete reservation ");
		lblDelete.setForeground(Color.BLACK);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDelete.setBounds(218, 11, 223, 34);
		contentPane.add(lblDelete);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the reservation number you wantto delete");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblPleaseEnterThe.setBounds(10, 88, 370, 25);
		contentPane.add(lblPleaseEnterThe);
		
		JLabel lblNewLabel_1_2 = new JLabel("Reservation no.");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(137, 148, 137, 21);
		contentPane.add(lblNewLabel_1_2);
		
		rdeltf = new JTextField();
		rdeltf.setColumns(10);
		rdeltf.setBounds(284, 148, 109, 26);
		contentPane.add(rdeltf);
		
		JButton main_bt = new JButton("Back to home");
		main_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
			    dispose();
			}
		});
		main_bt.setBounds(409, 184, 119, 24);
		contentPane.add(main_bt);
		
		JButton remove_bt = new JButton("Submit");
		remove_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Utility ut = new Utility();
					ut.conn.setAutoCommit(false);
					
					String rno = rdeltf.getText();
					
					
					String sqldel = "DELETE FROM RESERVATION WHERE RNO= ?";	
					PreparedStatement ps = ut.conn.prepareStatement(sqldel);
					ps.setString(1, rno);
					int	ru = ps.executeUpdate();
					
					if (ru >0) {
						
					int s = JOptionPane.showConfirmDialog(null, "Do you wish to save changes ?", "Press yes or no",JOptionPane.YES_NO_OPTION);
						
					if(s==JOptionPane.YES_OPTION) {
						ut.conn.commit();
					    JOptionPane.showMessageDialog(null, "Reservation " + rno + " Succesfully deleted");}
					
					else
						ut.conn.rollback();
					
					}
					
					else {
						JOptionPane.showMessageDialog(null, "No records found for reservation " + rno);
					}
	
					
				} catch (SQLException e1) {


					JOptionPane.showMessageDialog(null, "Invalid input, please try again. ");
				}
			
				
			
			}
		});
		remove_bt.setBounds(409, 149, 115, 24);
		contentPane.add(remove_bt);
	}
}
