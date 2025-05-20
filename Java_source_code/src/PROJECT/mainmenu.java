package PROJECT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JScrollBar;

public class mainmenu extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final int DO_NOTHIN_ON_CLOSE = 0;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainmenu frame = new mainmenu();
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
	public mainmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 357);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("System");
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Back to main");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainmenu.main(null);
			      dispose();  //to close the current screen 
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Logout");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","Press Yes or No",JOptionPane.YES_NO_OPTION);
				if(x == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Successfully logged out of the system");
					login.main(null);
				      dispose();					
				}
				else {
					System.out.println(" ");
				}
			
			}
								
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit System");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(DO_NOTHING_ON_CLOSE);;
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(64, 0, 64));
		separator.setBackground(new Color(0, 0, 0));
		menuBar.add(separator);
		
		JMenu mnNewMenu_1 = new JMenu("Customer Management");
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Customer");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_customer.main(null);
			      dispose();
				
				
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Remove Customer");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove_customer.main(null);
			      dispose();
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Update Customer Info  ");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_customer.main(null);
			     dispose();
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 255, 255));
		menuBar.add(separator_1);
		
		JMenu mnNewMenu_2 = new JMenu("Reservations");
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Make Reservation");
		mntmNewMenuItem_6.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        add_reservation.main(null);
		        dispose();
		    }
		});
		
		
		
		
		JMenuItem mntmDeleteReservation = new JMenuItem("Delete Reservation");
		mntmDeleteReservation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmDeleteReservation);
		mntmDeleteReservation.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        delete_reservation.main(null);
		        dispose();
		    }
		});
		

		
		JMenuItem mntmUpdateReservation = new JMenuItem("Update Reservation");
        mntmUpdateReservation.setFont(new Font("Segoe UI", Font.BOLD, 14));
        mnNewMenu_2.add(mntmUpdateReservation);
        mntmUpdateReservation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		update_reservation.main(null);
        		dispose();
        	
        }
        });
  
         
            
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Search Reservations");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {           
                search_reservations.main(null);
                dispose(); //closes the window 
            }
        });
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(255, 255, 255));
		menuBar.add(separator_2);
		
		JMenu mnNewMenu_3 = new JMenu("Trip Management");
		mnNewMenu_3.setForeground(new Color(0, 0, 0));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Add Trip");
		mntmNewMenuItem_8.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_3.add(mntmNewMenuItem_8);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       Trip_add.main(null);
		       dispose();

			}});

		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Update Trip");
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_3.add(mntmNewMenuItem_9);
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {   
            	trip_update.main(null);
            	dispose();
            	
            }
        });

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(255, 255, 255));
		menuBar.add(separator_3);
		
		JMenu mnNewMenu_4 = new JMenu("Reports");
		mnNewMenu_4.setForeground(new Color(0, 0, 0));
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Reservations Report");
		mntmNewMenuItem_10.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_4.add(mntmNewMenuItem_10);
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	reservations_report1.main(null);
		    	dispose();
		        
		    }
		});


		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Trips Report");
		mntmNewMenuItem_11.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_4.add(mntmNewMenuItem_11);
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trips_report1.main(null);
				dispose();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
