package com.booksellingapp.model;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listings")
public class Listing implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String listingTitle;
	private String isbn;
	private String listingDate;
	private int zip;
	private String clgName;
	private String quality;
	private String username;
	private double price;
	private String dateSold;
	private String image;
	private String isAvailable;

	public Listing() {

	}

	public Listing(String listingTitle, String isbn,
			String listingDate, int zip, String clgName, String quality,
			String username, double price, String image) {
		super();
		this.listingTitle = listingTitle;
		this.isbn = isbn;
		this.listingDate = listingDate;
		this.zip = zip;
		this.clgName = clgName;
		this.quality = quality;
		this.username = username;
		this.price = price;
		this.image = image;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListingTitle() {
		return listingTitle;
	}

	public void setlistingTitle(String listingTitle) {
		this.listingTitle = listingTitle;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getListingDate() {
		return listingDate;
	}

	public void setListingDate(String listingDate) {
		this.listingDate = listingDate;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDateSold() {
		return dateSold;
	}

	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
