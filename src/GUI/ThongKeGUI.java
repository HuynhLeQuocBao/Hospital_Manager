package GUI;

import BUS.ThongKeBUS;
import DTO.ThongKeDTO;
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


import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class ThongKeGUI extends JFrame implements ActionListener{
	List<ThongKeDTO> benhnhanList = new ArrayList<ThongKeDTO>();
	
	private JPanel contentPane;
	private JTextField F_MaDV,F_MaBN,F_TenDV,F_Ngay,F_Gia;
        private JComboBox F_ThongKe;
        private JButton B_ThongKe;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	public JFrame f = new JFrame();
	
	public ThongKeGUI() {
		initComponent();
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
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 102));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 108, 344, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel MaBN = new JLabel("Mã bệnh nhân");
		MaBN.setFont(new Font("SansSerif", Font.BOLD, 12));
		MaBN.setForeground(Color.WHITE);
		MaBN.setBounds(10, 42, 90, 28);
		panel.add(MaBN);
		
		F_MaBN = new JTextField("BN");
		panel.add(F_MaBN);
		F_MaBN.setColumns(10);
		F_MaBN.setBounds(110, 43, 209, 28);
		
                JLabel MaDV = new JLabel("Mã Dịch Vụ ");
		MaDV.setFont(new Font("SansSerif", Font.BOLD, 12));
		MaDV.setForeground(Color.WHITE);;
		MaDV.setBounds(10, 87, 87, 28);
		panel.add(MaDV);
		
		JLabel TenDV = new JLabel("Tên Dịch Vụ");
		TenDV.setForeground(Color.WHITE);
		TenDV.setFont(new Font("SansSerif", Font.BOLD, 12));
		TenDV.setBounds(10, 131, 80, 28);
		panel.add(TenDV);
		
                F_MaDV = new JTextField("DV");
                F_MaDV.setColumns(10);
		F_MaDV.setBounds(110, 88, 209, 28);
		panel.add(F_MaDV);
		
		F_TenDV = new JTextField("Ten");
		F_TenDV.setBounds(110, 133, 209, 28);
		panel.add(F_TenDV);
		F_TenDV.setColumns(10);
		
                
		F_Ngay = new JTextField("Ngay");
		F_Ngay.setColumns(10);
		F_Ngay.setBounds(110, 185, 209, 28);
		panel.add(F_Ngay);
		
		JLabel Ngay = new JLabel("Ngày Bắt Đầu");
		Ngay.setForeground(Color.WHITE);
		Ngay.setFont(new Font("SansSerif", Font.BOLD, 12));
		Ngay.setBounds(10, 183, 100, 28);
		panel.add(Ngay);
		
		JLabel DG = new JLabel("Đơn giá ");
		DG.setForeground(Color.WHITE);
		DG.setFont(new Font("SansSerif", Font.BOLD, 12));
		DG.setBounds(10, 233, 55, 28);
		panel.add(DG);
		
		
		F_Gia = new JTextField("Gia");
		F_Gia.setColumns(10);
		F_Gia.setBounds(110, 235, 209, 28);
		panel.add(F_Gia);
		
                JLabel lThongKe=new JLabel("Thống kê theo");
                lThongKe.setForeground(Color.WHITE);
		lThongKe.setFont(new Font("SansSerif", Font.BOLD, 12));
		lThongKe.setBounds(10, 283, 100, 28);
                panel.add(lThongKe);
                
                String[] find={"Thống kê","Mã bệnh nhân","Mã Dịch Vụ","Tên Dịch Vụ","Đơn Giá"};
                F_ThongKe=new JComboBox(find);
		F_ThongKe.setBounds(110, 283, 209, 28);
		panel.add(F_ThongKe);
                
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 108, 1014, 603);
		contentPane.add(scrollPane);
		
                B_ThongKe = new JButton("Thống Kê");
                B_ThongKe.setBackground(new Color(227,84,39));
                B_ThongKe.setBounds(5,340,330,50);
                B_ThongKe.setForeground(Color.white);
                B_ThongKe.setFont(new Font("Serif",Font.BOLD, 17));
                B_ThongKe.setBorder(new BevelBorder(BevelBorder.RAISED));
                B_ThongKe.addActionListener(this);
                panel.add(B_ThongKe);
                
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã Bệnh Nhân");
		model.addColumn("Mã Dịch Vụ ");
		model.addColumn("Tên Dịch Vụ");
		model.addColumn("Ngày Bắt Đầu");
		model.addColumn("Đơn Giá");
		model.addColumn("Số Lần");
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
                table.getColumnModel().getColumn(6).setPreferredWidth(1);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            int i=table.getSelectedRow();
                            F_MaBN.setText((String) model.getValueAt(i, 1));
                            F_MaDV.setText((String) model.getValueAt(i, 2));
                            F_TenDV.setText((String) model.getValueAt(i, 3));
                            F_Ngay.setText((String) model.getValueAt(i, 4));
                            F_Gia.setText(String.valueOf(model.getValueAt(i, 5)));
			}
		});
		JButton btnTrLi = new JButton("Trở lại");
		btnTrLi.setBounds(10, 10, 91, 47);
		contentPane.add(btnTrLi);
		btnTrLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				adminGUI p = new adminGUI();
				p.f.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);
		
                btnDoc();
		Panel panel1 = new Panel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(0, 63, 1364, 48);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lDSNCC = new JLabel("Thống Kê Bệnh Nhân Sử Dụng Dịch Vụ ");
		lDSNCC.setForeground(Color.WHITE);
		lDSNCC.setFont(new Font("SansSerif", Font.BOLD, 26));
		lDSNCC.setBounds(452, 4, 600, 36);
		panel1.add(lDSNCC);
		
		

		
		f.add(contentPane);
		f.setSize(1366, 740);
		f.setVisible(true);
	}
	void btnDoc(){
            ThongKeBUS bus=new ThongKeBUS();
            if(ThongKeBUS.DSTK==null)
                bus.docDSHD();
            int count=0;
            model.setRowCount(0);
            for(ThongKeDTO d :ThongKeBUS.DSTK){
                Vector row=new Vector();
                row.add(count);
                row.add(d.MaBN);
                row.add(d.MaDV);
                row.add(d.TenDV);
                row.add(d.Ngay);
                row.add(d.Dongia);
                row.add(d.Solan);
                model.addRow(row);
                table.setModel(model);
                count++;
            }         
        }
        void btnTimkiemMaDV(){
            ThongKeBUS bus=new ThongKeBUS();
            ThongKeDTO h=bus.TiemKiemMaDV(F_MaDV.getText());
            if(h!=null){
                model.setRowCount(0);
                Vector row =new Vector();
                row.add("");
                row.add(h.getMaBN());
                row.add(h.getMaDV());
                row.add(h.getTenDV());
                row.add(h.getNgay());
                row.add(h.getDongia());
                row.add(h.getSolan());
                model.addRow(row);
                table.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(null,"Khong tim thay ma hoa don ");
            }
        }
        void btnTimkiemMaBN(){
            ThongKeBUS bus=new ThongKeBUS();
            ThongKeDTO h=bus.TiemKiemMaBN(F_MaBN.getText());
            if(h!=null){
                model.setRowCount(0);
                Vector row =new Vector();
                row.add("");
                row.add(h.getMaBN());
                row.add(h.getMaDV());
                row.add(h.getTenDV());
                row.add(h.getNgay());
                row.add(h.getDongia());
                row.add(h.getSolan());
                model.addRow(row);
                table.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(null,"Khong tim thay ma hoa don ");
            }
        }
        void btnTimkiemTenDV(){
            ThongKeBUS bus=new ThongKeBUS();
            ThongKeDTO h=bus.TiemKiemTenDV(F_TenDV.getText());
            if(h!=null){
                model.setRowCount(0);
                Vector row =new Vector();
                row.add("");
                row.add(h.getMaBN());
                row.add(h.getMaDV());
                row.add(h.getTenDV());
                row.add(h.getNgay());
                row.add(h.getDongia());
                row.add(h.getSolan());
                model.addRow(row);
                table.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(null,"Khong tim thay ma hoa don ");
            }
        }
        void btnTimkiemGia(){
            ThongKeBUS bus=new ThongKeBUS();
            ThongKeDTO h=bus.TiemKiemGia(Integer.valueOf(F_Gia.getText()));
            if(h!=null){
                model.setRowCount(0);
                Vector row =new Vector();
                row.add("");
                row.add(h.getMaBN());
                row.add(h.getMaDV());
                row.add(h.getTenDV());
                row.add(h.getNgay());
                row.add(h.getDongia());
                row.add(h.getSolan());
                model.addRow(row);
                table.setModel(model);
            }
            else{
                JOptionPane.showMessageDialog(null,"Khong tim thay ma hoa don ");
            }
        }
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(B_ThongKe)){
                System.out.println("vvvvvvvvv");
                if(F_ThongKe.getSelectedIndex()==1){
                    System.out.println("ddddddd^");
                    btnTimkiemMaBN();
                }
                else if(F_ThongKe.getSelectedIndex()==2){
                    btnTimkiemMaDV();
                }
                else if(F_ThongKe.getSelectedIndex()==3){
                    btnTimkiemTenDV();
                }
                else if(F_ThongKe.getSelectedIndex()==4){
                    btnTimkiemGia();
                }
            }
        }
}