package GUI;

import java.awt.BorderLayout;
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

public class khamBenhGUI extends JFrame {
	List<khambenh> khamBenhList = new ArrayList<khambenh>();
	khamBenhBLL kbBLL = new khamBenhBLL();
	
	
	private JPanel contentPane;
	private JTextField tfsophieukham;
	private JTextField tfngaykham;
	private JTextField tfmabenh;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField tfTrieutrung;
	private JTextField tfsophongkham;
	public JFrame f = new JFrame();
	JComboBox  cbBacsi;
	List<String> bacsiList = kbBLL.getbacsiList();
	JComboBox  cbBenhnhan;
	List<String> benhnhanList = kbBLL.getbenhnhanList();
	JComboBox cbMaBenh;
	List<String> maBenhList = kbBLL.getMabenh();
	public khamBenhGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí khám bệnh");
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
		
		JLabel lsophieukham = new JLabel("Số phiếu khám");
		lsophieukham.setFont(new Font("SansSerif", Font.BOLD, 12));
		lsophieukham.setForeground(Color.WHITE);
		lsophieukham.setBounds(10, 42, 90, 28);
		panel.add(lsophieukham);
		
		tfsophieukham = new JTextField();
		tfsophieukham.setBounds(110, 43, 209, 28);
		panel.add(tfsophieukham);
		tfsophieukham.setColumns(10);
		
		JLabel lngaykham = new JLabel("Ngày khám");
		lngaykham.setFont(new Font("SansSerif", Font.BOLD, 12));
		lngaykham.setForeground(Color.WHITE);
		lngaykham.setBounds(10, 87, 87, 28);
		panel.add(lngaykham);
		
		JLabel lmabenh = new JLabel("Tên bệnh");
		lmabenh.setForeground(Color.WHITE);
		lmabenh.setFont(new Font("SansSerif", Font.BOLD, 12));
		lmabenh.setBounds(10, 284, 55, 28);
		panel.add(lmabenh);
		
		tfngaykham = new JTextField();
		tfngaykham.setBounds(110, 88, 209, 28);
		panel.add(tfngaykham);
		tfngaykham.setColumns(10);
		
		cbMaBenh = new JComboBox(maBenhList.toArray());
		cbMaBenh.setBounds(110, 286, 209, 28);
		panel.add(cbMaBenh);
		
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
		
		JLabel lmabs = new JLabel("Tên bác sĩ");
		lmabs.setForeground(Color.WHITE);
		lmabs.setFont(new Font("SansSerif", Font.BOLD, 12));
		lmabs.setBounds(10, 183, 62, 28);
		panel.add(lmabs);
		
		JLabel lmabn = new JLabel("Tên bệnh nhân");
		lmabn.setForeground(Color.WHITE);
		lmabn.setFont(new Font("SansSerif", Font.BOLD, 12));
		lmabn.setBounds(10, 234, 90, 28);
		panel.add(lmabn);
		
		JLabel ltrieutrung = new JLabel("Triệu trứng");
		ltrieutrung.setForeground(Color.WHITE);
		ltrieutrung.setFont(new Font("SansSerif", Font.BOLD, 12));
		ltrieutrung.setBounds(10, 132, 90, 28);
		panel.add(ltrieutrung);
		
		tfTrieutrung = new JTextField();
		tfTrieutrung.setColumns(10);
		tfTrieutrung.setBounds(110, 134, 209, 28);
		panel.add(tfTrieutrung);
		
		tfsophongkham = new JTextField();
		tfsophongkham.setColumns(10);
		tfsophongkham.setBounds(110, 342, 209, 28);
		panel.add(tfsophongkham);
		
		JLabel lsophongkham = new JLabel("Chi phí khám");
		lsophongkham.setForeground(Color.WHITE);
		lsophongkham.setFont(new Font("SansSerif", Font.BOLD, 12));
		lsophongkham.setBounds(10, 341, 90, 28);
		panel.add(lsophongkham);
		
		cbBacsi = new JComboBox(bacsiList.toArray());
		cbBacsi.setBounds(110, 187, 209, 28);
		panel.add(cbBacsi);
		
		if(doctorGUI.doctorCode!=0) {
			String tenBacSi = kbBLL.getData1("bac_si", "TENBS", String.valueOf(doctorGUI.doctorCode), "MABS"); 
			cbBacsi.setSelectedItem(tenBacSi.toString());
			cbBacsi.setEnabled(false);
			btnRemove.setEnabled(false);
		}	
		
