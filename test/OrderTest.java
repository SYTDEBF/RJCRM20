import domain.ShopType;
import dto.OrderDto;
import server.OrderServer;
import serverimp.OrderServerImp;
import serverimp.ShopTypeServerImp;

import java.util.List;

public class OrderTest {
    OrderServer customServerImp=new OrderServerImp();
    List<OrderDto> shopTypes=customServerImp.getAllOrder();
    String str = "";

    public static void main(String[] args) {
        OrderTest orderTest=new OrderTest();
        for (OrderDto dto:orderTest.shopTypes
             ) {
            System.out.println(dto);
        }
    }
}
