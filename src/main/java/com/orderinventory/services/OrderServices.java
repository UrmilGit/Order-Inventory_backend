package com.orderinventory.services;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderinventory.dto.CustomerDTO;
import com.orderinventory.dto.OrderInsight;
import com.orderinventory.dto.OrderRequestDTO;
import com.orderinventory.dto.OrderStatusCount;
import com.orderinventory.dto.OrderStoreList;
import com.orderinventory.dto.ProdBrandCount;
import com.orderinventory.dto.StoreDTO;
import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Order;
import com.orderinventory.entities.OrderItem;
import com.orderinventory.entities.Shipment;
import com.orderinventory.entities.Store;

import com.orderinventory.exceptions.InvalidOrderIdException;
import com.orderinventory.exceptions.NotFoundException;

import com.orderinventory.repo.CustomerRepository;
import com.orderinventory.repo.OrderItemRepository;
import com.orderinventory.repo.OrderRepository;
import com.orderinventory.repo.ShipmentRepository;
import com.orderinventory.repo.StoreRepository;

@Service
public class OrderServices implements OrderServiceInterface{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
//	public Order addOrder(Order order) {
//		return orderRepository.save(order);
//	}
	
	public Order updateOrder(Order order) {
		Order updatedOrder = orderRepository.findById(order.getOrderId()).orElse(null);
		updatedOrder.setOrderStatus(order.getOrderStatus());
		updatedOrder.setCustomer(order.getCustomer());
		updatedOrder.setOrderTimestamp(order.getOrderTimestamp());
		updatedOrder.setStore(order.getStore());		
		
		return orderRepository.save(updatedOrder);
	}
	
	public List<OrderStatusCount> getOrderCountByStatus(String orderStatus){
		return orderRepository.getOrderCountByStatus(orderStatus);
	}
	
	public List<Order> getOrdersByStoreName(String storeName) {
		// TODO Auto-generated method stub
		return orderRepository.findByStore_StoreName(storeName);
	}
	public Order getOrderById(int orderId) throws InvalidOrderIdException {
        return orderRepository.findById(orderId).orElse(null);
    }
	public List<Order> getOrdersByCustomerId(int customerId) {
        return orderRepository.findByCustomer_CustomerId(customerId);
    }
	public List<Order> getOrdersByOrderStatus(String orderStatus) {
        return orderRepository.findByOrderStatus(orderStatus);
	}
	 public List<Order> getOrdersByCustomerEmail(String email) {
	        return orderRepository.findByCustomerEmail(email);
	    }
	 public List<Order> getOrdersByDateRange(Timestamp startDate, Timestamp endDate) {
	        return orderRepository.findByOrderTimestampBetween(startDate, endDate);
	    }
	 public boolean cancelOrderById(int id) {
	        Order order = orderRepository.findByOrderId(id);
	 
	        if (order != null) {
	            order.setOrderStatus("CANCELLED"); // Assuming you have a status field in your Order entity
	            orderRepository.save(order);
	            return true;
	        } else {
	            return false;
	        }
	    }
	 
	 public Order createOrder(String orderStatus, int customerId, int storeId) {
	        // Fetch customer and store entities from repositories
	        Customer customer = customerRepository.findById(customerId)
	                .orElseThrow(() -> new com.orderinventory.exceptions.NotFoundException.CustomerNotFoundException("Customer not found"));
	 
	        Store store = storeRepository.findById(storeId)
	                .orElseThrow(() -> new com.orderinventory.exceptions.NotFoundException.StoreNotFoundException("Store not found"));
	 
	        // Create new Order object
	        Order order = new Order();
	        order.setOrderStatus(orderStatus);
	        order.setCustomer(customer);
	        order.setStore(store);
	 
	        // Save the order to the database
	        return orderRepository.save(order);
	    }
		
		public List<CustomerDTO> getAllCustomers() {
	        // Fetch all customers from the database
	        List<Customer> customers = customerRepository.findAll();
	        // Convert customers to DTOs
	        return CustomerDTO.fromEntities(customers);
	    }
	 
	    public List<StoreDTO> getAllStores() {
	        // Fetch all stores from the database
	        List<Store> stores = storeRepository.findAll();
	        // Convert stores to DTOs
	        return StoreDTO.fromEntities(stores);
	    }
	 
	 
	    public Order addOrder(OrderRequestDTO orderRequestDTO) {
	        // Fetch customer and store entities from repositories
	        Customer customer = customerRepository.findById(orderRequestDTO.getCustomerId())
	                .orElseThrow(() -> new NotFoundException("Customer not found"));
	 
	        Store store = storeRepository.findById(orderRequestDTO.getStoreId())
	                .orElseThrow(() -> new NotFoundException("Store not found"));
	 
	        // Create new Order object
	        Order order = new Order();
	        order.setOrderStatus(orderRequestDTO.getOrderStatus());
	        order.setCustomer(customer);
	        order.setStore(store);
	 
	        // Save the order to the database
	        return orderRepository.save(order);
	    }
}