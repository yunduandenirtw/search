package com.smc.service;

import com.smc.entity.CompanyEntity;
import com.smc.entity.StockPriceEntity;
import com.smc.repository.CompanyRepository;
import com.smc.repository.StockPriceRepository;
import com.smc.utils.CommonResult;
import com.smc.utils.ResponseCode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CompanyService
 * @Description TODO
 * @Author WangRuiTing
 * @Date 12/3/2019 10:30 AM
 * @Version 1.0
 **/
@Service
public class CompanyService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CompanyRepository companyRepository;

	/**
	 * Description: query all company.
	 *
	 * @param:
	 * @return: com.smc.utils.CommonResult
	 */
	public CommonResult findAll() {
		try {
			List<CompanyEntity> company = companyRepository.findAll();
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", company);
		} catch (Exception e) {
			logger.error("Fail to query company data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	/**
	 * Description: query company by companyCode.
	 *
	 * @param:
	 * @return: com.smc.utils.CommonResult
	 */
	public CommonResult findByCode(String companyCode) {
		try {
			CompanyEntity company = companyRepository.findByCompanyCode(companyCode);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", company);
		} catch (Exception e) {
			logger.error("Fail to query company data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	/**
	 * Description: query company by companyName.
	 *
	 * @param:
	 * @return: com.smc.utils.CommonResult
	 */
	public CommonResult findByName(String companyName) {
		try {
			CompanyEntity company = companyRepository.findByName(companyName);
	
						return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", company);
		} catch (Exception e) {
			logger.error("Fail to query company data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	public CommonResult findByCompanyid(Integer id) {
		try {
			CompanyEntity company = companyRepository.findById(id).get();

			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", company);
		} catch (Exception e) {
			logger.error("Fail to query company data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	public List<CompanyEntity> findComBySector(String sector){
		try{
			List<CompanyEntity> companyEntities=companyRepository.findAllBySectorName(sector);
			return companyEntities;
		}catch (Exception e){
			logger.error("Fail to query company data:", e);
			return null;
		}

	}
}
