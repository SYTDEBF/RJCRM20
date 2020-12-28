package serverimp;

import domain.Staff;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.StaffServer;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class StaffServerImp implements  StaffServer{
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 获取所有员工
     *
     * @return
     */
    @Override
    public List<Staff> getAllStaff() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        List<Staff> staffList=shopTypeServerMapper.getAllStaff();
        sqlSession.commit();
        sqlSession.close();
        return staffList;
    }

    /**
     * 获取员工通过编号和名称
     *
     * @param key 搜索关键字
     * @return
     */
    @Override
    public List<Staff> getStaffByIdOrName(String key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        List<Staff> staffList=shopTypeServerMapper.getStaffByIdOrName(key);
        sqlSession.commit();
        sqlSession.close();
        return staffList;
    }
}
