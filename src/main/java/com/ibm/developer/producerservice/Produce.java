package com.ibm.developer.producerservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produce")
@SequenceGenerator(name = "produce_id_generator", allocationSize = 1, initialValue = 10)
public class Produce {

	@Id
	@GeneratedValue(generator = "produce_id_generator")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "sub_name")
	private String subName;
	@Column(name = "quantity")
	private int quantity;

	public Produce() {
	}

	public Produce(int id, String name, String subName, int quantity) {
		this.id = id;
		this.name = name;
		this.subName = subName;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
