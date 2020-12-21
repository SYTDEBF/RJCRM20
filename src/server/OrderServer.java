package server;

import domain.Order;
import dto.OrderDto;

import java.util.List;

public interface OrderServer {
    public List<OrderDto> getAllOrder();
    public int addOrder(Order order);
}
