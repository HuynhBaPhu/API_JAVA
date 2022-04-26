package com.covid19.service;

import java.util.List;

import com.covid19.Entity.BenhNhan;
import com.covid19.Entity.ConNguoi;
import com.covid19.Entity.PhieuKhaiBaoYTe;

public interface IBenhNhanService {

	public BenhNhan addBenhNhan(BenhNhan benhNhan, int maCoYTe);
	
	public boolean updateBenhNhan(int maBN, BenhNhan benhNhan);
	
	public boolean deleteBenhNhan(int maBN);
	
	public List<BenhNhan> getAllBenhNhan();
	
	public BenhNhan getOneBenhNhan(int maBN);
	
//	public BenhNhan getBenhNhanCmnd(String cmnd);
	
	public boolean UndoBenhNhan(BenhNhan benhNhan);
}
