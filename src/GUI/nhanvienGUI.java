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
import BLL.nhanvienBLL;
import Dungchung.Tester;
import base.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class nhanvienGUI extends JFrame {
	List<nhanvien> nhanvienList = new ArrayList<nhanvien>();
	nhanvienBLL nvBLL = new nhanvienBLL();
	accountBLL aBLL = new accountBLL();
	
	private JPanel contentPane;
	private JTextField tfnhanvienCode;
	private JTextField tfnhanvienName;
	private JTextField tfnhanvienBirthday;
	private JTextField tfFind, tfAccountId;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField tfnhanvienAddress;
	JComboBox cbGioiTinh;
	String[] gioiTinhList = {"Nam", "Nữ", "Khác"}; 
	public JFrame f = new JFrame();
	
	public nhanvienGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí nhân viên");
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
		
		JLabel lnhanvienCode = new JLabel("Mã nhân viên");
		lnhanvienCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lnhanvienCode.setForeground(Color.WHITE);
		lnhanvienCode.setBounds(10, 42, 90, 28);
		panel.add(lnhanvienCode);
		
		tfnhanvienCode = new JTextField();
		tfnhanvienCode.setBounds(110, 43, 209, 28);
		panel.add(tfnhanvienCode);
		tfnhanvienCode.setColumns(10);
		
		JLabel lnhanvienName = new JLabel("Tên nhân viên");
		lnhanvienName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lnhanvienName.setForeground(Color.WHITE);
		lnhanvienName.setBounds(10, 87, 87, 28);
		panel.add(lnhanvienName);
		
		JLabel lbacsiACode = new JLabel("Mã tài khoản");
		lbacsiACode.setForeground(Color.WHITE);
		lbacsiACode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbacsiACode.setBounds(10, 300, 100, 28);
		panel.add(lbacsiACode);
		
		tfAccountId = new JTextField();
		tfAccountId.setBounds(110, 301, 209, 28);
		panel.add(tfAccountId);
		tfAccountId.setColumns(10);
		tfAccountId.setText(String.valueOf(aBLL.getAccountCode()));
		tfAccountId.setEditable(false);
		
		JLabel lnhanvienBirthday = new JLabel("Ngày sinh");
		lnhanvienBirthday.setForeground(Color.WHITE);
		lnhanvienBirthday.setFont(new Font("SansSerif", Font.BOLD, 12));
		lnhanvienBirthday.setBounds(10, 248, 55, 28);
		panel.add(lnhanvienBirthday);
		
		tfnhanvienName = new JTextField();
		tfnhanvienName.setBounds(110, 88, 209, 28);
		panel.add(tfnhanvienName);
		tfnhanvienName.setColumns(10);
		
		tfnhanvienBirthday = new JTextField();
		tfnhanvienBirthday.setBounds(110, 250, 209, 28);
		panel.add(tfnhanvienBirthday);
		tfnhanvienBirthday.setColumns(10);
		
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
		
		tfnhanvienAddress = new JTextField();
		tfnhanvienAddress.setColumns(10);
		tfnhanvienAddress.setBounds(110, 145, 209, 28);
		panel.add(tfnhanvienAddress);
		
		JLabel lnhanvienAddress = new JLabel("Địa chỉ");
		lnhanvienAddress.setForeground(Color.WHITE);
		lnhanvienAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lnhanvienAddress.setBounds(10, 143, 62, 28);
		panel.add(lnhanvienAddress);
		
		JLabel lGioitinh = new JLabel("Giới tính");
		lGioitinh.setForeground(Color.WHITE);
		lGioitinh.setFont(new Font("SansSerif", Font.BOLD, 12));
		lGioitinh.setBounds(10, 198, 55, 28);
		panel.add(lGioitinh);
		
		
		cbGioiTinh = new JComboBox(gioiTinhList);
		cbGioiTinh.setBounds(110, 200, 209, 28);
		panel.add(cbGioiTinh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 108, 1014, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
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
		
		JLabel lDSNCC = new JLabel("Danh Sách nhân viên");
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
		tfnhanvienCode.setText("");
		tfnhanvienName.setText("");
		tfnhanvienAddress.setText("");
		cbGioiTinh.setSelectedIndex(0);
		tfnhanvienBirthday.setText("");
		tfAccountId.setText(String.valueOf(aBLL.getAccountCode()));
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfnhanvienCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfnhanvienName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfnhanvienAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		tfnhanvienBirthday.setText(String.valueOf(model.getValueAt(selectedIndex, 5)));
    		tfAccountId.setText(String.valueOf(model.getValueAt(selectedIndex, 6)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfnhanvienCode.getText().trim().equals("") && !tfnhanvienName.getText().trim().equals("") && !tfnhanvienBirthday.getText().trim().equals("") && !tfnhanvienAddress.getText().trim().equals("")) {
			try {
				int accountCode = Integer.parseInt(tfAccountId.getText());
				int code =  Integer.parseInt(tfnhanvienCode.getText());
				String name = tfnhanvienName.getText();
				String birth =tfnhanvienBirthday.getText();
				Tester t = new Tester();
				if(!t.day(birth)) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
					return ;
				}
				String address = tfnhanvienAddress.getText();
				String gioitinh = cbGioiTinh.getSelectedItem().toString();
				nhanvien s=new nhanvien(accountCode, code,name,address,gioitinh,birth);				
				JOptionPane.showMessageDialog(null,nvBLL.addnhanvien(s));
				displayList();
				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của nhân viên");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		String nhanvienName = tfFind.getText();
        if(nhanvienName != null && nhanvienName.length() > 0) {
            nhanvienList = nvBLL.searchnhanvienByName(nhanvienName);
            
            if(nhanvienList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có nhân viên bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < nhanvienList.size()) {
	    			nhanvien p = nhanvienList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getManv(), p.getTennv(), p.getDiachi(),p.getGioitinh(),p.getNgaysinh(),p.getMaTK()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên cấp để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfnhanvienCode.getText().trim().equals("") && !tfnhanvienName.getText().trim().equals("") && !tfnhanvienBirthday.getText().trim().equals("") && !tfnhanvienAddress.getText().trim().equals("")) {
				nhanvien p = new nhanvien();
				p.setManv(Integer.parseInt(tfnhanvienCode.getText()));
				p.setTennv(tfnhanvienName.getText());
				p.setDiachi(tfnhanvienAddress.getText());
				p.setGioitinh(cbGioiTinh.getSelectedItem().toString());
				p.setNgaysinh(tfnhanvienBirthday.getText());
				if(!Tester.day(p.getNgaysinh())) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng của ngày");
					return ;
				}
				JOptionPane.showMessageDialog(null, nvBLL.editnhanvien(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của nhân viên");
		}
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfnhanvienCode.getText().equals("")) {
        	int code =  Integer.parseInt(tfnhanvienCode.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nhân viên này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,nvBLL.deletenhanvien(code));
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		nhanvienList = nvBLL.getAllnhanvien();
    	int i = 0;
		while(i < nhanvienList.size()) {
			nhanvien p = nhanvienList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getManv(), p.getTennv(), p.getDiachi(),p.getGioitinh(),p.getNgaysinh(),p.getMaTK()
			});
			i++;
		}
		
	}
}