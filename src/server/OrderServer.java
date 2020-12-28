package server;

import domain.Order;
import dto.OrderDto;

import java.util.List;

public interface OrderServer {
    List<OrderDto> getAllOrder();
    int addOrder(Order order);
}
