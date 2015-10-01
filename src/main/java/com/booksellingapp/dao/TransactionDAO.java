package com.booksellingapp.dao;

import java.util.List;

import com.booksellingapp.model.UserTransaction;

public interface TransactionDAO {
	
	public List<UserTransaction> getTransactions();
    public UserTransaction getTransactionById(int id);
    public void saveTransaction(UserTransaction transaction);
	public List<UserTransaction> getTransactionsByBuyer(String seller);
	public List<UserTransaction> getTransactionsBySeller(String buyer);


}
