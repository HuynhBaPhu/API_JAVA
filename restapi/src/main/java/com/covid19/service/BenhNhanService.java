package com.covid19.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid19.Entity.BenhNhan;
import com.covid19.Entity.CoSoYTe;
import com.covid19.Entity.ConNguoi;
import com.covid19.Entity.PhieuKhaiBaoYTe;
import com.covid19.Repository.BenhNhanRepository;
import com.covid19.Repository.CoSoYTeRepository;
import com.covid19.Repository.ConNguoiRepository;


@Service
public class BenhNhanService implements IBenhNhanService {

	
	@Autowired
	BenhNhanRepository benhNhanRepository;
	
	@Autowired
	CoSoYTeRepository coSoYTeRepository;
	
	@Autowired
	ConNguoiRepository conNguoiRepository;
	
	@Autowired
    EntityManager entityManager;
	
	@Override
	public BenhNhan addBenhNhan(BenhNhan benhNhan, int maCoYTe) {
		CoSoYTe coSoYTe = coSoYTeRepository.findOne(maCoYTe);
		benhNhan.setMaCSYT_BenhNhan(coSoYTe);
		benhNhanRepository.save(benhNhan);
		return benhNhan;
	}

	@Override
	public boolean updateBenhNhan(int maBN, BenhNhan benhNhan) {
		if( benhNhan != null)
		{
			//trả về con người từ bệnh nhân được tìm có mã bệnh nhân
			ConNguoi conNguoi = benhNhan.getCmnd_BenhNhan();
			BenhNhan bn = benhNhanRepository.findOne(maBN);
			ConNguoi cn = conNguoiRepository.findOne(bn.getCmnd_BenhNhan().getCmnd());
			if(cn != null || bn != null)
			{			
				bn.setNgayPhatHien(benhNhan.getNgayPhatHien());
				bn.setSoLanMac(benhNhan.getSoLanMac());
				bn.setSoMuiVacin(benhNhan.getSoMuiVacin());
				bn.setTrangThai(benhNhan.getTrangThai());
				
				cn.setDiaChi(conNguoi.getDiaChi());
				cn.setGioiTinh(conNguoi.getGioiTinh());
				cn.setHoTen(conNguoi.getHoTen());
				cn.setNgaySinh(conNguoi.getNgaySinh());
				cn.setSdt(conNguoi.getSdt());
				benhNhanRepository.save(bn);
				conNguoiRepository.save(cn);
			
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBenhNhan(int maBN) {
		BenhNhan bn = benhNhanRepository.findOne(maBN);
		
		if(bn != null)
		{
			benhNhanRepository.delete(bn);
			return true;
		}
		return false;
	}
	

	@Override
	public List<BenhNhan> getAllBenhNhan() {
		return benhNhanRepository.findAll();
	}

	@Override
	public BenhNhan getOneBenhNhan(int maBN) {
		return benhNhanRepository.findOne(maBN);
	}

//	@Override
//	public BenhNhan getBenhNhanCmnd(String cmnd)
//	{
//		return benhNhanRepository.findByCmnd_BenhNhan(cmnd);
//	}
	
	@Override
	public boolean UndoBenhNhan(BenhNhan benhNhan)
	{
		benhNhanRepository.save(benhNhan);
		return true;
	}
}
