package com.covid19.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covid19.Entity.CoSoYTe;

@Repository
public interface CoSoYTeRepository extends JpaRepository<CoSoYTe, Integer> {

	@Query("select u from CoSoYTe u where u.diaChi = ?1")
	CoSoYTe findByDC_CSYT(String diachi);
}
