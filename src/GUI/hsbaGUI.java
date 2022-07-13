package GUI;

import java.awt.BorderLayout;
import base.*;
import DAL.*;
import BLL.*;
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
import base.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class hsbaGUI extends JFrame {
	List<hsba> hsbaList = new ArrayList<hsba>();
	hsbaBLL hsbaBLL = new hsbaBLL();
	khamBenhBLL kbBLL = new khamBenhBLL();
	
	private JPanel contentPane;
	private JTextField tfhsbaCode;
	private JTextField tfngaybd;
	private JTextField tfngaykt;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField tfketqua;
	public JFrame f = new JFrame();
	JComboBox  cbBacsi;
	List<String> bacsiList = hsbaBLL.getbacsiList();
	JComboBox  cbBenhnhan;
	List<String> benhnhanList = hsbaBLL.getbenhnhanList();
	JComboBox cbKetqua;
	String kq[] = {"Chữa khỏi","Không chữa khỏi"};
	
	public hsbaGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí hồ sơ bệnh án");
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
		
		JLabel lhsbaCode = new JLabel("Mã hồ sơ");
		lhsbaCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lhsbaCode.setForeground(Color.WHITE);
		lhsbaCode.setBounds(10, 42, 90, 28);
		panel.add(lhsbaCode);
		
		tfhsbaCode = new JTextField();
		tfhsbaCode.setBounds(110, 43, 209, 28);
		panel.add(tfhsbaCode);
		tfhsbaCode.setColumns(10);
		
		JLabel lngaybd = new JLabel("Ngày bắt đầu");
		lngaybd.setFont(new Font("SansSerif", Font.BOLD, 12));
		lngaybd.setForeground(Color.WHITE);
		lngaybd.setBounds(10, 87, 87, 28);
		panel.add(lngaybd);
		
		JLabel lngaykt = new JLabel("Ngày kết thúc");
		lngaykt.setForeground(Color.WHITE);
		lngaykt.setFont(new Font("SansSerif", Font.BOLD, 12));
		lngaykt.setBounds(10, 131, 90, 28);
		panel.add(lngaykt);
		
		tfngaybd = new JTextField();
		tfngaybd.setBounds(110, 88, 209, 28);
		panel.add(tfngaybd);
		tfngaybd.setColumns(10);
		
		tfngaykt = new JTextField();
		tfngaykt.setBounds(110, 133, 209, 28);
		panel.add(tfngaykt);
		tfngaykt.setColumns(10);
		
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
		
		cbKetqua = new JComboBox(kq);
		cbKetqua.setBounds(110, 185, 209, 28);
		panel.add(cbKetqua);
		
		JLabel lketqua = new JLabel("Kết quả");
		lketqua.setForeground(Color.WHITE);
		lketqua.setFont(new Font("SansSerif", Font.BOLD, 12));
		lketqua.setBounds(10, 183, 62, 28);
		panel.add(lketqua);
		
		JLabel lmabs = new JLabel("Tên bác sĩ");
		lmabs.setForeground(Color.WHITE);
		lmabs.setFont(new Font("SansSerif", Font.BOLD, 12));
		lmabs.setBounds(10, 239, 90, 28);
		panel.add(lmabs);
		
		cbBacsi = new JComboBox(bacsiList.toArray());
		cbBacsi.setBounds(110, 240, 209, 28);
		panel.add(cbBacsi);
		
		if(doctorGUI.doctorCode!=0) {
			String tenBacSi = kbBLL.getData1("bac_si", "TENBS", String.valueOf(doctorGUI.doctorCode), "MABS"); 
			cbBacsi.setSelectedItem(tenBacSi.toString());
			cbBacsi.setEnabled(false);
			btnEdit.setEnabled(false);
			btnRemove.setEnabled(false);
		}	
		
		JLabel lmabn = new JLabel("Tên bệnh nhân");
		lmabn.setForeground(Color.WHITE);
		lmabn.setFont(new Font("SansSerif", Font.BOLD, 12));
		lmabn.setBounds(10, 290, 90, 28);
		panel.add(lmabn);
		
		cbBenhnhan = new JComboBox(benhnhanList.toArray());
		cbBenhnhan.setBounds(110, 291, 209, 28);
		panel.add(cbBenhnhan);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 108, 1014, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã hồ sơ");
		model.addColumn("Ngày bắt đầu");
		model.addColumn("Ngày kết thúc");
		model.addColumn("Kết quả");
		model.addColumn("Mã bác sĩ điều trị");
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
		
		JLabel lDSNCC = new JLabel("Danh sách hồ sơ bệnh án");
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
		tfhsbaCode.setText("");
		tfngaybd.setText("");
		tfngaykt.setText("");
		cbKetqua.setSelectedIndex(0);
		cbBacsi.setSelectedIndex(0);
		cbBenhnhan.setSelectedIndex(0);
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfhsbaCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfngaybd.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfngaykt.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		cbKetqua.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		
    		String maBs = model.getValueAt(selectedIndex, 5).toString();
    		String tenBs = kbBLL.getData1("bac_si", "TENBS", maBs, "MABS");
    		cbBacsi.setSelectedItem(tenBs.toString());
    		
    		String maBn = model.getValueAt(selectedIndex, 6).toString();
    		String tenBn = kbBLL.getData1("benh_nhan", "TENBN", maBn, "MABN");
    		cbBenhnhan.setSelectedItem(tenBn.toString());
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfhsbaCode.getText().trim().equals("") && !tfngaybd.getText().trim().equals("")  && !tfngaykt.getText().trim().equals("")) {
			try {
				int code =  Integer.parseInt(tfhsbaCode.getText());
				String ngaybd = tfngaybd.getText();
				String ngaykt =tfngaykt.getText();
				String ketqua = (String) cbKetqua.getSelectedItem();
				
				String tenBn = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int mabn = kbBLL.getData("benh_nhan", "MABN", tenBn, "TENBN");
				
				String tenBs = String.valueOf(cbBacsi.getSelectedItem().toString());
				int mabs = kbBLL.getData("bac_si", "MABS", tenBs, "TENBS");
				
				hsba s=new hsba(code,ngaybd,ngaykt,ketqua,mabs,mabn);
				JOptionPane.showMessageDialog(null,hsbaBLL.addhsba(s));
				displayList();
				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của hồ sơ");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		String hsbaName = tfFind.getText();
        if(hsbaName != null && hsbaName.length() > 0) {
            hsbaList = hsbaBLL.searchhsbaByName(hsbaName);
            
            if(hsbaList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có hồ sơ bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < hsbaList.size()) {
	    			hsba p = hsbaList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getMahs() , p.getNgaybd(),p.getNgaykt(),p.getKetqua(),p.getTenbs(),p.getTenbn()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên hồ sơ cấp để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfhsbaCode.getText().trim().equals("") && !tfngaybd.getText().trim().equals("") && !tfngaykt.getText().trim().equals("")) {
				hsba p = new hsba();
				p.setMahs(Integer.parseInt(tfhsbaCode.getText()));
				p.setNgaybd(tfngaybd.getText());
				p.setNgaykt(tfngaykt.getText());
				p.setKetqua(cbKetqua.getSelectedItem().toString());
				
				String tenBenhNhan = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int mabn = kbBLL.getData("benh_nhan", "MABN", tenBenhNhan, "TENBN");
				p.setTenbn(mabn);
				
				String tenBs = String.valueOf(cbBacsi.getSelectedItem().toString());
				int mabs = kbBLL.getData("bac_si", "MABS", tenBs, "TENBS");
				p.setTenbs(mabs);
				
				JOptionPane.showMessageDialog(null, hsbaBLL.edithsba(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn hồ sơ để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của hồ sơ");
		}
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfhsbaCode.getText().equals("")) {
        	int code =  Integer.parseInt(tfhsbaCode.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa hồ sơ này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hồ sơ này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,hsbaBLL.deletehsba(code));
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn hồ sơ để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		hsbaList = hsbaBLL.getAllhsba();
    	int i = 0;
		while(i < hsbaList.size()) {
			hsba p = hsbaList.get(i);
			bienlai a = new bienlai();
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getMahs() , p.getNgaybd(),p.getNgaykt(),p.getKetqua(),p.getTenbs(),p.getTenbn()
			});
			i++;
		}
	}
}