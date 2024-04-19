
package com.orderinventory.repo;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orderinventory.dto.OrderInsight;
import com.orderinventory.dto.OrderStatusCount;
import com.orderinventory.dto.OrderStoreList;
import com.orderinventory.dto.ProdBrandCount;
import com.orderinventory.entities.Customer;
import com.orderinventory.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	
	@Query("SELECT  new com.orderinventory.dto.OrderStatusCount(o.orderStatus, COUNT(o.orderId)) " +
		       "FROM Order o " +
		       "WHERE o.orderStatus = :status " +
		       "GROUP BY o.orderStatus")
	public List<OrderStatusCount> getOrderCountByStatus(@Param("status") String orderStatus);
	
	public List<Order> findByCustomer(Customer customer);
	
	@Query("SELECT o FROM Order o WHERE o.store.storeName = :storeName")
	 public List<Order> findByStore_StoreName(@Param("storeName") String storeName);
	
	 @Query("SELECT o FROM Order o WHERE o.orderId = :id")
	 public Order findByOrderId(@Param("id") int orderId);
	
	 @Query("SELECT o FROM Order o WHERE o.customer.customerId = :customerId")
	 public List<Order> findByCustomer_CustomerId(@Param("customerId")int customerId);
	
	 @Query("SELECT o FROM Order o WHERE o.orderStatus = :orderStatus")
	 public List<Order> findByOrderStatus(@Param("orderStatus") String orderStatus);
	
	 @Query("SELECT o FROM Order o WHERE o.customer.emailAddress = :email")
	 public List<Order> findByCustomerEmail(@Param("email") String email);
	
	 @Query("SELECT o FROM Order o WHERE o.orderTimestamp BETWEEN :startDate AND :endDate")    
		public List<Order> findByOrderTimestampBetween(Timestamp startDate, Timestamp endDate);
	
}
