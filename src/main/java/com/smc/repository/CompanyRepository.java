package com.smc.repository;

import com.smc.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

	@Query(name = "getCompanyNameByCode", nativeQuery = true,
			value = "SELECT companyname from company where companycode = :companyCode")
	String getCompanyNameByCode(String companyCode);

//	@Query(name = "findByCode", nativeQuery = true,
//			value = "SELECT * from company  where companycode = :companyCode")
//	CompanyEntity findByCode(String companyCode);
	
	CompanyEntity findByCompanyCode(String companyCode);

	@Query(name = "findByName", nativeQuery = true,
			value = "SELECT * from company  where companyname = :companyName")
	CompanyEntity findByName(String companyName);

	List<CompanyEntity> findAllBySectorName(String sector);

}

