package br.com.xy.inc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thoughtworks.xstream.XStream;

@Entity
public class CarFleet {

	public CarFleet(){}

	public CarFleet(String model, Double price, String patrimonyTag) {
		super();
		this.model = model;
		this.price = price;
		this.patrimonyTag = patrimonyTag;		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String model;

	private Double price;

	private String patrimonyTag;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getModel() { return model; }

	public void setModel(String model) { this.model = model; }

	public Double getPrice() { return price; }

	public void setPrice(Double price) { this.price = price; }

	public String getPatrimonyTag() { return patrimonyTag; }

	public void setPatrimonyTag(String patrimonyTag) { this.patrimonyTag = patrimonyTag; }

	public String toXML(){ return new XStream().toXML(this); }
}