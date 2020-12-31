package serverimp;

import domain.Order;
import domain.ShopType;
import dto.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.OrderServer;
import server.ShopTypeServer;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class OrderServerImp implements OrderServer {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<OrderDto> getAllOrder() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderServer orderServerMapper = sqlSession.getMapper(OrderServer.class);
        List<OrderDto>orderDtos =orderServerMapper.getAllOrder();
        sqlSession.commit();
        sqlSession.close();
        return orderDtos;
    }

    @Override
    public int addOrder(Order order) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderServer orderServerMapper = sqlSession.getMapper(OrderServer.class);
        int n =orderServerMapper.addOrder(order);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    /**
     * 删除订单通过id
     *
     * @param id 订单编号
     * @return int
     */
    @Override
    public int deleteOrder(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderServer orderServerMapper = sqlSession.getMapper(OrderServer.class);
        int n =orderServerMapper.deleteOrder(id);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    /**
     * 更新订单 通过编号
     *
     * @param order 订单
     * @return
     */
    @Override
    public int updateOrder(Order order) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderServer orderServerMapper = sqlSession.getMapper(OrderServer.class);
        int n =orderServerMapper.updateOrder(order);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    /**
     * 查询订单通过id
     *
     * @param id 订单编号
     * @return
     */
    @Override
    public List<Order> getOrderById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderServer orderServerMapper = sqlSession.getMapper(OrderServer.class);
        List<Order> orderDtos=orderServerMapper.getOrderById(id);
        sqlSession.commit();
        sqlSession.close();
        return orderDtos;
    }

    @Override
    public List<OrderDto> getOrderDtoById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderServer orderServerMapper = sqlSession.getMapper(OrderServer.class);
        List<OrderDto>orderDtos =orderServerMapper.getOrderDtoById(id);
        sqlSession.commit();
        sqlSession.close();
        return orderDtos;
    }

    @Override
    public List<OrderDto> getOrderDtoByIdOrNameCus(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderServer orderServerMapper = sqlSession.getMapper(OrderServer.class);
        List<OrderDto>orderDtos =orderServerMapper.getOrderDtoByIdOrNameCus(id);
        sqlSession.commit();
        sqlSession.close();
        return orderDtos;
    }

    /**
     * 员工业绩订单查看
     *
     * @param id
     * @return
     */
    @Override
    public List<OrderDto> getOrderByStaffId(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderServer orderServerMapper = sqlSession.getMapper(OrderServer.class);
        List<OrderDto>orderDtos =orderServerMapper.getOrderByStaffId(id);
        sqlSession.commit();
        sqlSession.close();
        return orderDtos;
    }
}
