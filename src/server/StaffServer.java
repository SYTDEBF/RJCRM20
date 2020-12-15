package server;

import domain.ShopType;
import domain.Staff;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import serverimp.StaffServerImp;
import util.SqlSessionFactoryUtils;

import java.util.List;

public interface StaffServer  {
    List<Staff> getAllStaff();
}
