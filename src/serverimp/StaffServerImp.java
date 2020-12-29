package serverimp;

import domain.Staff;
import dto.StaffDto;
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
    public List<StaffDto> getAllStaff() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        List<StaffDto> staffList=shopTypeServerMapper.getAllStaff();
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
    public List<StaffDto> getStaffByIdOrName(String key) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        List<StaffDto> staffList=shopTypeServerMapper.getStaffByIdOrName(key);
        sqlSession.commit();
        sqlSession.close();
        return staffList;
    }

    /**
     * 插入新员工
     *
     * @param staff
     * @return
     */
    @Override
    public int addStaff(Staff staff) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        int n =shopTypeServerMapper.addStaff(staff);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    @Override
    public int deleteStaff(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        int n=shopTypeServerMapper.deleteStaff(id);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    @Override
    public int upStaff(Staff staff) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        int n=shopTypeServerMapper.upStaff(staff);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    @Override
    public List<Staff> getStaffById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StaffServer shopTypeServerMapper = sqlSession.getMapper(StaffServer.class);
        List<Staff> staffList=shopTypeServerMapper.getStaffById(id);
        sqlSession.commit();
        sqlSession.close();
        return staffList;
    }
}
