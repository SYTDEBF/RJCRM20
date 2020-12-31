package server;

import domain.Order;
import dto.OrderDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderServer {
    List<OrderDto> getAllOrder();
    int addOrder(Order order);

    /**
     * 删除订单通过id
     * @param id 订单编号
     * @return int
     */
    int deleteOrder(int id);

    /**
     * 更新订单 通过编号
     * @param order 订单
     * @return
     */
    int updateOrder(Order order);

    /**
     * 查询订单通过id
     * @param id 订单编号
     * @return
     */
    @Select("select * from tb_order where id=#{id}")
    List<Order> getOrderById(Integer id);

    /**
     * 客户订单获取
     * @param id
     * @return
     */
    List<OrderDto> getOrderDtoById(Integer id);

    //TODO
    /**
     * 客户搜索订单
     * @param id
     * @return
     */
    List<OrderDto> getOrderDtoByIdOrNameCus(Integer id);

    /**
     * 员工业绩订单查看
     * @return
     */
    List<OrderDto> getOrderByStaffId(Integer id);


}
