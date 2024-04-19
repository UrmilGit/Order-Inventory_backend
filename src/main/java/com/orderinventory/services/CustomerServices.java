package com.orderinventory.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderinventory.dto.CustomerOrders;
import com.orderinventory.dto.CustomerShipment;
import com.orderinventory.dto.ShipmentStatusCountCustomer;
import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Order;
import com.orderinventory.entities.OrderItem;
import com.orderinventory.entities.Shipment;
import com.orderinventory.exceptions.InvalidCustomerIdException;
import com.orderinventory.repo.CustomerRepository;
import com.orderinventory.repo.OrderItemRepository;
import com.orderinventory.repo.OrderRepository;
import com.orderinventory.repo.ShipmentRepository;

@Service
public class CustomerServices implements CustomerServiceInterface2 {

	@Autowired
	private CustomerRepository repo;

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust = repo.findById(customer.getCustomerId()).orElse(null);
		cust.setEmailAddress(customer.getEmailAddress());
		cust.setFullName(customer.getFullName());
		return repo.save(cust);
	}

	@Override
	public String deleteCustomer(int id) throws InvalidCustomerIdException {
		Customer customer = repo.findById(id).orElse(null);

		if (customer != null) {
			List<Order> orders = orderRepository.findByCustomer(customer);
			if (orders != null) {
				for (Order order : orders) {
					List<OrderItem> orderItems = orderItemRepository.findByOrder(order);
					if (orderItems != null) {
						orderItemRepository.deleteAll(orderItems);
					}
				}
			}
			List<Shipment> shipments = shipmentRepository.findByCustomer(customer);
			if (shipments != null) {
				for (Shipment shipment : shipments) {
					List<OrderItem> orderItems = orderItemRepository.findByShipment(shipment);
					if (orderItems != null) {
						orderItemRepository.deleteAll(orderItems);
					}
				}
			}
			shipmentRepository.deleteAll(shipments);

			repo.deleteById(id);
			return "Record deleted Successfully";
		}
		return "Deletion Failed";
	}

	@Override
	public List<Customer> getCustomerByEmailAddress(String emialAddress) {
		return repo.findByEmailAddress(emialAddress);
	}

	@Override
	public List<Customer> getCustomersByFullName(String fullName) {
		return repo.findByFullNameContains(fullName);
	}

	@Override
	public List<ShipmentStatusCountCustomer> getOrderCountByStatus() {
		return repo.getOrderCountByStatus();
	}

	@Override
	public CustomerOrders getCustomerOrders(int customerId) {
		Customer customer = repo.findById(customerId).orElse(null);
		List<Order> order = repo.getCustomerOrders(customerId);
		return new CustomerOrders(customer, order);
	}

	@Override
	public CustomerShipment getCustomerShipment(int customerId) {
		Customer customer = repo.findById(customerId).orElse(null);
		List<Shipment> shipment = repo.getCustomerShipments(customerId);
		return new CustomerShipment(customer, shipment);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return repo.findById(customerId).get();
	}

}