package com.Design_pattern.COR.example;

import java.util.Random;

import com.Design_pattern.COR.example.handler.PriceHandler;
import com.Design_pattern.COR.example.handler.PriceHandlerFactory;

public class Customer {
	private PriceHandler priceHandler;
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	public void requestDicount(float discount){
		priceHandler.processDiscount(discount);
	}
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());
		
		Random rand = new Random();
		for(int i=1;i<=100;i++){
			System.out.print(i+":");
			customer.requestDicount(rand.nextFloat());
		}
	}
}
