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
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.swing.JFileChooser;

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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import BLL.benhnhanBLL;
import Dungchung.Tester;
import base.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class benhnhanGUI extends JFrame {
	List<benhnhan> benhnhanList = new ArrayList<benhnhan>();
	benhnhanBLL bnBLL = new benhnhanBLL();
	
	private JPanel contentPane;
	private JTextField tfbenhnhanCode;
	private JTextField tfbenhnhanName;
	private JTextField tfbenhnhanBirthday;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField tfBenhnhanAddress;
	private JTextField tfGioitinh;
	private JTextField tfSoGiuong;
	private JTextField tfSophong;
	public JFrame f = new JFrame();
	JComboBox  cbGioiTinh;
	String[] gioiTinhList = {"Nam", "Nữ", "Khác"};
	JComboBox  cbSogiuong;
	String[] sogiuongList = {"1", "2", "3", "4"};
	JComboBox  cbSophong;
	String[] soPhongList = {"1", "2", "3", "4", "5", "6"};
	public benhnhanGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí bệnh nhân");
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
		
		JLabel lbenhnhanCode = new JLabel("Mã bệnh nhân");
		lbenhnhanCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbenhnhanCode.setForeground(Color.WHITE);
		lbenhnhanCode.setBounds(10, 42, 90, 28);
		panel.add(lbenhnhanCode);
		
		tfbenhnhanCode = new JTextField();
		tfbenhnhanCode.setBounds(110, 43, 209, 28);
		panel.add(tfbenhnhanCode);
		tfbenhnhanCode.setColumns(10);
		
		JLabel lbenhnhanName = new JLabel("Tên bệnh nhân");
		lbenhnhanName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbenhnhanName.setForeground(Color.WHITE);
		lbenhnhanName.setBounds(10, 87, 87, 28);
		panel.add(lbenhnhanName);
		
		JLabel lbenhnhanBirthday = new JLabel("Ngày sinh");
		lbenhnhanBirthday.setForeground(Color.WHITE);
		lbenhnhanBirthday.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbenhnhanBirthday.setBounds(10, 131, 55, 28);
		panel.add(lbenhnhanBirthday);
		
		tfbenhnhanName = new JTextField();
		tfbenhnhanName.setBounds(110, 88, 209, 28);
		panel.add(tfbenhnhanName);
		tfbenhnhanName.setColumns(10);
		
		tfbenhnhanBirthday = new JTextField();
		tfbenhnhanBirthday.setBounds(110, 133, 209, 28);
		panel.add(tfbenhnhanBirthday);
		tfbenhnhanBirthday.setColumns(10);
		
		JButton btnEdit = new JButton("Sửa");
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
		
		tfBenhnhanAddress = new JTextField();
		tfBenhnhanAddress.setColumns(10);
		tfBenhnhanAddress.setBounds(110, 185, 209, 28);
		panel.add(tfBenhnhanAddress);
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
		JLabel lBenhnhanAddress = new JLabel("Địa chỉ");
		lBenhnhanAddress.setForeground(Color.WHITE);
		lBenhnhanAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lBenhnhanAddress.setBounds(10, 183, 62, 28);
		panel.add(lBenhnhanAddress);
		
		JLabel lGioitinh = new JLabel("Giới tính");
		lGioitinh.setForeground(Color.WHITE);
		lGioitinh.setFont(new Font("SansSerif", Font.BOLD, 12));
		lGioitinh.setBounds(10, 233, 55, 28);
		panel.add(lGioitinh);
		
		cbGioiTinh = new JComboBox(gioiTinhList);
		cbGioiTinh.setBounds(110, 235, 209, 28);
		panel.add(cbGioiTinh);
		
		cbSogiuong = new JComboBox(sogiuongList);
		cbSogiuong.setBounds(110, 290, 209, 28);
		panel.add(cbSogiuong);
		
		cbSophong = new JComboBox(soPhongList);
		cbSophong.setBounds(110, 341, 209, 28);
		panel.add(cbSophong);
		
		if(doctorGUI.doctorCode!=0) {
			btnRemove.setEnabled(false);
		}	
		
		JLabel lSoGiuong = new JLabel("Số giường");
		lSoGiuong.setForeground(Color.WHITE);
		lSoGiuong.setFont(new Font("SansSerif", Font.BOLD, 12));
		lSoGiuong.setBounds(10, 288, 90, 28);
		panel.add(lSoGiuong);
		
		JLabel lSophong = new JLabel("Số phòng");
		lSophong.setForeground(Color.WHITE);
		lSophong.setFont(new Font("SansSerif", Font.BOLD, 12));
		lSophong.setBounds(10, 339, 55, 28);
		panel.add(lSophong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 108, 1014, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã bệnh nhân");
		model.addColumn("Tên bệnh nhân");
		model.addColumn("Ngày sinh");
		model.addColumn("Địa chỉ");
		model.addColumn("Giới tính");
		model.addColumn("Số giường");
		model.addColumn("Số phòng");
		
		
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
		
		JLabel lDSNCC = new JLabel("Danh Sách Bệnh Nhân");
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
		if(employeeGUI.employeeCode!=-1) {
			btnRemove.setEnabled(false);
		}
		if(loginGUI.permission.equals("Quản trị hệ thống")) {
			btnRemove.setEnabled(true);
			btnEdit.setEnabled(true);
		}
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfbenhnhanCode.setText("");
		tfbenhnhanName.setText("");
		tfbenhnhanBirthday.setText("");
		tfBenhnhanAddress.setText("");
		cbGioiTinh.setSelectedIndex(0);
		cbSogiuong.setSelectedIndex(0);
		cbSophong.setSelectedIndex(0);
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfbenhnhanCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfbenhnhanName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfbenhnhanBirthday.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfBenhnhanAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		cbGioiTinh.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 5)));
    		cbSogiuong.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 6)));
    		cbSophong.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 7)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfbenhnhanCode.getText().trim().equals("") && !tfbenhnhanName.getText().trim().equals("") && !tfbenhnhanBirthday.getText().trim().equals("") && !tfBenhnhanAddress.getText().trim().equals("")) {
			try {
				int code =  Integer.parseInt(tfbenhnhanCode.getText());
				String name = tfbenhnhanName.getText();
				String birth =tfbenhnhanBirthday.getText();
				String address = tfBenhnhanAddress.getText();
				String gioitinh = cbGioiTinh.getSelectedItem().toString();
				int sogiuong =  Integer.parseInt(cbSogiuong.getSelectedItem().toString());
				int sophong =  Integer.parseInt(cbSophong.getSelectedItem().toString());
				Tester t = new Tester();
				if(!t.day(birth)) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
					return ;
				}
				benhnhan s=new benhnhan(code,name,birth,address,gioitinh,sogiuong,sophong);				
				JOptionPane.showMessageDialog(null,bnBLL.addbenhnhan(s));
				displayList();
				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bệnh nhân");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		String benhnhanName = tfFind.getText();
        if(benhnhanName != null && benhnhanName.length() > 0) {
            benhnhanList = bnBLL.searchbenhnhanByName(benhnhanName);
            
            if(benhnhanList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có bệnh nhân bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < benhnhanList.size()) {
	    			benhnhan p = benhnhanList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMabn(), p.getTenbn(), p.getNgaysinh(), p.getDiachi(),p.getGioitinh(), p.getSogiuong() ,p.getSophong()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên bệnh nhân cấp để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfbenhnhanCode.getText().trim().equals("") && !tfbenhnhanName.getText().trim().equals("") && !tfbenhnhanBirthday.getText().trim().equals("") && !tfBenhnhanAddress.getText().trim().equals("")) {
				benhnhan p = new benhnhan();
				p.setMabn(Integer.parseInt(tfbenhnhanCode.getText()));
				p.setTenbn(tfbenhnhanName.getText());
				p.setNgaysinh(tfbenhnhanBirthday.getText());
				p.setDiachi(tfBenhnhanAddress.getText());
				p.setGioitinh(cbGioiTinh.getSelectedItem().toString());
				p.setSogiuong(Integer.parseInt(cbSogiuong.getSelectedItem().toString()));
				p.setSophong(Integer.parseInt(cbSophong.getSelectedItem().toString()));
				if(!Tester.day(p.getNgaysinh())) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng của ngày");
					return;
				}
				JOptionPane.showMessageDialog(null, bnBLL.editbenhnhan(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của bệnh nhân");
		}
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfbenhnhanCode.getText().equals("")) {
        	int code =  Integer.parseInt(tfbenhnhanCode.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa bệnh nhân này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bệnh nhân này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,bnBLL.deletebenhnhan(code));
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		benhnhanList = bnBLL.getAllbenhnhan();
    	int i = 0;
		while(i < benhnhanList.size()) {
			benhnhan p = benhnhanList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMabn(), p.getTenbn(), p.getNgaysinh(), p.getDiachi(),p.getGioitinh(), p.getSogiuong() ,p.getSophong()
			});
			i++;
		}
		
	}
}