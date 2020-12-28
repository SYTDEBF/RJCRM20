package server;

import domain.Shop;

import java.util.List;

public interface ShopServer {
    /**
     * 获取所有商品
     * @return List<Shop>
     */
    List<Shop> getAllShop();

    /**
     * 查找商品通过id或者名称
     * @param key 查找关键字
     * @return List
     */
    List<Shop> getShopByIdOrName(String key);
}
