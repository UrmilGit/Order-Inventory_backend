package com.orderinventory.controllers;
 
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderinventory.dto.CustomerDTO;
import com.orderinventory.dto.OrderInsight;
import com.orderinventory.dto.OrderRequestDTO;
import com.orderinventory.dto.OrderStatusCount;
import com.orderinventory.dto.OrderStoreList;
import com.orderinventory.dto.ProdBrandCount;
import com.orderinventory.dto.StoreDTO;
import com.orderinventory.entities.Order;
import com.orderinventory.exceptions.InvaliddataException;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.exceptions.InvalidOrderIdException;
import com.orderinventory.services.OrderServices;
 
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/orders")
public class OrderController {
 
	@Autowired
	private OrderServices orderServices;
 
	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderServices.getAllOrders();
 
		if (orders.isEmpty()) {
			throw new NotFoundException("No orders found");
		}
 
		return ResponseEntity.ok(orders);
	}
 
//	@PostMapping("/")
//	public ResponseEntity<String> addOrder(@RequestBody Order order) {
//		Order addedOrder = orderServices.addOrder(order);
// 
//		if (addedOrder != null) {
//			return ResponseEntity.ok("Record created Successfully");
//		}
//		throw new InvaliddataException("Record creation has failed!");
//	}
 
	@PutMapping("/")
	public ResponseEntity<String> updateOrder(@RequestBody Order order) {
		Order updatedOrder = orderServices.updateOrder(order);
 
		if (updatedOrder != null) {
			return ResponseEntity.ok("Record Updated Successfully");
		} else {
			throw new NotFoundException("No order found for the provided ID: " + order.getOrderId());
		}
	}
 
	@GetMapping("/status")
	public ResponseEntity<List<OrderStatusCount>> getOrderCountByStatus(
			@RequestParam("orderstatus") String orderStatus) {
		List<OrderStatusCount> orderCountList = orderServices.getOrderCountByStatus(orderStatus);
 
		if (orderCountList.isEmpty()) {
			throw new InvaliddataException("No orders found for the provided order status: " + orderStatus);
		}
 
		return ResponseEntity.ok(orderCountList);
	}
 
 
	@GetMapping("/storename")
    public ResponseEntity<List<Order>> getOrdersByStoreName(@RequestParam("storename") String storeName) {
        List<Order> orders = orderServices.getOrdersByStoreName(storeName);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
	@GetMapping("/orderid/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") int orderId) throws InvalidOrderIdException{
        Order order = orderServices.getOrderById(orderId);
        if (order == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new InvalidOrderIdException("This id is not present");
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
	 @GetMapping("/customerid/{id}")
	    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable("id") int customerId) {
	        List<Order> orders = orderServices.getOrdersByCustomerId(customerId);
	        if (orders.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(orders, HttpStatus.OK);
	    }
	 @GetMapping("/orders/status")
	    public ResponseEntity<List<Order>> getOrdersByOrderStatus(@RequestParam("status") String orderStatus) {
	        List<Order> orders = orderServices.getOrdersByOrderStatus(orderStatus);
	        if (orders.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(orders, HttpStatus.OK);
	    }
	 @GetMapping("/customer/email")
	    public ResponseEntity<List<Order>> getOrdersByCustomerEmail(@RequestParam("email") String email) {
	        List<Order> orders = orderServices.getOrdersByCustomerEmail(email);
	        if (orders.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(orders, HttpStatus.OK);
	    }
	 @GetMapping("/dateRange")
	    public ResponseEntity<List<Order>> getOrdersByDateRange(
	            @RequestParam("startDate") String startDateStr,
	            @RequestParam("endDate") String endDateStr) {
	        try {
	            // Parse string dates to java.util.Date
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            Date startDate = dateFormat.parse(startDateStr);
	            Date endDate = dateFormat.parse(endDateStr);
	            // Convert java.util.Date to java.sql.Timestamp
	            Timestamp startTimestamp = new Timestamp(startDate.getTime());
	            Timestamp endTimestamp = new Timestamp(endDate.getTime());
 
	            List<Order> orders = orderServices.getOrdersByDateRange(startTimestamp, endTimestamp);
	            if (orders.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity<>(orders, HttpStatus.OK);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 @PutMapping("/cancel/{id}")
		public ResponseEntity<String> cancelOrder(@PathVariable("id") int id) {
		    boolean canceled = orderServices.cancelOrderById(id);
	 
		    if (canceled) {
		        return ResponseEntity.ok("Order with ID " + id + " has been canceled successfully.");
		    } else {
		        throw new NotFoundException("No order found for the provided ID: " + id);
		    }
		}
	 
	 @GetMapping("/customers")
	    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
	        List<CustomerDTO> customers = orderServices.getAllCustomers();
	        if (customers.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
	 
	    @GetMapping("/stores")
	    public ResponseEntity<List<StoreDTO>> getAllStores() {
	        List<StoreDTO> stores = orderServices.getAllStores();
	        if (stores.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(stores, HttpStatus.OK);
	    }
	 
	    @PostMapping
	    public ResponseEntity<String> addOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
	        try {
	            orderServices.addOrder(orderRequestDTO);
	            return ResponseEntity.ok("Record created Successfully");
	        } catch (InvaliddataException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }

 
}

