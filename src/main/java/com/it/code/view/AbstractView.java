/**
 * File : AbstractView.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/20 0020下午 5:35:26
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code.view;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/20 0020下午 5:35:26
 * @Desc :
 * @Modor :  温建武：2019/8/20 0020下午 5:35:26
 * @modDesc :
 */
public abstract class AbstractView {
    public String fxmlUrl;
    public Stage stage;
    public FXMLLoader fxmlLoader;
    private boolean cache = false;
    private Boolean isShow = false;

    public void init(String fxmlUrl){
        this.fxmlUrl=fxmlUrl;
        initStage();
    }
    public void init(){
        initStage();
    }
    public void show() {
        if (!isShow) {
                initStage();
                stage.show();
        } else {
            stage.show();
        }
    }
    @Bean
    @SuppressWarnings("unchecked")
    public <T> T getController() {
        if (fxmlLoader == null) return null;
        else
            return (T) fxmlLoader.getController();
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public Boolean getShow() {
        return isShow;
    }

    public void setShow(Boolean show) {
        isShow = show;
    }
    private Boolean initStage(){
        if (fxmlUrl == null || fxmlUrl.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("没有给FxmlUrl设置fxml文件的路径");
            alert.show();
            return false;
        }
        try {
            fxmlLoader = new FXMLLoader(getClass().getResource(fxmlUrl));
          //  fxmlLoader.setControllerFactory(MainApp.springContext::getBean);
            Pane pane = fxmlLoader.load();
            stage = new Stage();
            stage.setScene(new Scene(pane));
            isShow = true;
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    isShow=false;
                    stage.close();
                    fxmlLoader=null;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  true;
    }
}
