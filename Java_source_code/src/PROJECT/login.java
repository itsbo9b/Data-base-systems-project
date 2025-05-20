package PROJECT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertf;
	private JTextField passtf;

	public String getuser() {
		return usertf.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel welcome_label = new JLabel("System Login");
		welcome_label.setFont(new Font("Tahoma", Font.BOLD, 34));
		welcome_label.setBounds(208, 22, 244, 56);
		contentPane.add(welcome_label);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(172, 138, 145, 43);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(172, 185, 134, 31);
		contentPane.add(lblNewLabel_1);

		usertf = new JTextField();
		usertf.setBounds(252, 151, 151, 20);
		contentPane.add(usertf);
		usertf.setColumns(10);

		JPasswordField passfield = new JPasswordField();
		passfield.setBounds(252, 192, 151, 20);
		contentPane.add(passfield);

		JButton loginbt = new JButton("login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user = usertf.getText();
				String pass = new String(passfield.getPassword());
				Utility ut;

				try {
					ut = new Utility();
					String sql = "SELECT USERNAME , PASSWORD FROM LOGIN WHERE USERNAME=? AND PASSWORD=?";
					ut.pstmt = ut.conn.prepareStatement(sql);
					ut.pstmt.setString(1, user);
					ut.pstmt.setString(2, pass);
					ResultSet rs = ut.pstmt.executeQuery();

					if (rs.next()) {

						// To dislay Agent id of the username
						String sql2 = "SELECT AID FROM LOGIN WHERE USERNAME= ? AND PASSWORD= ?";
						PreparedStatement ps = ut.conn.prepareStatement(sql2);
						ps.setString(1, user);
						ps.setString(2, pass);
						ResultSet rs2 = ps.executeQuery();

						if (rs2.next()) {

							int aid = rs2.getInt("AID");
							JOptionPane.showMessageDialog(null,"Successfully logged in as " + user + " , Agent ID: " + aid);
							mainmenu.main(null);
							dispose();
						}

						else
							JOptionPane.showMessageDialog(null, "Username or password are incorrect.");

					}

					else {
						JOptionPane.showMessageDialog(null, "Username or password are incorrect.");
					}

				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		loginbt.setBackground(new Color(255, 255, 255));
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginbt.setBounds(264, 242, 85, 31);
		contentPane.add(loginbt);

		JLabel lblNewLabel_2 = new JLabel("Welcome! Please provide your username and password to access your account");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(10, 109, 686, 31);
		contentPane.add(lblNewLabel_2);
	}
}
