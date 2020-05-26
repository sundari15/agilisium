package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.model.ProductDetails;

@Repository
public interface ProductDetailsRepository  extends JpaRepository<ProductDetails, Integer>{

	@Query("SELECT p FROM ProductDetails p where p.product_id = ?#{[0]}")
	public ProductDetails findProductById(int productid);

}
