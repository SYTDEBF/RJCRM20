package util;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.*;
import java.util.List;

public class MyConfigUpUtil {
    public static String re="";
    public static String message="";
    public  static void upMyConfig(String dbUserName,String dbPassword,String dbUrl) {
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = null;
        try {
            document = reader.read(new File("res/config/Mybatis-config.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //3.获取根节点
        List list = document.selectNodes("/configuration/environments/environment/dataSource/property");
        for (int i = 1; i <=3; i++) {
            Element element=(Element) list.get(i);
            System.out.println(element.attribute("name").getValue());
            switch (element.attribute("name").getValue())
            {
                case "url": element.attribute("value").setValue(dbUrl);break;
                case "username": element.attribute("value").setValue(dbUserName);break;
                case "password": element.attribute("value").setValue(dbPassword);break;
            }

        }

        try {
            writeXml(document,"res/config/Mybatis-config.xml");
            re="1";
            message="保存成功";
        } catch (IOException e) {
            e.printStackTrace();
            re="0";
            message="保存失败 "+"原因:"+e.getMessage();
        }

    }
    /**
     * 输出xml文件
     *
     * @param document
     * @param filePath
     * @throws IOException
     */
    public static void writeXml(Document document, String filePath) throws IOException {
        File xmlFile = new File(filePath);
        XMLWriter writer = null;
        try {
            if (xmlFile.exists())
                xmlFile.delete();
            writer = new XMLWriter(new FileOutputStream(xmlFile), OutputFormat.createPrettyPrint());
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    public static void main(String[] args) {
        MyConfigUpUtil.upMyConfig("","","");
    }

    }


