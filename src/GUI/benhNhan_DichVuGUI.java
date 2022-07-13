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
import base.benhNhan_DichVu;
import BLL.benhNhan_DichVuBLL;
import BLL.dichvuBLL;
import BLL.khamBenhBLL;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class benhNhan_DichVuGUI extends JFrame {
	List<benhNhan_DichVu> list = new ArrayList<benhNhan_DichVu>();
	benhNhan_DichVuBLL blBLL = new benhNhan_DichVuBLL();
	khamBenhBLL kbBLL = new khamBenhBLL();
	dichvuBLL dvBLL = new dichvuBLL();
			
	private JPanel contentPane;
	private JTextField tfSophieusd;
	private JTextField tfNgaysd;
	private JTextField tfSoluong;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField tfMadv;
	private JTextField tfMabn;
	public JFrame f = new JFrame();
	
	JComboBox  cbBenhnhan;
	List<String> benhnhanList = kbBLL.getbenhnhanList();
	
	JComboBox  cbDichvu;
	List<String> dichvuList = dvBLL.getdichvuList();
	public benhNhan_DichVuGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Bệnh nhân - Dịch vụ");
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
		
		JLabel lSophieusd = new JLabel("Số phiếu sử dụng");
		lSophieusd.setFont(new Font("SansSerif", Font.BOLD, 12));
		lSophieusd.setForeground(Color.WHITE);
		lSophieusd.setBounds(10, 42, 111, 28);
		panel.add(lSophieusd);
		
		tfSophieusd = new JTextField();
		tfSophieusd.setBounds(110, 43, 209, 28);
		panel.add(tfSophieusd);
		tfSophieusd.setColumns(10);
		
		JLabel lNgaysd = new JLabel("Ngày sử dụng");
		lNgaysd.setFont(new Font("SansSerif", Font.BOLD, 12));
		lNgaysd.setForeground(Color.WHITE);
		lNgaysd.setBounds(10, 140, 103, 28);
		panel.add(lNgaysd);
		
		JLabel lSoluong = new JLabel("Số lượng dịch vụ");
		lSoluong.setForeground(Color.WHITE);
		lSoluong.setFont(new Font("SansSerif", Font.BOLD, 12));
		lSoluong.setBounds(10, 198, 103, 28);
		panel.add(lSoluong);
		
		tfNgaysd = new JTextField();
		tfNgaysd.setBounds(110, 140, 209, 28);
		panel.add(tfNgaysd);
		tfNgaysd.setColumns(10);
		
		tfSoluong = new JTextField();
		tfSoluong.setBounds(110, 198, 209, 28);
		panel.add(tfSoluong);
		tfSoluong.setColumns(10);
		
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
		
		JLabel lMadv = new JLabel("Tên dịch vụ");
		lMadv.setForeground(Color.WHITE);
		lMadv.setFont(new Font("SansSerif", Font.BOLD, 12));
		lMadv.setBounds(10, 255, 90, 28);
		panel.add(lMadv);
		
		cbDichvu = new JComboBox(dichvuList.toArray());
		cbDichvu.setBounds(110, 257, 209, 28);
		panel.add(cbDichvu);
		
		cbBenhnhan = new JComboBox(benhnhanList.toArray());
		cbBenhnhan.setBounds(110, 92, 209, 28);
		panel.add(cbBenhnhan);
		
		JLabel lMaBN = new JLabel("Tên bệnh nhân");
		lMaBN.setForeground(Color.WHITE);
		lMaBN.setFont(new Font("SansSerif", Font.BOLD, 12));
		lMaBN.setBounds(10, 90, 90, 28);
		panel.add(lMaBN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 108, 1014, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Số phiếu sử dụng");
		model.addColumn("Mã bệnh nhân");
		model.addColumn("Ngày sử dụng");
		model.addColumn("Số lượng dịch vụ");
		model.addColumn("Mã dịch vụ");
		
		
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
		
		JLabel lDSNCC = new JLabel("Bệnh nhân - Dịch vụ");
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
		if(employeeGUI.employeeCode!=-1) {
			btnRemove.setEnabled(false);
		}
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfSophieusd.setText("");
		tfNgaysd.setText("");
		tfSoluong.setText("");
		cbBenhnhan.setSelectedIndex(0);
		cbDichvu.setSelectedIndex(0);
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfSophieusd.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfNgaysd.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfSoluong.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		
    		String maDv = model.getValueAt(selectedIndex, 5).toString();
    		String tenDv = kbBLL.getData1("dich_vu", "TENDV", maDv, "MADV");
    		cbDichvu.setSelectedItem(tenDv.toString());
    		
    		String maBn = model.getValueAt(selectedIndex, 2).toString();
    		String tenBn = kbBLL.getData1("benh_nhan", "TENBN", maBn, "MABN");
    		cbBenhnhan.setSelectedItem(tenBn.toString());
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfSophieusd.getText().trim().equals("") && !tfNgaysd.getText().trim().equals("") && !tfSoluong.getText().trim().equals("")) {
			try {
				int soPhieuSD =  Integer.parseInt(tfSophieusd.getText());
				String ngaySD = String.valueOf(tfNgaysd.getText());
				int soluong = Integer.parseInt(tfSoluong.getText());
			
				String tenBn = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int maBN = kbBLL.getData("benh_nhan", "MABN", tenBn, "TENBN");
				
				String tenDv = String.valueOf(cbDichvu.getSelectedItem().toString());
				int maDV = kbBLL.getData("dich_vu", "MADV", tenDv, "TENDV");
				
				Tester t = new Tester();
				if(!t.day(ngaySD)) {
					JOptionPane.showMessageDialog(null, "Ngày không hợp lệ");
					return;
				}
				benhNhan_DichVu s = new benhNhan_DichVu(soPhieuSD, maBN, ngaySD, soluong, maDV);				
				JOptionPane.showMessageDialog(null,blBLL.addPhieu(s));
				displayList();
				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của biên lai");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		int bienLaiCode = Integer.parseInt(tfFind.getText());
        if(bienLaiCode > 0) {
        	list = blBLL.searchBienLaiByCode(bienLaiCode);
            
            if(list.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có biên lai bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < list.size()) {
	    			benhNhan_DichVu p = list.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getSphieuSD(), p.getMaBN(), p.getNgaySD(), p.getSoluongDV(), p.getMaDV()
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
			if(index>=0 && !tfSophieusd.getText().trim().equals("") && !tfNgaysd.getText().trim().equals("") && !tfSoluong.getText().trim().equals("")) {
				int soPhieuSD =  Integer.parseInt(tfSophieusd.getText());
				String ngaySD = tfNgaysd.getText();
				int soluong = Integer.parseInt(tfSoluong.getText());
				
				String tenBenhNhan = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int maBN = kbBLL.getData("benh_nhan", "MABN", tenBenhNhan, "TENBN");
				
				String tenDichvu = String.valueOf(cbDichvu.getSelectedItem().toString());
				int maDV = kbBLL.getData("dich_vu", "MADV", tenDichvu, "TENDV");
				
				benhNhan_DichVu s = new benhNhan_DichVu(soPhieuSD, maBN, ngaySD, soluong, maDV);		
				if(!Tester.day(s.getNgaySD())) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng của ngày");
					return;
				}
				JOptionPane.showMessageDialog(null, blBLL.editPhieu(s));
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
        if(selectedIndex >= 0 && !tfSophieusd.getText().equals("")) {
        	int code =  Integer.parseInt(tfSophieusd.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phiếu này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phiếu này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,blBLL.deletePhieu(code));
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		list = blBLL.getAllBill();
    	int i = 0;
		while(i < list.size()) {
			benhNhan_DichVu p = list.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getSphieuSD(), p.getMaBN(), p.getNgaySD(), p.getSoluongDV(), p.getMaDV()
			});
			i++;
		}
		
	}
}