package serverimp;

import domain.Shop;
import dto.ShopDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
    public List<ShopDto> getAllShop() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopServer shopServer = sqlSession.getMapper(ShopServer.class);
        List<ShopDto> shops =shopServer.getAllShop();
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

    /**
     * 新增商品
     *
     * @param shop
     * @return
     */
    @Override
    public int addShop(Shop shop) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopServer shopServer = sqlSession.getMapper(ShopServer.class);
        int n =shopServer.addShop(shop);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    /**
     * 更新商品
     *
     * @param shop
     * @return
     */
    @Override
    public int upShop(Shop shop) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopServer shopServer = sqlSession.getMapper(ShopServer.class);
        int n =shopServer.upShop(shop);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @Override
    public int deleteShop(Integer id) {
        return 0;
    }

    @Override
    public Shop getShopById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopServer shopServer = sqlSession.getMapper(ShopServer.class);
        Shop shop =shopServer.getShopById(id);
        sqlSession.commit();
        sqlSession.close();
        return shop;
    }


}
