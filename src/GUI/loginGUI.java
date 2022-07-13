package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import BLL.accountBLL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import GUI.*;
public class loginGUI extends JFrame {
	
	accountBLL accBLL = new accountBLL();
    public JFrame f=new JFrame();
	private JPanel contentPane;
	private JTextField tfAccountName;
	private JPasswordField tfPass;
	private JLabel lAccountName;
	private JLabel lblMtKhu;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	static String code = null;
	static String permission = null;
	public static void main(String[] args) {
		new loginGUI();
	}

	/**
	 * Create the frame.
	 */
	public loginGUI() {
		setResizable(false);
		setTitle("\u0110\u0103ng nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(370, 150, 706, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -8, 309, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		f.setResizable(false);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 41, 309, 380);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("Image\\office-background-design_1300-381.jpg"));
		
		tfAccountName = new JTextField();
		tfAccountName.setBounds(359, 103, 281, 34);
		contentPane.add(tfAccountName);
		tfAccountName.setColumns(10);

		
		tfPass = new JPasswordField();
		tfPass.setColumns(10);
		tfPass.setBounds(359, 186, 281, 34);
		contentPane.add(tfPass);

		
		lAccountName = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lAccountName.setIcon(new ImageIcon("Image\\username-1-16.png"));
		lAccountName.setForeground(new Color(240, 255, 240));
		lAccountName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lAccountName.setBounds(359, 64, 157, 29);
		contentPane.add(lAccountName);
		
		lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u");
		lblMtKhu.setIcon(new ImageIcon("Image\\password-11-16.png"));
		lblMtKhu.setForeground(new Color(240, 255, 240));
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMtKhu.setBounds(359, 147, 125, 29);
		contentPane.add(lblMtKhu);
		
		f.add(contentPane);
		f.setBounds(370, 150, 706, 421);
		f.setVisible(true);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfAccountName.getText().equals("") || tfPass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng nhập"); 
				}
				else {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
						
						String sql = "SELECT * FROM account WHERE ACCOUNT_NAME = ? AND PASS = ?";
						PreparedStatement ps = connection.prepareStatement(sql);
						ps.setString(1, tfAccountName.getText());
						ps.setString(2, String.valueOf(tfPass.getPassword()));
						
						ResultSet rs = ps.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
							code = String.valueOf(accBLL.getId(tfAccountName.getText().toString()));
							permission = accBLL.getPermission(Integer.parseInt(code));
							if(permission.equals("Giám đốc")) {
								adminGUI index=new adminGUI();
							}
							else if(permission.equals("Quản trị hệ thống")) {
								quantriGUI quantri = new quantriGUI();
							}
							else if(permission.equals("Bác sĩ")) {
								doctorGUI bacsi = new doctorGUI(code);
							}
							else {
								employeeGUI nhanvien = new employeeGUI(code);
							}
							f.setVisible(false);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(359, 276, 281, 41);
		contentPane.add(btnNewButton);
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1.setForeground(Color.CYAN);
//		lblNewLabel_1.setBounds(359, 252, 174, 23);
//		contentPane.add(lblNewLabel_1);
	}
}
