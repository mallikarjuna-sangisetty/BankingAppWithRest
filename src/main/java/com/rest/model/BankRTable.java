package com.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "bankManagement")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class BankRTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rNumber")
	private String id;

	@Column(name = "destination")
	private String destination;

	@Column(name = "netmask")
	private String netmask;

	@Column(name = "gateway")
	private String gateway;

	@Column(name = "interface")
	private String interface_;

	@Column(name = "metric")
	private Integer metric;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getInterface_() {
		return interface_;
	}

	public void setInterface_(String interface_) {
		this.interface_ = interface_;
	}

	public Integer getMetric() {
		return metric;
	}

	public void setMetric(Integer metric) {
		this.metric = metric;
	}
}
