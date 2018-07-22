package hello;

public class Card {
	private int id;
	private String cardId;
	private String cardPIN;
	private double balance;
	
	public Card(String Id, String PIN, double bal) {
		cardId = Id;
		cardPIN = PIN;
		balance = bal;
	}
	
	public void setId(int i) {
		id = i;
	}
	
	public void setCardId(String id) {
		cardId = id;
	}
	
	public void setCardPin(String pin) {
		cardPIN = pin;
	}
	
	public void setBalance(double bal) {
		balance = bal;
	}
	
	public String getCardId() {
		return cardId;
	}
	
	public String getCardPin() {
		return cardPIN;
	}
	
	public double getBalance() {
		return balance;
	}

}