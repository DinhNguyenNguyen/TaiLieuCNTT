package buoi5.bai2;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import buoi1.Vidu.Main;

public class QuanLyNhanVienUI extends JFrame {

	
	
	
	JList<NhanVien> listNhanVien;
	JTextField txtMa, txtTen, txtNgayVaoLam, txtNamSinh, txtPB;
	JButton btnLuu, btnXoa, btnThoat;
	ArrayList<PhongBan> dsPhongBan;
	ArrayList<NhanVien> dsNhanVienTheoPhongBan;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	PhongBan pbSelected = null;
	NhanVien nvSelected = null;

	PhongBan Phongs[];
	JComboBox<PhongBan> cbPhong;

	public QuanLyNhanVienUI(String title) {
		super(title);

		addControls();
		addEvents();
		fakeData();
	}

	public void addEvents() {
		cbPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cbPhong.getSelectedIndex() == -1)
					return;

				pbSelected = (PhongBan) cbPhong.getSelectedItem();

				listNhanVien.setListData(pbSelected.getNhanViens());

			}
		});

		listNhanVien.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (listNhanVien.getSelectedIndex() == -1)
					return;

				nvSelected = listNhanVien.getSelectedValue();
				txtMa.setText(nvSelected.getMaNhanVien());
				txtTen.setText(nvSelected.getTenNhanVien());
				txtNamSinh.setText(sdf.format(nvSelected.getNamSinh()));
				txtNgayVaoLam.setText(sdf.format(nvSelected.getNgayVaoLamViec()));
			}
		});

		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuu();
			}
		});

		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoa();
			}
		});

		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	public void addControls() {

		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

		JPanel pnPhong = new JPanel();
		pnPhong.setLayout(new FlowLayout());
		cbPhong = new JComboBox<PhongBan>();
		cbPhong.setBounds(100, 50, 150, 20);
		JLabel lblPhong = new JLabel("Ch???n ph??ng: ");
		lblPhong.setBounds(50, 50, 80, 20);
		pnPhong.add(lblPhong);
		pnPhong.add(cbPhong);

		JPanel pnInfo = new JPanel();
		pnInfo.setLayout(new GridLayout(1, 2));

//		Khung ch???a danh s??ch
		JPanel pnDanhSach = new JPanel();
		Border borderDanhSach = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleDanhSach = BorderFactory.createTitledBorder(borderDanhSach, "Danh s??ch");
		titleDanhSach.setTitleColor(Color.RED);
		titleDanhSach.setTitleFont(new Font("VNI", Font.PLAIN, 16));
		titleDanhSach.setTitlePosition(TitledBorder.CENTER);
		pnDanhSach.setBorder(titleDanhSach);

		JPanel pnListDS = new JPanel();
		pnListDS.setLayout(new FlowLayout());
		listNhanVien = new JList<NhanVien>();
		listNhanVien.setBounds(50, 50, 100, 100);
		JScrollPane scListDS = new JScrollPane(listNhanVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnListDS.add(scListDS);
		pnDanhSach.add(pnListDS);

//		Khung ch???a th??ng tin chi ti???t
		JPanel pnDetailInfoBox = new JPanel();
		pnDetailInfoBox.setLayout(new BoxLayout(pnDetailInfoBox, BoxLayout.Y_AXIS));
		Border borderDetailBox = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleDetailBox = BorderFactory.createTitledBorder(borderDetailBox, "Th??ng tin chi ti???t");
		titleDetailBox.setTitleColor(Color.RED);
		titleDetailBox.setTitleFont(new Font("VNI", Font.PLAIN, 16));
		titleDetailBox.setTitlePosition(TitledBorder.CENTER);
		pnDetailInfoBox.setBorder(titleDetailBox);

//		M??
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new GridLayout(1, 2));
		
		JLabel lblMa = new JLabel("M?? :");
		lblMa.setForeground(Color.BLACK);
		lblMa.setSize(150, 180);
		lblMa.setFont(new Font("VNI", Font.PLAIN, 18));
		
		txtMa = new JTextField(30);
		txtMa.setSize(150, 180);
		txtMa.setFont(new Font("VNI", Font.PLAIN, 18));
		txtMa.setForeground(Color.GRAY);
		
		pnMa.add(lblMa);
		pnMa.add(txtMa);

//		T??n
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new GridLayout(1, 2));
		JLabel lblTen = new JLabel("T??n :");
		lblTen.setForeground(Color.BLACK);
		lblTen.setSize(150, 180);
		lblTen.setFont(new Font("VNI", Font.PLAIN, 18));
		txtTen = new JTextField(30);
		txtTen.setSize(150, 180);
		txtTen.setFont(new Font("VNI", Font.PLAIN, 18));
		txtTen.setForeground(Color.GRAY);
		pnTen.add(lblTen);
		pnTen.add(txtTen);

//		Ng??y v??o
		JPanel pnNgayVaoLam = new JPanel();
		pnNgayVaoLam.setLayout(new GridLayout(1, 2));
		JLabel lblNgayVaoLam = new JLabel("Ng??y v??o l??m :");
		lblNgayVaoLam.setForeground(Color.BLACK);
		lblNgayVaoLam.setSize(150, 180);
		lblNgayVaoLam.setFont(new Font("VNI", Font.PLAIN, 18));
		txtNgayVaoLam = new JTextField(30);
		txtNgayVaoLam.setSize(150, 180);
		txtNgayVaoLam.setFont(new Font("VNI", Font.PLAIN, 18));
		txtNgayVaoLam.setForeground(Color.GRAY);
		pnNgayVaoLam.add(lblNgayVaoLam);
		pnNgayVaoLam.add(txtNgayVaoLam);

