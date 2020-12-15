import domain.ShopType;
import serverimp.ShopTypeServerImp;

import java.util.List;

public class ShopTypeTest {
    ShopTypeServerImp customServerImp=new ShopTypeServerImp();
    List<ShopType>shopTypes=customServerImp.findAll();
    String str = "";
//    public  void main(String[] args) {
//
//        String str[]=new String[shopTypes.size()];
//        int i=0;
//        for (ShopType shop:
//            shopTypes ) {
//
//            switch (shop.getStype())
//            {
//                case 0: str[i]=shop.getTypename()+" ";break;
//                case 1: str[i]="#"+shop.getTypename()+"*"+shopTypes.get(shop.getParentid()-1).getTypename()+" ";break;
//                case 2: str[i]="##"+shop.getTypename()+"*"+shopTypes.get(shop.getParentid()-1).getTypename()+" ";break;
//                case 3: str[i]="###"+shop.getTypename()+"*"+shopTypes.get(shop.getParentid()-1).getTypename()+" ";break;
//            }
//            i++;
//        }
//        for (String str1:str
//             ) {
//            System.out.print(str1);
//        }
//    }
    public String creTreeStr(int i)
    {
        if(i<shopTypes.size()) {
        ShopType shop = shopTypes.get(i);

        switch (shop.getStype()) {
            case "0":
                str += shop.getTypename() + " ";
                break;
            case "1":
                str += "#" + shop.getTypename() + "*" + shopTypes.get(shop.getParentid() - 1).getTypename() + " ";
                break;
            case "2":
                str += "##" + shop.getTypename() + "*" + shopTypes.get(shop.getParentid() - 1).getTypename() + " ";
                break;
            case "3":
                str += "###" + shop.getTypename() + "*" + shopTypes.get(shop.getParentid() - 1).getTypename() + " ";
                break;
        }
        i++;
        return creTreeStr(i);
    }
    else {
        return str;
    }

    }
    public void toJS(String as)
    {
        String []asls=as.split(" ");
        String a[]=new String[asls.length];
        a[0]=asls[0];
        String sre="";
        for (int k=1;k<=3;k++)
        {
            if(k==1)
                sre="#";
            if(k==2)
                sre="##";
            if(k==3)
                sre="###";

            for(int i=1;i<asls.length;i++)
            {

//                int q= asls[i].lastIndexOf("#");
//                int w=asls[i].indexOf("*");
//                String stry=asls[i].substring(q+1,w);
//                a[i]=stry;
//                int e= asls[i].lastIndexOf("*");
//                String zx=asls[i].substring(e+1);
//                System.out.println(zx);
            }
        }


    }

    public static void main(String[] args) {
        ShopTypeTest shopTypeTest=new ShopTypeTest();

        shopTypeTest.toJS(shopTypeTest.creTreeStr(0));
    }
}
