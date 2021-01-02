package controller.stacon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffPlanMainCon implements Initializable {
    @FXML
    Tab noteTab;
    @FXML
    TabPane wordText1;
    @FXML
    Tab tableTab;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       wordText1.setSide(Side.RIGHT);
       wordText1.setRotateGraphic(false);
        GlyphsDude.setIcon(noteTab, FontAwesomeIcon.STICKY_NOTE);
        GlyphsDude.setIcon(tableTab,FontAwesomeIcon.TABLE);
        StackPane stackPane= null;
        try {
            stackPane = FXMLLoader.load(getClass().getResource("/fxml/StaffPlanNote.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        noteTab.setContent(stackPane);
        try {
            VBox vBox=FXMLLoader.load(getClass().getResource("/fxml/StaffPlan.fxml"));
            tableTab.setContent(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
