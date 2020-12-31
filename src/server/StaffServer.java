package server;

import domain.ShopType;
import domain.Staff;
import dto.StaffDto;
import org.apache.ibatis.annotations.Select;
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
    List<StaffDto> getAllStaff();

    /**
     * 获取员工通过编号和名称
     * @param key 搜索关键字
     * @return
     */
    List<StaffDto> getStaffByIdOrName(String key);

    /**
     * 插入新员工
     * @param staff
     * @return
     */
    int addStaff(Staff staff);

    /**
     * 删除员工
     * @param id
     * @return
     */
    int deleteStaff(Integer id);

    int upStaff(Staff staff);
    @Select("select *from tb_staff where id=#{id}")
    List<Staff> getStaffById(Integer id);

    @Select("select id from tb_staff where id=#{arg0} and staff_password=#{arg1}")
    Staff getStaffByIdAndPassword(Integer id,String password);
}
