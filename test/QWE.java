
import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.io.File;
import java.net.URL;

public class QWE extends Application {

    /** 用于与Javascript引擎通信。 */
    private JSObject javascriptConnector;

    /** 用于从Javascript引擎进行通信。 */
    private final JavaConnector javaConnector = new JavaConnector();

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("test.html").toURI().toURL();
        WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();

        // 设置Java的监听器
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (Worker.State.SUCCEEDED == newValue) {
                // 在web引擎页面中设置一个名为“javaConnector”的接口对象
                JSObject window = (JSObject) webEngine.executeScript("window");
                window.setMember("javaConnector", javaConnector);

                // 获取Javascript连接器对象。
                javascriptConnector = (JSObject) webEngine.executeScript("getJsConnector()");
            }
        });

        Scene scene = new Scene(webView, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

        // 这里加载页面
        webEngine.load(url.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }

    class JavaConnector {
        /**
         * 让JavaScript调用的方法
         *
         * @param value 网页传过来的值
         */
        public void toLowerCase(String value) {
            System.out.println(value);
            if (null != value) {
                // 这里收到了JavaScript传来的数据，再传送一个值回去给JavaScript
                javascriptConnector.call("showResult", value.toLowerCase());
            }
        }
    }

}
