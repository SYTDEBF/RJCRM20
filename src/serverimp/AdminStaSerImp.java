package serverimp;

import domain.Admin;
import dto.DataCouDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.AdminServer;
import server.AdminStaSer;
import util.SqlSessionFactoryUtils;

import java.io.IOException;
import java.util.List;

public class AdminStaSerImp implements AdminStaSer {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    public AdminStaSerImp() throws IOException {

    }



    /**
     * 获取用户总数
     *
     * @return int
     */
    @Override
    public List<DataCouDto> getAllCou() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminStaSer adminStaSer=sqlSession.getMapper(AdminStaSer.class);
        List<DataCouDto>allCou=adminStaSer.getAllCou();
        sqlSession.commit();
        sqlSession.close();
        return allCou;
    }


}
