package server;

import domain.ShopType;

import java.util.List;

public interface ShopTypeServer {
    List<ShopType> findAll();
    int addShopType(ShopType shopType);

}
