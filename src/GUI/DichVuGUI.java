//package GUI;
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

import DAL.DALDichvu;
//import BLL.userBLL;
//import Users.*;
import GUI.*;
import base.dichvu;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class DichVuGUI extends JFrame {

//	List<Customer> UserList = new ArrayList<Customer>();
//	userBLL usrBLL = new userBLL();
	
	private JPanel contentPane;
	public JFrame f = new JFrame();
	private JTextField tfMadichvu;
	private JTextField tfTendichvu;
	private JTextField tfGia;
	private JTextField tfFind;
	private JComboBox cbDonvi;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	String kq[] = {"VNĐ","Dollar","Euro"};
	public DichVuGUI() {
		initComponent();
                getAllDichVu();
                
	}
        public void getAllDichVu()
        {
            ArrayList<dichvu> dichvuList = new DALDichvu().findAll();
            for (int i = 0; i < dichvuList.size(); i++) {
                model.addRow(new Object[]{
                    i,dichvuList.get(i).getMaDV(),dichvuList.get(i).getTenDV(),dichvuList.get(i).getDonGia()
                });
            }
        }
        public boolean xoa()
        {
            if(new DALDichvu().delete(tfMadichvu.getText()))
            {
                model.removeRow(table.getSelectedRow());
                return true;
                
            }
            
            return false;
        }
        public boolean sua()
        {
            if(new DALDichvu().update(new dichvu(Integer.parseInt(tfMadichvu.getText()),tfTendichvu.getText(),Float.parseFloat(tfGia.getText()))))
            {
                return true;
            }
            return false;
        }
        public boolean them()
        {
            dichvu dv = new dichvu(Integer.parseInt(tfMadichvu.getText()),tfTendichvu.getText(),Double.parseDouble(tfGia.getText()));
            if(new DALDichvu().insert(dv))
            {
                model.addRow(new Object[]{
                    model.getRowCount(),dv.getMaDV(),dv.getTenDV(),dv.getDonGia()
                });
                return true;
            }
            return false;
        }
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí dịch vụ");
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
		panel.setBounds(0, 108, 399, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Madichvu = new JLabel("Mã dịch vụ");
		Madichvu.setFont(new Font("SansSerif", Font.BOLD, 12));
		Madichvu.setForeground(Color.WHITE);
		Madichvu.setBounds(25, 42, 90, 28);
		panel.add(Madichvu);
		
		tfMadichvu = new JTextField();
		tfMadichvu.setBounds(125, 45, 209, 28);
		panel.add(tfMadichvu);
		tfMadichvu.setColumns(10);
		
		JLabel Tendichvu = new JLabel("Tên dịch vụ");
		Tendichvu.setFont(new Font("SansSerif", Font.BOLD, 12));
		Tendichvu.setForeground(Color.WHITE);
		Tendichvu.setBounds(24, 87, 101, 28);
		panel.add(Tendichvu);
		
		tfTendichvu = new JTextField();
		tfTendichvu.setBounds(125, 90, 209, 28);
		panel.add(tfTendichvu);
		tfTendichvu.setColumns(10);
		
		JLabel Gia = new JLabel("Giá");
		Gia.setFont(new Font("SansSerif", Font.BOLD, 12));
		Gia.setForeground(Color.WHITE);
		Gia.setBounds(25, 135, 55, 28);
		panel.add(Gia);
		
		tfGia = new JTextField();
		tfGia.setBounds(125, 135, 209, 28);
		panel.add(tfGia);
		tfGia.setColumns(10);
		
		JLabel Donvi = new JLabel("Đơn vị tính");
		Donvi.setForeground(Color.WHITE);
		Donvi.setFont(new Font("SansSerif", Font.BOLD, 12));
		Donvi.setBounds(25, 182, 90, 28);
		panel.add(Donvi);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnEdit.setBounds(218, 282, 69, 28);
		panel.add(btnEdit);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(320, 282, 69, 28);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRemoveActionPerformed(e);
			}
		});
		btnRemove.setBounds(10, 282, 69, 28);
		panel.add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(113, 282, 75, 28);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   btnResetActionPerformed(e);
			}
                    
		});
		JComboBox cbDonvi = new JComboBox(kq);
		cbDonvi.setBounds(124, 187, 210, 28);
		panel.add(cbDonvi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 108, 961, 603);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã dịch vụ");
		model.addColumn("Tên dịch vụ");
		model.addColumn("Giá");
		model.addColumn("Đơn vị tính");
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
		
		JLabel lbTitle = new JLabel("Danh Sách Dịch Vụ");
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setFont(new Font("SansSerif", Font.BOLD, 26));
		lbTitle.setBounds(315, 6, 372, 36);
		panel1.add(lbTitle);
		
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
//				f.setVisible(false);
//				adminGUI p = new adminGUI();
//				p.f.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				btnEditActionPerformed(e);
			}
		});
		f.add(contentPane);
		f.setSize(1366, 740);
		f.setVisible(true);
	}
	
	
        private void btnRemoveActionPerformed(ActionEvent e) {
            this.xoa();
	}
        private void btnAddActionPerformed(ActionEvent e) {
            this.them();
	}
	private void btnResetActionPerformed(ActionEvent e) {
		tfMadichvu.setText("");
		tfTendichvu.setText("");
		cbDonvi.setSelectedIndex(0);
		tfGia.setText("");
                System.out.println("asdsad");
   
	}
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfMadichvu.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfTendichvu.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfGia.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		cbDonvi.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 4)));
        }
	}

}