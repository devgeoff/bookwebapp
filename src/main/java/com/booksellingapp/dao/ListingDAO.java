package com.booksellingapp.dao;


import java.util.List;

import com.booksellingapp.model.Listing;


public interface ListingDAO {

	public void save(Listing listing);
	List<Listing> getListings(); 
	Listing findListingById(int listingId);
	public void deleteListing(int listingId);
}
