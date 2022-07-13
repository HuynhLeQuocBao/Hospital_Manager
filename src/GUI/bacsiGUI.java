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
import BLL.bacsiBLL;
import Dungchung.Tester;
import base.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class bacsiGUI extends JFrame {
	List<bacsi> bacsiList = new ArrayList<bacsi>();
	bacsiBLL bsBLL = new bacsiBLL();
	accountBLL aBLL = new accountBLL();
	
	private JPanel contentPane;
	private JTextField tfbacsiCode;
	private JTextField tfbacsiName;
	private JTextField tfbacsiBirthday;
	private JTextField tfFind, tfAccountId;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField tfbacsiAddress;
	private JTextField tfDienthoai;
	public JFrame f = new JFrame();
	JComboBox cbGioiTinh;
	String[] gioiTinhList = {"Nam", "Nữ", "Khác"}; 
	
	public bacsiGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí bác sĩ");
		setSize(1366, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 102));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 108, 344, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbacsiCode = new JLabel("Mã bác sĩ");
		lbacsiCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbacsiCode.setForeground(Color.WHITE);
		lbacsiCode.setBounds(10, 42, 90, 28);
		panel.add(lbacsiCode);
		
		tfbacsiCode = new JTextField();
		tfbacsiCode.setBounds(110, 43, 209, 28);
		panel.add(tfbacsiCode);
		tfbacsiCode.setColumns(10);
		
		JLabel lbacsiName = new JLabel("Tên bác sĩ");
		lbacsiName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbacsiName.setForeground(Color.WHITE);
		lbacsiName.setBounds(10, 87, 87, 28);
		panel.add(lbacsiName);
		
		JLabel lbacsiBirthday = new JLabel("Ngày sinh");
		lbacsiBirthday.setForeground(Color.WHITE);
		lbacsiBirthday.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbacsiBirthday.setBounds(10, 290, 55, 28);
		panel.add(lbacsiBirthday);
		
		JLabel lbacsiACode = new JLabel("Mã tài khoản");
		lbacsiACode.setForeground(Color.WHITE);
		lbacsiACode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbacsiACode.setBounds(10, 350, 100, 28);
		panel.add(lbacsiACode);
		
		tfAccountId = new JTextField();
		tfAccountId.setBounds(110, 351, 209, 28);
		panel.add(tfAccountId);
		tfAccountId.setColumns(10);
		tfAccountId.setText(String.valueOf(aBLL.getAccountCode()));
		tfAccountId.setEditable(false);
		
		tfbacsiName = new JTextField();
		tfbacsiName.setBounds(110, 88, 209, 28);
		panel.add(tfbacsiName);
		tfbacsiName.setColumns(10);
		
		tfbacsiBirthday = new JTextField();
		tfbacsiBirthday.setBounds(110, 292, 209, 28);
		panel.add(tfbacsiBirthday);
		tfbacsiBirthday.setColumns(10);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(179, 472, 69, 28);
		panel.add(btnEdit);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(265, 472, 69, 28);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRemoveActionPerformed(e);
			}
		});
		btnRemove.setBounds(100, 472, 69, 28);
		panel.add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(10, 472, 75, 28);
		panel.add(btnReset);
		
		tfbacsiAddress = new JTextField();
		tfbacsiAddress.setColumns(10);
		tfbacsiAddress.setBounds(110, 185, 209, 28);
		panel.add(tfbacsiAddress);
		
		JLabel lbacsiAddress = new JLabel("Địa chỉ");
		lbacsiAddress.setForeground(Color.WHITE);
		lbacsiAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbacsiAddress.setBounds(10, 183, 62, 28);
		panel.add(lbacsiAddress);
		
		JLabel lGioitinh = new JLabel("Giới tính");
		lGioitinh.setForeground(Color.WHITE);
		lGioitinh.setFont(new Font("SansSerif", Font.BOLD, 12));
		lGioitinh.setBounds(10, 233, 55, 28);
		panel.add(lGioitinh);
		
		
		cbGioiTinh = new JComboBox(gioiTinhList);
		cbGioiTinh.setBounds(110, 235, 209, 28);
		panel.add(cbGioiTinh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setForeground(Color.WHITE);
		lblSinThoi.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSinThoi.setBounds(10, 132, 90, 28);
		panel.add(lblSinThoi);
		
		tfDienthoai = new JTextField();
		tfDienthoai.setColumns(10);
		tfDienthoai.setBounds(110, 134, 209, 28);
		panel.add(tfDienthoai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 108, 1014, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã bác sĩ");
		model.addColumn("Tên bác sĩ");
		model.addColumn("Số điện thoại");
		model.addColumn("Địa chỉ");
		model.addColumn("Giới tính");
		model.addColumn("Ngày sinh");
		model.addColumn("Mã tài khoản");
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		Panel panel1 = new Panel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(0, 63, 1364, 48);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lDSNCC = new JLabel("Danh Sách bác sĩ");
		lDSNCC.setForeground(Color.WHITE);
		lDSNCC.setFont(new Font("SansSerif", Font.BOLD, 26));
		lDSNCC.setBounds(342, 4, 350, 36);
		panel1.add(lDSNCC);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setBounds(1252, 12, 90, 28);
		panel1.add(btnSearch);
		
		tfFind = new JTextField();
		tfFind.setBounds(1010, 12, 243, 28);
		panel1.add(tfFind);
		tfFind.setColumns(10);
		JButton btnTrLi = new JButton("Trở lại");
		btnTrLi.setBounds(10, 10, 91, 47);
		contentPane.add(btnTrLi);
		btnTrLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginGUI.permission.equals("Giám đốc")) {
					adminGUI p = new adminGUI();
					p.f.setVisible(true);
				}
				else if(loginGUI.permission.equals("Quản trị hệ thống")) {
					quantriGUI p = new quantriGUI();
					p.f.setVisible(true);
				}
				else if(loginGUI.permission.equals("Bác sĩ")) {
					doctorGUI p = new doctorGUI(loginGUI.code);
					p.f.setVisible(true);
				}
				else {
					employeeGUI p = new employeeGUI(loginGUI.code);
					p.f.setVisible(true);;
				}
				f.setVisible(false);
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditActionPerformed(e);
			}
		});
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnResetActionPerformed(e);
			}
		});
		f.add(contentPane);
		f.setSize(1366, 740);
		f.setVisible(true);
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfbacsiCode.setText("");
		tfbacsiName.setText("");
		tfDienthoai.setText("");
		tfbacsiAddress.setText("");
		cbGioiTinh.setSelectedIndex(0);
		tfbacsiBirthday.setText("");
		tfAccountId.setText(String.valueOf(aBLL.getAccountCode()));
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfbacsiCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfbacsiName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfDienthoai.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfbacsiAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
            cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 5)));
    		tfbacsiBirthday.setText(String.valueOf(model.getValueAt(selectedIndex, 6)));
    		tfAccountId.setText(String.valueOf(model.getValueAt(selectedIndex, 7)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfbacsiCode.getText().trim().equals("") && !tfbacsiName.getText().trim().equals("") && !tfbacsiBirthday.getText().trim().equals("") && !tfbacsiAddress.getText().trim().equals("")&& !tfDienthoai.getText().trim().equals("")) {
			try {
				int accCode = Integer.parseInt(tfAccountId.getText());
				int code =  Integer.parseInt(tfbacsiCode.getText());
				String name = tfbacsiName.getText();
				String birth =tfbacsiBirthday.getText();
				Tester t = new Tester();
				if(!t.day(birth)) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
					return ;
				}
				String address = tfbacsiAddress.getText();
				String gioitinh = cbGioiTinh.getSelectedItem().toString();
				String dienthoai = tfDienthoai.getText();
				if(!t.numberPhone(dienthoai)) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
					return ;
				}
				bacsi s=new bacsi(accCode, code,name,dienthoai,address,gioitinh,birth);				
				JOptionPane.showMessageDialog(null,bsBLL.addbacsi(s));
				displayList();
				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bác sĩ");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		String bacsiName = tfFind.getText();
        if(bacsiName != null && bacsiName.length() > 0) {
            bacsiList = bsBLL.searchbacsiByName(bacsiName);
            
            if(bacsiList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có bác sĩ bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < bacsiList.size()) {
	    			bacsi p = bacsiList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMabs(), p.getTenbs(), p.getDienthoai(), p.getDiachi(),p.getGioitinh(), p.getNgaysinh(), p.getMaTK()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên bác sĩ cấp để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfbacsiCode.getText().trim().equals("") && !tfbacsiName.getText().trim().equals("") && !tfbacsiBirthday.getText().trim().equals("") && !tfbacsiAddress.getText().trim().equals("")&& !tfDienthoai.getText().trim().equals("")) {
				bacsi p = new bacsi();
				p.setMabs(Integer.parseInt(tfbacsiCode.getText()));
				p.setTenbs(tfbacsiName.getText());
				p.setDienthoai(tfDienthoai.getText());
				p.setDiachi(tfbacsiAddress.getText());
				p.setGioitinh(cbGioiTinh.getSelectedItem().toString());
				p.setNgaysinh(tfbacsiBirthday.getText());
				JOptionPane.showMessageDialog(null, bsBLL.editbacsi(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn bác sĩ để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bác sĩ");
		}
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfbacsiCode.getText().equals("")) {
        	int code =  Integer.parseInt(tfbacsiCode.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa bác sĩ này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bác sĩ này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,bsBLL.deletebacsi(code));
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn bác sĩ để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		bacsiList = bsBLL.getAllbacsi();
    	int i = 0;
		while(i < bacsiList.size()) {
			bacsi p = bacsiList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMabs(), p.getTenbs(), p.getDienthoai(), p.getDiachi(),p.getGioitinh(),p.getNgaysinh(),p.getMaTK()
			});
			i++;
		}
		
	}
}