package server;

import dto.OrderDto;

import java.util.List;

public interface OrderServer {
    public List<OrderDto> getAllOrder();
}
