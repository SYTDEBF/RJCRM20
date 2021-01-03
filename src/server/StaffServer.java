package server;

import domain.ShopType;
import domain.Staff;
import dto.StaffAchievementDto;
import dto.StaffAllAchDto;
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

    /**
     * 员工业绩
     * @param id
     * @return
     */
    @Select("SELECT\n" +
            "\tc.staffOrderCon,\n" +
            "\td.staffSalesVolume \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\tcount( id ) AS staffOrderCon \n" +
            "\tFROM\n" +
            "\t\ttb_order \n" +
            "\tWHERE\n" +
            "\t\tstaff_id = #{id} \n" +
            "\t) c,\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\tSUM( b.shop_price ) AS staffSalesVolume \n" +
            "\tFROM\n" +
            "\t\t( SELECT shop_id FROM tb_order WHERE staff_id = #{id} ) a,\n" +
            "\t\ttb_shop b \n" +
            "\tWHERE\n" +
            "\ta.shop_id = b.id) d")
    StaffAchievementDto getStaffAchievementById(Integer id);

    @Select("SELECT\n" +
            "\ta.staff_id,\n" +
            "\tc.staff_name,\n" +
            "\tSUM( b.shop_price ) AS shop_price \n" +
            "FROM\n" +
            "\t(\n" +
            "\tSELECT\n" +
            "\t\tshop_id,\n" +
            "\t\ttb_order.staff_id \n" +
            "\tFROM\n" +
            "\t\ttb_order \n" +
            "\tWHERE\n" +
            "\tstaff_id IN ( SELECT staff_id FROM tb_order GROUP BY staff_id )) a,\n" +
            "\ttb_shop b,\n" +
            "\ttb_staff c \n" +
            "WHERE\n" +
            "\ta.shop_id = b.id \n" +
            "\tAND a.staff_id = c.id \n" +
            "GROUP BY\n" +
            "\tstaff_id\n")
    List<StaffAllAchDto> getStaffAllAch();
}
