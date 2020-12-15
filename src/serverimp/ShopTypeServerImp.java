package serverimp;

import domain.ShopType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.ShopTypeServer;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class ShopTypeServerImp implements ShopTypeServer {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<ShopType> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopTypeServer shopTypeServerMapper = sqlSession.getMapper(ShopTypeServer.class);
        List<ShopType> shopTypeList=shopTypeServerMapper.findAll();
        sqlSession.commit();
        sqlSession.close();
        return shopTypeList;

    }

    @Override
    public int addShopType(ShopType shopType) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopTypeServer shopTypeServerMapper = sqlSession.getMapper(ShopTypeServer.class);
        int n=shopTypeServerMapper.addShopType(shopType);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }
}
