package server;

import domain.Custom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomServer {
    Custom getCustom(int id);

    @Select("select id, custom_name as CustomName, custom_phone from tb_custom  where id=#{id}")
    Custom getCustom2(int id);

    int insertCustom(Custom custom);

    int deleteCustom(Long id);

    int updateCustom(Custom custom);

    List<Custom> findCustoms(String customName);

    List<Custom> getAllCustoms();
    List<Custom> findCustomsByIdOrName(String keyword);
}
