package com.devpaulojr.Spring_App.repository;

import com.devpaulojr.Spring_App.model.OrderItem;
import com.devpaulojr.Spring_App.model.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
