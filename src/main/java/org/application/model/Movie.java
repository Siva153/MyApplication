package org.application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movie {
	
	@Id
	private String _id;
	private String title;
	private String[] countries;
	private Integer year;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getCountries() {
		return countries;
	}
	public void setCountries(String[] countries) {
		this.countries = countries;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	

}
