/**
 * File : MainApp.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/16 0016下午 5:33:39
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/16 0016下午 5:33:39
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/16 0016下午 5:33:39
 * @modDesc : 
 */
@SpringBootApplication
public class MainApp extends Application {
    private static String[] args;
    public  static ConfigurableApplicationContext springContext;
    private Parent rootNode;


    public static void main(String[] args) {
        MainApp.args = args;
        launch(args);
    }
    @Override
    public void init() throws Exception {

    }
    @Override
    public void start(Stage stage) throws Exception {
        springContext =SpringApplication.run(MainApp.class, MainApp.args);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sample.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
        stage.setScene(new Scene(rootNode));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
        Platform.exit();
    }
}
