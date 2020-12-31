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

    @Override
    public int deleteShopType(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopTypeServer shopTypeServerMapper = sqlSession.getMapper(ShopTypeServer.class);
        int n=shopTypeServerMapper.deleteShopType(id);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }


    @Override
    public int upShopTypeOnlyTypeName(ShopType shopType) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopTypeServer shopTypeServerMapper = sqlSession.getMapper(ShopTypeServer.class);
        int n=shopTypeServerMapper.upShopTypeOnlyTypeName(shopType);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    @Override
    public List<ShopType> getShopTypeByIdOrName(String key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ShopTypeServer shopTypeServerMapper = sqlSession.getMapper(ShopTypeServer.class);
        List<ShopType> shopTypeList=shopTypeServerMapper.getShopTypeByIdOrName(key);
        sqlSession.commit();
        sqlSession.close();
        return shopTypeList;
    }
}
