package serverimp;

import domain.Shop;
import dto.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.OrderServer;
import server.ShopServer;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class ShopServerImp implements ShopServer {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 获取所有商品
     *
     * @return List<Shop>
     */
    @Override
    public List<Shop> getAllShop() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopServer shopServer = sqlSession.getMapper(ShopServer.class);
        List<Shop> shops =shopServer.getAllShop();
        sqlSession.commit();
        sqlSession.close();
        return shops;
    }

    /**
     * 查找商品通过id或者名称
     *
     * @param key 查找关键字
     * @return List
     */
    @Override
    public List<Shop> getShopByIdOrName(String key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopServer shopServer = sqlSession.getMapper(ShopServer.class);
        List<Shop> shops =shopServer.getShopByIdOrName(key);
        sqlSession.commit();
        sqlSession.close();
        return shops;
    }


}
