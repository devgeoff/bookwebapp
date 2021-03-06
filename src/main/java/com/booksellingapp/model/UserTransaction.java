package com.booksellingapp.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transactions")
public class UserTransaction {
	
	private int id;
	private String seller;
	private String buyer;
	private String transactionDate;
	private int listingId;
	private double transactionAmount;
	private String bookTitle;
	
	


	public UserTransaction() {
		super();
	}
	
	
	public UserTransaction(String seller, String buyer, String transactionDate,
			int listingId, double transactionAmount) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.transactionDate = transactionDate;
		this.listingId = listingId;
		this.transactionAmount = transactionAmount;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getTransactionId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setTransactionId(int id) {
		this.id = id;
	}
	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}
	/**
	 * @return the buyer
	 */
	public String getBuyer() {
		return buyer;
	}
	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	/**
	 * @return the listingId
	 */
	public int getListingId() {
		return listingId;
	}
	/**
	 * @param listingId the listingId to set
	 */
	public void setListingId(int listingId) {
		this.listingId = listingId;
	}
	/**
	 * @return the transactionAmount
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}
	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	

}
