package com.booksellingapp.model;

import java.io.Serializable;

public class Image implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String listingId;
	private String imgID;
	private String imgLink;
	
	public String getListingId() {
		return listingId;
	}
	public void setListingId(String listID) {
		this.listingId = listID;
	}
	public String getImgID() {
		return imgID;
	}
	public void setImgID(String imgID) {
		this.imgID = imgID;
	}
	public String getImgLink() {
		return imgLink;
	}
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	
	
}
