package buoi5.bai2;

import java.io.Serializable;
import java.sql.*;

public class NhanVien implements Serializable {

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public Date getNgayVaoLamViec() {
		return ngayVaoLamViec;
	}

	public void setNgayVaoLamViec(Date ngayVaoLamViec) {
		this.ngayVaoLamViec = ngayVaoLamViec;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}

	public PhongBan getPhong() {
		return phong;
	}

	public void setPhong(PhongBan phong) {
		this.phong = phong;
	}

	private String maNhanVien;
	private String tenNhanVien;
	private Date ngayVaoLamViec;
	private Date namSinh;
	private PhongBan phong;

	public NhanVien(String maNhanVien, String tenNhanVien, Date ngayVaoLamViec, Date namSinh) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngayVaoLamViec = ngayVaoLamViec;
		this.namSinh = namSinh;
	}

	public NhanVien() {
	}

	public void setNgayVaoLamViec(java.util.Date parse) {
		// TODO Auto-generated method stub

	}

	public void setNamSinh(java.util.Date parse) {
		// TODO Auto-generated method stub

	}

}
