package serverimp;

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
}
