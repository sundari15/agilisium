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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.ConfigDetails;
import com.web.model.ProductDetails;
import com.web.repository.ProductDetailsRepository;

@RestController
@RequestMapping("agilisium")
public class ProductDetailsController {

	@Autowired
	ProductDetailsRepository prodRep;

	@GetMapping("/domain/api/productdetailsfromdb")
	public ResponseEntity<List<ProductDetails>> listAllProductDetailsFromDB() {
		List<ProductDetails> productList = prodRep.findAll();
		return new ResponseEntity<List<ProductDetails>>(productList, HttpStatus.OK);
	}

	@GetMapping("/domain/api/productdetails")
	public ResponseEntity<List<ProductDetails>> listAllProductDetails() {
		return new ResponseEntity<List<ProductDetails>>(getProductDetails(), HttpStatus.OK);
	}

	@GetMapping("domain/api/{productid}")
	public ResponseEntity<ProductDetails> getProductById(@PathVariable int productid) {
		ProductDetails prod = prodRep.findProductById(productid);

		if (prod != null) {
			return new ResponseEntity<ProductDetails>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProductDetails>(prod, HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping("domain/api/productdetails")
	public ResponseEntity<ProductDetails> createProduct(@RequestBody ProductDetails productDetails) {
		ProductDetails productDetail = prodRep.save(productDetails);
		return new ResponseEntity<ProductDetails>(productDetail, HttpStatus.OK);
	}

	private List<ProductDetails> getProductDetails() {

		ProductDetails productDetails = new ProductDetails();
		productDetails.setProduct_id(1111);
		productDetails.setProduct_name("Dell");
		productDetails.setPrice(45000);

		ProductDetails productDetails1 = new ProductDetails();
		productDetails1.setProduct_id(1112);
		productDetails1.setProduct_name("Lenova");
		productDetails1.setPrice(41000);

		ProductDetails productDetails2 = new ProductDetails();
		productDetails2.setProduct_id(1113);
		productDetails2.setProduct_name("Acer");
		productDetails2.setPrice(42000);

		return Arrays.asList(productDetails1, productDetails1, productDetails2);
	}

}
