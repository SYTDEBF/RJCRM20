import com.alibaba.fastjson.JSONObject;
import domain.ShopType;
import serverimp.ShopTypeServerImp;
import util.TreeObjectUtils;

import java.util.List;

public class asd {
    public static void main(String[] args) {

        ShopTypeServerImp customServerImp=new ShopTypeServerImp();
        List<ShopType> shopTypes=customServerImp.findAll();
        TreeObjectUtils<ShopType> shopTypeTreeObjectUtils=new TreeObjectUtils<>();
        List<ShopType> ass=shopTypeTreeObjectUtils.get1(shopTypes);
       System.out.println(JSONObject.parse(ass.toString()).toString());
//        JSONArray jsonArray=new JSONArray();
//        for (ShopType s:shopTypes
//             ) {
//            JSONObject jsonObject=new JSONObject();
//            jsonObject.put("id",s.getId());
//            jsonObject.put("name",s.getTypename());
//            jsonObject.put("pid",s.getParentid());
//            jsonArray.add(jsonObject);
//        }

       // System.out.println(jsonArray.toString());
        //asd asd=new asd();
      //  System.out.println(asd.jc(5));
//        asd.fs(shopTypes);
    }
    public List<ShopType> fs(List<ShopType> as)
    {
        TreeObjectUtils<ShopType> shopTypeTreeObjectUtils=new TreeObjectUtils<>();
        List<ShopType> ass=shopTypeTreeObjectUtils.get1(as);
        System.out.println(ass.toString());
        return fs(ass);

    }
    public int jc(int a)
    {
        if (a==0)
            return 1;
        else
        {
            System.out.println(a*jc(a-1));
            return a * jc(a - 1);

        }


    }
}
