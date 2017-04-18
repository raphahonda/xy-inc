package br.com.xy.inc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thoughtworks.xstream.XStream;

@Entity
public class Supplier {

	public Supplier(){}

	public Supplier(String name, String lineOfBusiness, String telephone) {
		super();
		this.name = name;
		this.lineOfBusiness = lineOfBusiness;
		this.telephone = telephone;		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String telephone;

	private String lineOfBusiness;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getTelephone() { return telephone; }

	public void setTelephone(String telephone) { this.telephone = telephone; }

	public String getLineOfBusiness() { return lineOfBusiness; }

	public void setLineOfBusiness(String lineOfBusiness) { this.lineOfBusiness = lineOfBusiness; }

	public String toXML(){ return new XStream().toXML(this); }
}