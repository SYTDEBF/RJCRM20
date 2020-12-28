package controller.adcon;

import com.alibaba.fastjson.JSONObject;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.ShopType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import serverimp.ShopTypeServerImp;
import util.InfoUtils;
import util.TreeObjectUtils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminSTCon implements Initializable {
    @FXML
    Label addLabel;
    @FXML
    TextField pid;
    @FXML
    TextField name;
    @FXML
    TextField stype;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GlyphsDude.setIcon(addLabel, FontAwesomeIcon.USER_PLUS,"70px");
    }

    public void sendInfo(){
        if (name.getText().isEmpty()|| name.getText().isEmpty()|| stype.getText().isEmpty())
        {
            InfoUtils.alertUtil("所有信息不能为空!","警示", Alert.AlertType.WARNING);
        }
        else {
            if(!(InfoUtils.isInteger(pid.getText()))|| pid.getText().length()>4)
            {
                InfoUtils.alertUtil("父商品类型值必须为数字!","警示",Alert.AlertType.WARNING);
            }else if (!(InfoUtils.isInteger(stype.getText()))|| stype.getText().length()>4)
            {
                InfoUtils.alertUtil("层次必须为数字!","提示",Alert.AlertType.INFORMATION);
            }else {
                try {
                    ShopTypeServerImp shopTypeServerImp=new ShopTypeServerImp();
                    System.out.println("sdsdsd");
                    int n=shopTypeServerImp.addShopType(new ShopType(Integer.valueOf(pid.getText()),name.getText(),stype.getText()));
                    if(n==1){
                        InfoUtils.alertUtil("添加成功!","提示",Alert.AlertType.INFORMATION);

                        TreeObjectUtils<ShopType> shopTypeTreeObjectUtils=new TreeObjectUtils<>();
                        List<ShopType> ass=shopTypeTreeObjectUtils.get1(shopTypeServerImp.findAll());
                        WebView we=(WebView) Controller.primaryStage.getUserData();


                        we.getEngine().reload();
                        we.getEngine().executeScript("shopTypeTree("+ JSONObject.parse(ass.toString()).toString()+");");
                    }
                } catch (Exception e) {
                    InfoUtils.alertUtil("添加失败!","警示",Alert.AlertType.ERROR);
                    e.printStackTrace();
                }

            }


        }
    }

    }

