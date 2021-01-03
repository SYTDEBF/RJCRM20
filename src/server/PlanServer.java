package server;

import domain.Plan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PlanServer {
    /**
     * 通过员工id获取计划
     * @param id
     * @return
     */
    @Select("select * from tb_plan where staff_id=#{id}")
    List<Plan> getPlanByStaId(Integer id);

    /**
     * 添加计划
     * @param plan
     * @return
     */

    int addPlan(Plan plan);

    int upPlan(Plan plan);

    /**
     * 删除计划通过id
     * @param id
     * @return
     */
    int delPlan(Integer id);

    /**
     * 通过内容查找
     * @param keyword
     * @return
     */
    List<Plan> getPlanByContent(String keyword,Integer id);
}
