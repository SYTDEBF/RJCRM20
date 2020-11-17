package serverimp;

import domian.Admin;
import domian.Custom;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.AdminServer;
import server.CustomServer;
import util.SqlSessionFactoryUtils;

import java.io.IOException;

public class AdminServerImp implements AdminServer {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    public AdminServerImp() throws IOException {

    }

    @Override
    public Admin findByNameAndPass(String admin_name, String admin_password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminServer adminServer=sqlSession.getMapper(AdminServer.class);
        Admin admin=adminServer.findByNameAndPass(admin_name,admin_password);
        sqlSession.commit();
        sqlSession.close();
        return admin;
    }
}
