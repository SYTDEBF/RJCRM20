package serverimp;

import domian.Custom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import server.CustomServer;
import util.SqlSessionFactoryUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CustomServerImp implements CustomServer {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    public CustomServerImp() throws IOException {

    }

    @Override
    public Custom getCustom(int id) {
        return null;
    }

    @Override
    public Custom getCustom2(int id) {
        return null;
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
    public int deleteCustom(Long id) {
        return 0;
    }

    @Override
    public int updateCustom(Custom Custom) {
        return 0;
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
