package controller.cuscon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CrmCookies {
   public static int cus_id=0;
   public static void saveCus_id(Integer id)
   {
      File file=new File("cookies.mz");
      try {
         OutputStream outputStream=new FileOutputStream(file);
         OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
         outputStreamWriter.write("cus_id:"+id+"");
         outputStreamWriter.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public  String  getCus_id()
   {
      File file=new File("cookies.mz");
      String lineTxt = null;
      try {
         InputStream inputStream=new FileInputStream(file);
         InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
         BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

         while ((lineTxt = bufferedReader.readLine()) != null) {
            System.out.println(lineTxt);
         }
        bufferedReader.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return lineTxt;
   }
}
