package serverimp;

import domain.Custom;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.CustomServer;
import util.SqlSessionFactoryUtils;

import java.io.IOException;
import java.util.List;

public class CustomServerImp implements CustomServer {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    public CustomServerImp() throws IOException {

    }



    @Override
    public Custom getCustomById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomServer customServerMapper = sqlSession.getMapper(CustomServer.class);
        Custom custom=customServerMapper.getCustomById(id);
        sqlSession.commit();
        sqlSession.close();
        return custom;
    }

    @Override
    public Custom getCustomByIdAndPassword(Integer id, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomServer customServerMapper = sqlSession.getMapper(CustomServer.class);
        Custom custom=customServerMapper.getCustomByIdAndPassword(id,password);
        sqlSession.commit();
        sqlSession.close();
        return custom;
    }

    @Override
    public int insertCustom(Custom custom) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomServer customServerMapper = sqlSession.getMapper(CustomServer.class);
        int n=customServerMapper.insertCustom(custom);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    @Override
    public int deleteCustom(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomServer customServerMapper = sqlSession.getMapper(CustomServer.class);
        int n=customServerMapper.deleteCustom(id);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    @Override
    public int updateCustom(Custom Custom) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomServer customServerMapper = sqlSession.getMapper(CustomServer.class);
        int n=customServerMapper.updateCustom(Custom);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    @Override
    public List<Custom> findCustoms(String CustomName) {
        return null;
    }

    @Override
    public List<Custom> getAllCustoms() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomServer customServerMapper = sqlSession.getMapper(CustomServer.class);
        List<Custom> customList=customServerMapper.getAllCustoms();
        sqlSession.commit();
        sqlSession.close();
        return customList;
    }

    @Override
    public List<Custom> findCustomsByIdOrName(String keyword) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomServer customServerMapper = sqlSession.getMapper(CustomServer.class);
        List<Custom> customList=customServerMapper.findCustomsByIdOrName(keyword);
        sqlSession.commit();
        sqlSession.close();
        return customList;
    }
}
