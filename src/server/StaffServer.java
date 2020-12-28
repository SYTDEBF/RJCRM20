package server;

import domain.ShopType;
import domain.Staff;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import serverimp.StaffServerImp;
import util.SqlSessionFactoryUtils;

import java.util.List;

public interface StaffServer  {
    /**
     * 获取所有员工
     * @return
     */
    List<Staff> getAllStaff();

    /**
     * 获取员工通过编号和名称
     * @param key 搜索关键字
     * @return
     */
    List<Staff> getStaffByIdOrName(String key);
}
