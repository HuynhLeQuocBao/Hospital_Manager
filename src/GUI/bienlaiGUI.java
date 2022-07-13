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

import Dungchung.Tester;
import base.bienlai;
import BLL.benhnhanBLL;
import BLL.bienlaiBLL;
import BLL.khamBenhBLL;
import BLL.nhanvienBLL;
import DAL.bienlaiDAL;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class bienlaiGUI extends JFrame {
	List<bienlai> bienLaiList = new ArrayList<bienlai>();
	bienlaiBLL blBLL = new bienlaiBLL();
	khamBenhBLL kbBLL = new khamBenhBLL();
	
	private JPanel contentPane;
	private JTextField tfBienlai;
	private JTextField tfNgay;
	private JTextField tfTongtien;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	public JFrame f = new JFrame();
	private JComboBox cbNhanvien,cbBenhnhan;
	List<String> benhnhanList  = blBLL.getbenhnhanList();
	List<String> nhanvienList  = blBLL.getnhanvienList();
	public bienlaiGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí biên lai");
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
		
		JLabel lBienlai = new JLabel("Số biên lai");
		lBienlai.setFont(new Font("SansSerif", Font.BOLD, 12));
		lBienlai.setForeground(Color.WHITE);
		lBienlai.setBounds(10, 42, 90, 28);
		panel.add(lBienlai);
		
		tfBienlai = new JTextField();
		tfBienlai.setBounds(110, 43, 209, 28);
		panel.add(tfBienlai);
		tfBienlai.setColumns(10);
		
		JLabel lNgay = new JLabel("Ngày thanh toán");
		lNgay.setFont(new Font("SansSerif", Font.BOLD, 12));
		lNgay.setForeground(Color.WHITE);
		lNgay.setBounds(10, 87, 102, 28);
		panel.add(lNgay);
		
		JLabel lTongtien = new JLabel("Tổng tiền");
		lTongtien.setForeground(Color.WHITE);
		lTongtien.setFont(new Font("SansSerif", Font.BOLD, 12));
		lTongtien.setBounds(10, 131, 55, 28);
		panel.add(lTongtien);
		
		tfNgay = new JTextField();
		tfNgay.setBounds(110, 88, 209, 28);
		panel.add(tfNgay);
		tfNgay.setColumns(10);
		
		tfTongtien = new JTextField();
		tfTongtien.setBounds(110, 133, 209, 28);
		panel.add(tfTongtien);
		tfTongtien.setColumns(10);
		tfTongtien.setEditable(false);
		
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
		
		JLabel lManv = new JLabel("Tên nhân viên");
		lManv.setForeground(Color.WHITE);
		lManv.setFont(new Font("SansSerif", Font.BOLD, 12));
		lManv.setBounds(10, 177, 102, 28);
		panel.add(lManv);
		
		
		JLabel lMaBN = new JLabel("Tên bệnh nhân");
		lMaBN.setForeground(Color.WHITE);
		lMaBN.setFont(new Font("SansSerif", Font.BOLD, 12));
		lMaBN.setBounds(10, 226, 90, 28);
		panel.add(lMaBN);
		
		cbNhanvien = new JComboBox(nhanvienList.toArray());
		cbNhanvien.setBounds(110, 176, 209, 33);
		panel.add(cbNhanvien);
		
		if(employeeGUI.employeeCode!=-1) {
			String tenNhanVien = kbBLL.getData1("nhan_vien", "TENNV", String.valueOf(employeeGUI.employeeCode), "MANV"); 
			cbNhanvien.setSelectedItem(tenNhanVien.toString());
			cbNhanvien.setEnabled(false);
			btnEdit.setEnabled(false);
			btnRemove.setEnabled(false);
		}
		
		cbBenhnhan = new JComboBox(benhnhanList.toArray());
		cbBenhnhan.setBounds(110, 225, 209, 33);
		panel.add(cbBenhnhan);
		
		JButton btnPrice = new JButton("Tổng số tiền bệnh nhân phải trả");
		btnPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrice.setBounds(47, 334, 244, 42);
		panel.add(btnPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 108, 1014, 603);
		contentPane.add(scrollPane);
		btnPrice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnPriceActionPerformed(e);
			}
		});
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Số biên lai");
		model.addColumn("Ngày thanh toán");
		model.addColumn("Tổng tiền");
		model.addColumn("Mã nhân viên");
		model.addColumn("Mã bệnh nhân");
		
		
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
		
		JLabel lDSNCC = new JLabel("Biên lai");
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
		tfBienlai.setText("");
		tfNgay.setText("");
		tfTongtien.setText("");
		cbNhanvien.setSelectedIndex(0);
		cbBenhnhan.setSelectedIndex(0);
		
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfBienlai.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfNgay.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfTongtien.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		
    		String maNv = model.getValueAt(selectedIndex, 4).toString();
    		String tenNv = kbBLL.getData1("nhan_vien", "TENNV", maNv, "MANV");
    		cbNhanvien.setSelectedItem(tenNv.toString());
    		
    		String maBn = model.getValueAt(selectedIndex, 5).toString();
    		String tenBn = kbBLL.getData1("benh_nhan", "TENBN", maBn, "MABN");
    		cbBenhnhan.setSelectedItem(tenBn.toString());
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfBienlai.getText().trim().equals("") && !tfNgay.getText().trim().equals("") && !tfTongtien.getText().trim().equals("")) {
			try {
				int soBienLai =  Integer.parseInt(tfBienlai.getText());
				String ngayThanhToan = tfNgay.getText();
				double tongTien = Double.parseDouble(tfTongtien.getText());
				
				String tenNv = String.valueOf(cbNhanvien.getSelectedItem().toString());
				int maNV = kbBLL.getData("nhan_vien", "MANV", tenNv, "TENNV");
				
				String tenBn = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int maBN = kbBLL.getData("benh_nhan", "MABN", tenBn, "TENBN");
				
				Tester t = new Tester();
				if(!t.day(ngayThanhToan)) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
					return ;
				}
				bienlai s=new bienlai(soBienLai, ngayThanhToan, tongTien, maNV, maBN);				
				JOptionPane.showMessageDialog(null,blBLL.addBienlai(s));
				displayList();
				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của biên lai và nhấn vào nút tổng tiền để lấy số tiền của bệnh nhân");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		int benhNhanCode = Integer.parseInt(tfFind.getText());
        if(benhNhanCode>=0) {
        	bienLaiList = blBLL.searchBienlaiByCode(benhNhanCode);
            
            if(bienLaiList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có biên lai bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < bienLaiList.size()) {
	    			bienlai p = bienLaiList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getSoBienLai(), p.getNgayThanhToan(), p.getTongTien(), p.getMaNV(),p.getMaBN()
	    			});
	    			i++;
	    		}
            }
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên biên lai cấp để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfBienlai.getText().trim().equals("") && !tfNgay.getText().trim().equals("")) {
				int soBienLai =  Integer.parseInt(tfBienlai.getText());
				String ngayThanhToan = tfNgay.getText();
				double tongTien = Double.parseDouble(tfTongtien.getText());
				
				String tenNV = String.valueOf(cbNhanvien.getSelectedItem().toString());
				int maNV = kbBLL.getData("nhan_vien", "MANV", tenNV, "TENNV");
				
				String tenBenhNhan = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int maBN = kbBLL.getData("benh_nhan", "MABN", tenBenhNhan, "TENBN");
				
				bienlai p = new bienlai(soBienLai, ngayThanhToan, tongTien, maNV, maBN);
				JOptionPane.showMessageDialog(null, blBLL.editBienlai(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn biên lai để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của biên lai");
		}
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfBienlai.getText().equals("")) {
        	int code =  Integer.parseInt(tfBienlai.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa biên lai này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa biên lai này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,blBLL.deleteBienlai(code));
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn biên lai để xóa");
        }
	}
	
	private void btnPriceActionPerformed(ActionEvent e) {
        if(!cbBenhnhan.getSelectedItem().equals("")) {
        	String tenBenhNhan = String.valueOf(cbBenhnhan.getSelectedItem().toString());
			int maBN = kbBLL.getData("benh_nhan", "MABN", tenBenhNhan, "TENBN");
			
        	tfTongtien.setText(String.valueOf(blBLL.getPrice(maBN)));
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để lấy giá tiền");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		bienLaiList = blBLL.getAllBill();
    	int i = 0;
		while(i < bienLaiList.size()) {
			bienlai p = bienLaiList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getSoBienLai(), p.getNgayThanhToan(), p.getTongTien(), p.getMaNV(), p.getMaBN()
			});
			i++;
		}
		
	}
}