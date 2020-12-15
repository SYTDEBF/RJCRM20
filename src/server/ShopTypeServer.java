package server;

import domain.ShopType;

import java.util.List;

public interface ShopTypeServer {
    public List<ShopType> findAll();
    public int addShopType(ShopType shopType);

}
