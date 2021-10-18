package com.xoriant.ecart.dao;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.xoriant.ecart.controller.Sender;
import com.xoriant.ecart.model.ItemLine;

@Repository
public class OrderDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Sender sender;

	private RestTemplate restTemplate = new RestTemplate();

	private static final String BASE_URL = "http://localhost:8082/api/cart/";

	Random rand = new Random();
	protected static SecureRandom random = new SecureRandom();
	int upperbound = 2500000;

	public ItemLine[] placeOrder(String user) { // direct order

		ItemLine[] cartItems = restTemplate.getForObject(BASE_URL + "/" + user, ItemLine[].class);

		double totalAmount = Arrays.stream(cartItems).mapToDouble(line -> (line.getItem().getPrice() * line.getQty()))
				.sum();

		// How to place order?

		// AFter order is placed...

		Map<String, Object> inventoryData = new HashMap<String, Object>();
		List<Object> pids = new ArrayList<>();
		List<Object> qty = new ArrayList<>();
		// Map<String, Object> emailData=new HashMap<String, Object>();

		Arrays.stream(cartItems).forEach(cartItem -> {
			pids.add(cartItem.getItem().getId());
			qty.add(cartItem.getQty());

		});

		inventoryData.put("PID", pids);
		inventoryData.put("QTY", qty);

		// Send Order Info for Email Communication
		
		
		
		

		// ---------------------------------------
		sender.sendOrderInfo(inventoryData);

		// ---------------------------------------

		// ---------------------------
		// clear items in the cart
		// restTemplate.delete(BASE_URL+"/"+user);

		return cartItems;
	}

	/*
	 * // place an order public Order placeOrder(String user) {
	 * 
	 * List<ItemLine> cartItems = restTemplate.getForObject(BASE_URL + "/" + user,
	 * List.class);
	 * 
	 * double totalCartValue = cartItems.stream() .mapToDouble(itemLine ->
	 * itemLine.getItem().getPrice() * itemLine.getQty()).sum();
	 * 
	 * // get Bank payment confirmation
	 * 
	 * //cartItems.forEach(cartItem -> { UUID uuid=UUID.randomUUID(); int int_random
	 * = rand.nextInt(upperbound); Order order = new Order(int_random, 1,
	 * cartItem.getItem().getId(), cartItem.getQty(), totalCartValue,
	 * uuid.toString(), "SUCCESS"); //});
	 * 
	 * return null;
	 * 
	 * }
	 */

}
