package com.web.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config_details")
public class ConfigDetails {
	
	
	@EmbeddedId
	private ConfigComKey confgiComkey;
	private String model_name;
	public ConfigComKey getConfgiComkey() {
		return confgiComkey;
	}
	public void setConfgiComkey(ConfigComKey confgiComkey) {
		this.confgiComkey = confgiComkey;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	
	

}