//		N??m sinh
		JPanel pnNamSinh = new JPanel();
		pnNamSinh.setLayout(new GridLayout(1, 2));
		JLabel lblNamSinh = new JLabel("N??m sinh :");
		lblNamSinh.setForeground(Color.BLACK);
		lblNamSinh.setSize(150, 180);
		lblNamSinh.setFont(new Font("VNI", Font.PLAIN, 18));
		txtNamSinh = new JTextField(30);
		txtNamSinh.setSize(150, 180);
		txtNamSinh.setFont(new Font("VNI", Font.PLAIN, 18));
		txtNamSinh.setForeground(Color.GRAY);
		pnNamSinh.add(lblNamSinh);
		pnNamSinh.add(txtNamSinh);

		pnDetailInfoBox.add(pnMa);
		pnDetailInfoBox.add(pnTen);
		pnDetailInfoBox.add(pnNgayVaoLam);
		pnDetailInfoBox.add(pnNamSinh);

		pnInfo.add(pnDanhSach);
		pnInfo.add(pnDetailInfoBox);

//        Khung ch???a h??nh ?????ng
		JPanel pnActionBox = new JPanel();
		pnActionBox.setLayout(new BorderLayout());
		Border borderActionBox = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleActionBox = BorderFactory.createTitledBorder(borderActionBox, "Ch???c n??ng");
		titleActionBox.setTitleColor(Color.RED);
		titleActionBox.setTitleFont(new Font("VNI", Font.PLAIN, 16));
		titleActionBox.setTitlePosition(TitledBorder.CENTER);
		pnActionBox.setBorder(titleActionBox);

		JPanel pnAction = new JPanel();
		btnLuu = new JButton("L??u");
		btnXoa = new JButton("X??a");
		btnThoat = new JButton("Tho??t");

		pnAction.add(btnLuu);
		pnAction.add(btnXoa);
		pnAction.add(btnThoat);

		pnActionBox.add(pnAction, BorderLayout.EAST);

		pnMain.add(pnPhong, BorderLayout.NORTH);
		pnMain.add(pnInfo, BorderLayout.CENTER);
		pnMain.add(pnActionBox, BorderLayout.SOUTH);

		con.add(pnMain);
	}

	public void ShowWindow() {
		this.setSize(700, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void fakeData() {
		dsPhongBan = new ArrayList<PhongBan>();

		PhongBan phtgv = new PhongBan();
		phtgv.setMaPhong("p1");
		phtgv.setTenPhong("Ph??ng h???p t??c gi???ng vi??n");

		PhongBan pkd = new PhongBan();
		pkd.setMaPhong("p2");
		pkd.setTenPhong("Ph??ng Kinh Doanh");

		PhongBan pKt = new PhongBan();
		pKt.setMaPhong("p3");
		pKt.setTenPhong("Ph??ng k??? to??n");

		dsPhongBan.add(phtgv);
		dsPhongBan.add(pkd);
		dsPhongBan.add(pKt);

//		phtgv.themNhanVien(
//				new NhanVien("NV1", "B??i Th??? Di???m Trinh", new Date(2016/03/03), new Date(2016/03/03));
//		phtgv.themNhanVien(
//				new NhanVien("NV2", "Tr???n v??n B??nh", new Date(2015 - 1900, 1, 1), new Date(1992 - 1900, 1, 1)));
//		phtgv.themNhanVien(
//				new NhanVien("NV3", "V?? V??n Ph??c", new Date(2013 - 1900, 1, 1), new Date(1989 - 1900, 1, 1)));
//
//		pkd.themNhanVien(new NhanVien("NV4", "B??nh T???n T??i", new Date(2014 - 1900, 1, 1), new Date(1988 - 1900, 1, 1)));
//		pkd.themNhanVien(new NhanVien("NV5", "Mai L??? Chi", new Date(2014 - 1900, 1, 1), new Date(1988 - 1900, 1, 1)));
//
//		pKt.themNhanVien(new NhanVien("NV6", "Mai ????nh C???a", new Date(2014 - 1900, 1, 1), new Date(1988 - 1900, 1, 1)));
//		pKt.themNhanVien(new NhanVien("NV7", "C??ng T???ng T??n N??? T??? Th??? ????nh ??u", new Date(2015 - 1900, 1, 2),
//				new Date(1990 - 1900, 1, 1)));
//		
		for (PhongBan pb : dsPhongBan) {
			cbPhong.addItem(pb);
		}

	}

	protected void xuLyXoa() {
		if (nvSelected != null) {
			pbSelected.getNhanViens().remove(nvSelected);
			nvSelected = null;
			listNhanVien.setListData(pbSelected.getNhanViens());
		}
	}

	protected void xuLyLuu() {
		try {
			NhanVien nv = new NhanVien();

			nv.setMaNhanVien(txtMa.getText());
			nv.setTenNhanVien(txtTen.getText());
			nv.setNgayVaoLamViec(sdf.parse(txtNgayVaoLam.getText()));
			nv.setNamSinh(sdf.parse(txtNamSinh.getText()));

			if (pbSelected != null) {
				pbSelected.themNhanVien(nv);
				listNhanVien.setListData(pbSelected.getNhanViens());
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public static void main(String[] args) {
		new QuanLyNhanVienUI("NguyenDinhNguyen").ShowWindow();
	}
}
