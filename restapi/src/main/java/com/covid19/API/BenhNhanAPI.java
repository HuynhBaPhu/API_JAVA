package com.covid19.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.Entity.BenhNhan;
import com.covid19.Entity.ConNguoi;
import com.covid19.service.IBenhNhanService;

@RestController
public class BenhNhanAPI {

	@Autowired
	IBenhNhanService iBenhNhanService;
	
	@PostMapping("/benhnhan/add")
	public BenhNhan addBenhNhan(@RequestBody BenhNhan benhNhan, @RequestParam int  maCoSoYTe)
	{
		return iBenhNhanService.addBenhNhan(benhNhan, maCoSoYTe);
	}
	
	@GetMapping("/benhnhan/getallbenhnhan")
	public List<BenhNhan> getAllBenhNhan()
	{
		return iBenhNhanService.getAllBenhNhan();
	}
	
	@PutMapping("/benhnhan/updatebenhnhan")
	public Boolean updateBenhNhan(@RequestParam int maBN, @RequestBody BenhNhan benhNhan)
	{
		return iBenhNhanService.updateBenhNhan(maBN, benhNhan);
	}
	
//	@GetMapping("/benhnhan/getonebycmnd")
//	public BenhNhan getOneByCMND(@RequestParam String cmnd)
//	{
//		return iBenhNhanService.getBenhNhanCmnd(cmnd);
//	}
	
	@DeleteMapping("/benhnhan/deletebenhnhan")
	public Boolean deleteBenhNhan(@RequestParam int maBN)
	{
		return iBenhNhanService.deleteBenhNhan(maBN);
	}
	
	@PostMapping("/benhnhan/undobenhnhan")
	public Boolean UndoBenhNhan(@RequestBody BenhNhan benhNhan)
	{
		return iBenhNhanService.UndoBenhNhan(benhNhan);
	}
}
