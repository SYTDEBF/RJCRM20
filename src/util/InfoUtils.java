package util;

import javafx.scene.control.Alert;

import java.util.regex.Pattern;

public class InfoUtils {
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    public static boolean isPhone(String str)
    {
        Pattern pattern = Pattern.compile("^1[34758][0-9]{9}$");
        return pattern.matcher(str).matches();
    }
    public static void alertUtil(String content, String title,Alert.AlertType alertType)
    {
        Alert alert = new Alert(alertType);
        alert.titleProperty().set(title);
        alert.headerTextProperty().set(content);
        alert.showAndWait();
    }
}
