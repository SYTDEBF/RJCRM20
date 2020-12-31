package server;

import domain.ShopType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopTypeServer {
    List<ShopType> findAll();
    int addShopType(ShopType shopType);
    int deleteShopType(Integer id);
    int upShopTypeOnlyTypeName(ShopType shopType);
    @Select("select *from tb_shoptype where id like concat('%', #{key}, '%') or typename like concat('%', #{key}, '%')")
    List<ShopType> getShopTypeByIdOrName(String key);

}
