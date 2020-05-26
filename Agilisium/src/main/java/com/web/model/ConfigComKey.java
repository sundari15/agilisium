package com.web.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class ConfigComKey implements Serializable {

	private int config_id;
	private int model_no;
	private int product_id;

	public ConfigComKey() {

	}

	public ConfigComKey(int config_id, int model_no, int product_id) {
		super();
		this.config_id = config_id;
		this.model_no = model_no;
		this.product_id = product_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + config_id;
		result = prime * result + model_no;
		result = prime * result + product_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfigComKey other = (ConfigComKey) obj;
		if (config_id != other.config_id)
			return false;
		if (model_no != other.model_no)
			return false;
		if (product_id != other.product_id)
			return false;
		return true;
	}

	public int getConfig_id() {
		return config_id;
	}

	public void setConfig_id(int config_id) {
		this.config_id = config_id;
	}

	public int getModel_no() {
		return model_no;
	}

	public void setModel_no(int model_no) {
		this.model_no = model_no;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

}
