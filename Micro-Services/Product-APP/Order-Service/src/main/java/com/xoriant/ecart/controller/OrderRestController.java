package com.xoriant.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dao.OrderDaoImpl;
import com.xoriant.ecart.model.ItemLine;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderRestController {
	
	@Autowired
	private OrderDaoImpl orderDao;
	
	@GetMapping("/{user}")
	public ItemLine[] placeOrder(@PathVariable String user) {
		return orderDao.placeOrder(user);
	}
	
	

}
