package server;

import domain.Shop;
import dto.ShopDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopServer {
    /**
     * 获取所有商品
     * @return List<Shop>
     */
    List<ShopDto> getAllShop();

    /**
     * 查找商品通过id或者名称
     * @param key 查找关键字
     * @return List
     */
    List<Shop> getShopByIdOrName(String key);

    /**
     * 新增商品
     * @param shop
     * @return
     */
    int addShop(Shop shop);

    /**
     * 更新商品
     * @param shop
     * @return
     */
    int upShop(Shop shop);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteShop(Integer id);
    @Select("select * from tb_shop where id=#{id}")
    Shop getShopById(Integer id);
}
