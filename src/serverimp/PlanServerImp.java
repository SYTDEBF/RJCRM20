package serverimp;

import domain.Plan;
import dto.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import server.OrderServer;
import server.PlanServer;
import util.SqlSessionFactoryUtils;

import java.util.List;

public class PlanServerImp implements PlanServer {
    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 通过员工id获取计划
     *
     * @param id
     * @return
     */
    @Override
    public List<Plan> getPlanByStaId(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PlanServer planServerMapper = sqlSession.getMapper(PlanServer.class);
        List<Plan>plans =planServerMapper.getPlanByStaId(id);
        sqlSession.commit();
        sqlSession.close();
        return plans;
    }

    /**
     * 添加计划
     *
     * @param plan
     * @return
     */
    @Override
    public int addPlan(Plan plan) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PlanServer planServerMapper = sqlSession.getMapper(PlanServer.class);
        int n =planServerMapper.addPlan(plan);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    @Override
    public int upPlan(Plan plan) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PlanServer planServerMapper = sqlSession.getMapper(PlanServer.class);
        int n =planServerMapper.upPlan(plan);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    /**
     * 删除计划通过id
     *
     * @param id
     * @return
     */
    @Override
    public int delPlan(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PlanServer planServerMapper = sqlSession.getMapper(PlanServer.class);
        int n =planServerMapper.delPlan(id);
        sqlSession.commit();
        sqlSession.close();
        return n;
    }

    /**
     * 通过内容查找
     *
     * @param keyword
     * @return
     */
    @Override
    public List<Plan> getPlanByContent(String keyword,Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PlanServer planServerMapper = sqlSession.getMapper(PlanServer.class);
        List<Plan>plans =planServerMapper.getPlanByContent(keyword,id);
        sqlSession.commit();
        sqlSession.close();
        return plans;
    }
}
