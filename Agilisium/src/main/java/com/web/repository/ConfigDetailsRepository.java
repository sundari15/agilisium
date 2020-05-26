package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.model.ConfigDetails;

@Repository
public interface ConfigDetailsRepository extends JpaRepository<ConfigDetails, Integer>{

	@Query("SELECT t FROM ConfigDetails t WHERE t.id.product_id = ?#{[0]}")
	public ConfigDetails findConfigById(int id);

}
