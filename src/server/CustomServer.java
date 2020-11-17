package server;

import domian.Custom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomServer {
    public Custom getCustom(int id);

    @Select("select id, custom_name as CustomName, custom_phone from tb_custom  where id=#{id}")
    public Custom getCustom2(int id);

    public int insertCustom(Custom custom);

    public int deleteCustom(Long id);

    public int updateCustom(Custom custom);

    public List<Custom> findCustoms(String customName);

    public List<Custom> getAllCustoms();
    public List<Custom> findCustomsByIdOrName(String keyword);
}