		cbBenhnhan= new JComboBox(benhnhanList.toArray());
		cbBenhnhan.setBounds(110, 234, 209, 28);
		panel.add(cbBenhnhan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(343, 108, 1021, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Số phiếu khám");
		model.addColumn("Ngày khám");
		model.addColumn("Triệu trứng");
		model.addColumn("Mã bác sĩ");
		model.addColumn("Mã bệnh nhân");
		model.addColumn("Mã bệnh");
		model.addColumn("Chi phí khám");

		
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
		
		JLabel lDSNCC = new JLabel("Danh Sách phiếu khám");
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
		tfsophieukham.setText("");
		tfngaykham.setText("");
		tfTrieutrung.setText("");
		cbBacsi.setSelectedIndex(0);
		cbBenhnhan.setSelectedIndex(0);
		cbMaBenh.setSelectedIndex(0);
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfsophieukham.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfngaykham.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfTrieutrung.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		
    		String maBs = model.getValueAt(selectedIndex, 4).toString();
    		String tenBs = kbBLL.getData1("bac_si", "TENBS", maBs, "MABS");
    		cbBacsi.setSelectedItem(tenBs.toString());
    		
    		String maBn = model.getValueAt(selectedIndex, 5).toString();
    		String tenBn = kbBLL.getData1("benh_nhan", "TENBN", maBn, "MABN");
    		cbBenhnhan.setSelectedItem(tenBn.toString());
    		
    		String maBenh = model.getValueAt(selectedIndex, 6).toString();
    		String tenBenh = kbBLL.getData1("benh", "TEN_BENH", maBenh, "MA_BENH");
    		cbMaBenh.setSelectedItem(String.valueOf(tenBenh));
    		
    		tfsophongkham.setText(String.valueOf(model.getValueAt(selectedIndex, 7)));
        }
	}
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfsophieukham.getText().trim().equals("") && !tfngaykham.getText().trim().equals("") && !tfTrieutrung.getText().trim().equals("") && !tfsophongkham.getText().trim().equals("")) {
			try {
				int sophieukham=  Integer.parseInt(tfsophieukham.getText());
				String ngaykham = tfngaykham.getText();
				String tenBenh = String.valueOf(cbMaBenh.getSelectedItem().toString());
				int mabenh = kbBLL.getData("benh", "MA_BENH", tenBenh, "TEN_BENH");
				Tester t = new Tester();
				if(!t.day(ngaykham)) {
					JOptionPane.showMessageDialog(null, "Ngày khám không hợp lệ");
					return ;
				}
				
				String tenBn = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int mabn = kbBLL.getData("benh_nhan", "MABN", tenBn, "TENBN");
				
				String tenBs = String.valueOf(cbBacsi.getSelectedItem().toString());
				int mabs = kbBLL.getData("bac_si", "MABS", tenBs, "TENBS");
				
				String trieutrung = tfTrieutrung.getText();
				int sophongkham =Integer.parseInt(tfsophongkham.getText());
				khambenh kb=new khambenh(sophieukham,ngaykham,trieutrung,mabs,mabn,mabenh,sophongkham);				
				JOptionPane.showMessageDialog(null,kbBLL.addkhamBenh(kb));
				displayList();
				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của phiếu khám");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		int maBenhNhan = Integer.parseInt(tfFind.getText());
        if(maBenhNhan >= 0) {
            khamBenhList = kbBLL.searchKhambenhs(maBenhNhan);
            
            if(khamBenhList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có phiếu khám bệnh bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < khamBenhList.size()) {
	    			khambenh p = khamBenhList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getSophieukham(), p.getNgaykham(), p.getTrieutrung(), p.getMabs(),p.getMabn(), p.getMabenh(),p.getSophongkham()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập số phiếu khám để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfsophieukham.getText().trim().equals("") && !tfngaykham.getText().trim().equals("") && !tfTrieutrung.getText().trim().equals("") && !tfsophongkham.getText().trim().equals("")) {
				khambenh p = new khambenh();
				
				p.setSophieukham(Integer.parseInt(tfsophieukham.getText()));
				p.setNgaykham(tfngaykham.getText());
				p.setTrieutrung(tfTrieutrung.getText());
				
				String tenBenh = String.valueOf(cbMaBenh.getSelectedItem().toString());
				int mabenh = kbBLL.getData("benh", "MA_BENH", tenBenh, "TEN_BENH");
				p.setMabenh(mabenh);
				
				String tenBenhNhan = String.valueOf(cbBenhnhan.getSelectedItem().toString());
				int mabn = kbBLL.getData("benh_nhan", "MABN", tenBenhNhan, "TENBN");
				p.setMabn(mabn);
				
				String tenBs = String.valueOf(cbBacsi.getSelectedItem().toString());
				int mabs = kbBLL.getData("bac_si", "MABS", tenBs, "TENBS");
				p.setMabs(mabs);
	
				p.setSophongkham(Integer.parseInt(tfsophongkham.getText()));
				
				JOptionPane.showMessageDialog(null, kbBLL.editkhambenh(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu khám để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của phiếu khám");
		}
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfsophieukham.getText().equals("")) {
        	int sophieu =  Integer.parseInt(tfsophieukham.getText());
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phiếu khám này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phiếu khám này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
            		JOptionPane.showMessageDialog(null,kbBLL.deletekhambenh(sophieu));
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu khám để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		khamBenhList = kbBLL.getAllkhamBenh();
    	int i = 0;
		while(i < khamBenhList.size()) {
			khambenh p = khamBenhList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getSophieukham(), p.getNgaykham(), p.getTrieutrung(), p.getMabs(),p.getMabn(), p.getMabenh(),p.getSophongkham()
			});
			i++;
		}
		
	}
}