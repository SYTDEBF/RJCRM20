package server;

import domain.Custom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomServer {
    Custom getCustom(int id);

    @Select("select id from tb_custom where id=#{arg0} and custom_password=#{arg1}")
    Custom getCustomByIdAndPassword(Integer id,String password);

    int insertCustom(Custom custom);

    int deleteCustom(Long id);

    int updateCustom(Custom custom);

    List<Custom> findCustoms(String customName);

    List<Custom> getAllCustoms();
    List<Custom> findCustomsByIdOrName(String keyword);
}
