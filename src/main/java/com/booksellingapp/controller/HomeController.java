package com.booksellingapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.booksellingapp.dao.ListingDAO;
import com.booksellingapp.dao.TransactionDAO;
import com.booksellingapp.dao.UserDAO;
import com.booksellingapp.dao.UserRoleDAO;
import com.booksellingapp.model.Listing;
import com.booksellingapp.model.User;
import com.booksellingapp.model.UserRole;
import com.booksellingapp.model.UserTransaction;

/**
 * Handles requests for the application.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserRoleDAO userRoleDAO;

	@Autowired
	ListingDAO listingDAO;

	@Autowired
	TransactionDAO transactionDAO;

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		List<Listing> retrievedListings = listingDAO.getListings();
		model.addObject("listings", retrievedListings);
		model.setViewName("listings");
		return model;

	}

	/**
	 * Directs the user to the add listings page
	 */
	@RequestMapping(value = "/addListing", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "addListing";
	}

	@RequestMapping(value = { "/singleListing" }, method = RequestMethod.GET)
	public ModelAndView viewSingleListing(
			@RequestParam(value = "listingId", required = false) String listingId) {

		System.out.println(listingId);

		ModelAndView model = new ModelAndView();
		Listing listing = listingDAO.findListingById(Integer
				.parseInt(listingId));
		model.addObject("listing", listing);
		User user1 = userDAO.findByUserName(listing.getUsername());
		model.addObject("user", user1);

		model.setViewName("singleListing");
		return model;

	}

	@RequestMapping(value = { "registration" }, method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView model = new ModelAndView();

		model.setViewName("registrationForm");
		return model;

	}

	@RequestMapping(value = "registered", method = RequestMethod.POST)
	public ModelAndView registered(
			ModelAndView model,
			@ModelAttribute("user") User user,
			@RequestParam(value = "password_confirm", required = false) String password1) {

		String error = null;
		String forwardPage = "loginPage";
		System.out.println("user is " + user.getEmailAddress());
		if (!(user.getPassword().equals(password1))) {
			error = "Password Mismatch";
			forwardPage = "registrationForm";
		}
		model = new ModelAndView();

		if (error != null) {
			model.addObject("error", "The passwords do not match!");
		} else {
			User newUser = new User();
			newUser.setUserName(user.getUserName());
			newUser.setEmailAddress(user.getEmailAddress());
			newUser.setPassword(user.getPassword());
			newUser.setFirstName("");
			newUser.setEnabled(true);
			UserRole role = new UserRole("ROLE_USER", user.getUserName());
			userDAO.save(newUser);
			userRoleDAO.save(role);
			model.addObject("msg", "Sign in with your new credentials");

		}

		model.setViewName(forwardPage);

		return model;

	}

	@RequestMapping(value = "addedlisting", method = RequestMethod.POST)
	public ModelAndView createdListing(
			@ModelAttribute("listing") Listing listing) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format((new Date())).toString();
		listing.setListingDate(date);

		listingDAO.save(listing);

		return this.defaultPage();
	}

	@RequestMapping(value = { "/accountPage" }, method = RequestMethod.GET)
	public ModelAndView administrationPage(
			@RequestParam(value = "username", required = false) String username) {

		ModelAndView model = new ModelAndView();
		List<Listing> retrievedListings = listingDAO.getListings();
		List<Listing> currentUserListings = new ArrayList<Listing>();
		for (Listing listing : retrievedListings) {
			if (listing.getUsername().equalsIgnoreCase(username)) {
				currentUserListings.add(listing);
			}

		}

		List<UserTransaction> sellingTransactions = transactionDAO
				.getTransactionsBySeller(username);
		List<UserTransaction> buyingTransactions = transactionDAO
				.getTransactionsByBuyer(username);

		model.addObject("currentUserListings", currentUserListings);
		model.addObject("buyingTransactions", buyingTransactions);
		model.addObject("sellingTransactions", sellingTransactions);
		System.out.println(username);
		System.out.println(buyingTransactions.size());
		System.out.println(sellingTransactions.size());
		model.setViewName("adminPage");
		return model;

	}

	@RequestMapping(value = { "/deleteListing" }, method = RequestMethod.GET)
	public ModelAndView deleteListing(
			@RequestParam(value = "listingdetails", required = false) String listingdetails) {

		System.out.println(listingdetails);
		listingDAO
				.deleteListing(Integer.parseInt(listingdetails.split("-")[0]));
		return this.administrationPage(listingdetails.split("-")[1]);

	}

	@RequestMapping(value = { "/purchase" }, method = RequestMethod.GET)
	public ModelAndView makePayment(
			@RequestParam(value = "listingId", required = false) String listingId) {
		System.out.println(listingId);
		ModelAndView model = new ModelAndView("payment");
		Listing listing = listingDAO.findListingById(Integer
				.parseInt(listingId));
		model.addObject("listing", listing);
		return model;

	}

	@RequestMapping(value = "purchaseConfirmation", method = RequestMethod.POST)
	public ModelAndView purchaseConfirmation(
			@ModelAttribute("UserTransaction") UserTransaction userTransaction) {

		System.out.println(userTransaction.getBuyer());
		System.out.println(userTransaction.getListingId());
		Listing listing = listingDAO.findListingById(userTransaction
				.getListingId());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String date = dateFormat.format((new Date())).toString();
		userTransaction.setTransactionDate(date);
		userTransaction.setSeller(listing.getUsername());
		userTransaction.setTransactionAmount(listing.getPrice());
		userTransaction.setBookTitle((listing.getListingTitle()));

		transactionDAO.saveTransaction(userTransaction);

		ModelAndView model = new ModelAndView("paymentConfirmation");
		model.addObject("userTransaction", userTransaction);
		model.addObject("listing", listing);
		return model;
	}

}
