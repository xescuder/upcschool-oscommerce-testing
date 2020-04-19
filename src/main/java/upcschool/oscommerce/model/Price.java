package upcschool.oscommerce.model;

import java.util.Currency;

public class Price {
	
	//A price is an amount in a currency
	private double amount;
	private Currency currency;
	
	public Price(double amount, Currency currency){
		this.amount=amount;
		this.currency=currency;
	}
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
