package com.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ConfigComKey;
import com.web.model.ConfigDetails;
import com.web.model.ProductDetails;
import com.web.repository.ConfigDetailsRepository;

@RestController
@RequestMapping("agilisium")
public class ConfigDetailsController {

	@Autowired
	private ConfigDetailsRepository configRep;

	@GetMapping("/domain/api/configdetailsfromdb")
	public ResponseEntity<List<ConfigDetails>> listAllConfigDetailsFromDB() {
		List<ConfigDetails> config = configRep.findAll();
		return new ResponseEntity<List<ConfigDetails>>(config, HttpStatus.OK);
	}

	@GetMapping("/domain/api/configdetails")
	public ResponseEntity<List<ConfigDetails>> listAllConfigDetails() {
		return new ResponseEntity<List<ConfigDetails>>(getConfigDetailsForProducts(), HttpStatus.OK);
	}

	@GetMapping("/domain/api/configdetails/{id}")
	public ResponseEntity<ConfigDetails> listConfigDetailsByProductId(@PathVariable int id) {
		ConfigDetails configDetails = configRep.findConfigById(id);
		if (configDetails != null) {
			return new ResponseEntity<ConfigDetails>(configDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<ConfigDetails>(configDetails, HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("domain/api/configdetails")
	public ResponseEntity<ConfigDetails> createConfigDetail(@RequestBody ConfigDetails configDetails) {
		ConfigDetails configdetail = configRep.save(configDetails);
		return new ResponseEntity<ConfigDetails>(configdetail, HttpStatus.OK);
	}

	private List<ConfigDetails> getConfigDetailsForProducts() {
		ConfigComKey configComKey = new ConfigComKey();
		configComKey.setConfig_id(1245);
		configComKey.setModel_no(1203);
		configComKey.setProduct_id(1111);
		ConfigDetails configDet = new ConfigDetails();
		configDet.setConfgiComkey(configComKey);
		configDet.setModel_name("intel core 5");

		ConfigComKey configComKey1 = new ConfigComKey();
		configComKey1.setConfig_id(1246);
		configComKey1.setModel_no(1204);
		configComKey1.setProduct_id(1112);
		ConfigDetails configDet1 = new ConfigDetails();
		configDet1.setConfgiComkey(configComKey);
		configDet1.setModel_name("intel core 7");

		ConfigComKey configComKey2 = new ConfigComKey();
		configComKey2.setConfig_id(1247);
		configComKey2.setModel_no(1205);
		configComKey2.setProduct_id(1113);
		ConfigDetails configDet2 = new ConfigDetails();
		configDet2.setConfgiComkey(configComKey);
		configDet2.setModel_name("intel core 3");

		return Arrays.asList(configDet, configDet1, configDet2);

	}

}
