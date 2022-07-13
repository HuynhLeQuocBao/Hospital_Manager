package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BLL.accountBLL;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;
import GUI.*;

public class doctorGUI extends JFrame {
	private JPanel contentPane;
	public JFrame f = new JFrame();
	static int doctorCode = 0;
	accountBLL accBLL = new accountBLL();
	public doctorGUI(String code) {
		doctorCode = accBLL.getCode("bac_si", "MABS", code, "MA_TK");
		initComponent();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Trang admin");
		setSize(1300, 727);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 139, 277, 195);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnUser = new JButton("Tạo phiếu khám bệnh");
		btnUser.setIcon(new ImageIcon("Image\\create-1-32.png"));
		btnUser.setForeground(new Color(0, 0, 0));
		btnUser.setBackground(new Color(230, 230, 250));
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUser.setBounds(0, 65, 277, 64);
		panel.add(btnUser);
		
		btnUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				khamBenhGUI u = new khamBenhGUI();
			}
		} );
		
		/*JButton btnProduct = new JButton("Danh sách nhân viên");
		btnProduct.setIcon(new ImageIcon("Image\\paper-6-32.png"));
		btnProduct.setForeground(Color.BLACK);
		btnProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProduct.setBackground(new Color(230, 230, 250));
		btnProduct.setBounds(0, 120, 277, 64);
		panel.add(btnProduct);
		
		btnProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				nhanvienGUI u = new nhanvienGUI();
				u.f.setVisible(true);
			}
		} );
		
		JButton btnAccount = new JButton("Điều trị bệnh");
		btnAccount.setIcon(new ImageIcon("Image\\sick-2-32.png"));
		btnAccount.setForeground(Color.BLACK);
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAccount.setBackground(new Color(230, 230, 250));
		btnAccount.setBounds(0, 300, 277, 64);
		panel.add(btnAccount);
		
		btnAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				benhNhan_DichVuGUI u = new benhNhan_DichVuGUI();
				u.f.setVisible(true);
			}
		} );
		*/
		JButton btnEnterCoupon = new JButton("Danh sách bệnh nhân");
		btnEnterCoupon.setIcon(new ImageIcon("Image\\paper-6-32.png"));
		btnEnterCoupon.setForeground(Color.BLACK);
		btnEnterCoupon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEnterCoupon.setBackground(new Color(230, 230, 250));
		btnEnterCoupon.setBounds(0, 0, 277, 64);
		panel.add(btnEnterCoupon);
		JButton btnHSBnh = new JButton("Hồ sơ bệnh án");
		btnHSBnh.setBounds(0, 129, 277, 64);
		panel.add(btnHSBnh);
		btnHSBnh.setIcon(new ImageIcon("Image\\bill-12-32.png"));
		btnHSBnh.setForeground(Color.BLACK);
		btnHSBnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHSBnh.setBackground(new Color(230, 230, 250));
		btnHSBnh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				hsbaGUI u = new hsbaGUI();
				u.f.setVisible(true);
			}
		});
		
		btnEnterCoupon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				benhnhanGUI u = new benhnhanGUI();
				u.f.setVisible(true);
			}
		} );
		/*
		JButton btnBill = new JButton("Danh sách bác sĩ");
		btnBill.setIcon(new ImageIcon("Image\\paper-6-32.png"));
		btnBill.setForeground(Color.BLACK);
		btnBill.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBill.setBackground(new Color(230, 230, 250));
		btnBill.setBounds(0, 60, 277, 64);
		panel.add(btnBill);
		
		btnBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				bacsiGUI u = new bacsiGUI();
				u.f.setVisible(true);
			}
		} );
		
		JButton btnSupplier = new JButton("Danh sách tài khoản");
		btnSupplier.setIcon(new ImageIcon("Image\\paper-6-32.png"));
		btnSupplier.setForeground(Color.BLACK);
		btnSupplier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSupplier.setBackground(new Color(230, 230, 250));
		btnSupplier.setBounds(0, 180, 277, 64);
		panel.add(btnSupplier);
		
		btnSupplier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				accountGUI u = new accountGUI();
				u.f.setVisible(true);
			}
		} );
		
		JButton btnEmployee = new JButton("Thanh toán");
		btnEmployee.setIcon(new ImageIcon("Image\\money-48-32.png"));
		btnEmployee.setForeground(Color.BLACK);
		btnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEmployee.setBackground(new Color(230, 230, 250));
		btnEmployee.setBounds(0, 360, 277, 64);
		panel.add(btnEmployee);
		
		btnEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				bienlaiGUI u = new bienlaiGUI();
				u.f.setVisible(true);
			}
		} );
		
		JButton btnStatistic = new JButton("Báo cáo");
		btnStatistic.setIcon(new ImageIcon("Image\\statistic-2-32.png"));
		btnStatistic.setForeground(Color.BLACK);
		btnStatistic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStatistic.setBackground(new Color(230, 230, 250));
		btnStatistic.setBounds(0, 420, 277, 64);
		panel.add(btnStatistic);
		btnStatistic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				BaoCaoGUI u = new BaoCaoGUI();
				u.f.setVisible(true);
			}
		} );*/
		Panel panel1 = new Panel();
		panel1.setBackground(new Color(50, 205, 50));
		panel1.setBounds(0, 0, 1286, 140);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lblCaHngin = new JLabel("Hệ thống quản lí bệnh nhân trong bệnh viện");
		lblCaHngin.setBounds(250, 28, 1005, 91);
		panel1.add(lblCaHngin);
		lblCaHngin.setForeground(new Color(240, 248, 255));
		lblCaHngin.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblCaHngin.setBackground(new Color(175, 238, 238));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Image\\hospital-28-128.png"));
		lblNewLabel.setBounds(26, 10, 128, 128);
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Chào BÁC SĨ");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblNewLabel_1.setBounds(646, 139, 366, 111);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Đăng xuất");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton.setIcon(new ImageIcon("Image\\logout-7-32.png"));
		btnNewButton.setBounds(1107, 148, 173, 40);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				loginGUI u = new loginGUI();
				u.f.setVisible(true);
			}
		});
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Image\\doctor-15-256.png"));
		lblNewLabel_2.setBounds(616, 262, 300, 300);
		contentPane.add(lblNewLabel_2);
		
		/*JButton btnStatistic_1 = new JButton("Báo cáo");
		btnStatistic_1.setForeground(Color.BLACK);
		btnStatistic_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStatistic_1.setBackground(new Color(230, 230, 250));
		btnStatistic_1.setBounds(0, 480, 277, 64);
		contentPane.add(btnStatistic_1);
		*/
		f.add(contentPane);
		f.setSize(1300, 727);
		f.setResizable(false);
		f.setVisible(true);
	}
}