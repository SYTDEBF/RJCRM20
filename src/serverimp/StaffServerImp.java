package serverimp;

import domain.Staff;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.StaffServer;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class StaffServerImp implements  StaffServer{
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Staff> getAllStaff() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        List<Staff> staffList=shopTypeServerMapper.getAllStaff();
        sqlSession.commit();
        sqlSession.close();
        return staffList;
    }
}
