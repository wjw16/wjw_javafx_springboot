/**
 * File : ChildControler.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/19 0019上午 8:16:06
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code.controller;

import com.it.code.view.SpringView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/19 0019上午 8:16:06
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/19 0019上午 8:16:06
 * @modDesc : 
 */

public class ChildController implements Initializable {
    @FXML
    private TextField tfShow;
    @FXML
    private Button btBack;
    @FXML
    private Label lbShow;
    @FXML
    private Button btnSet;
    public  FrameController frameController;
    public  void btBack_click(ActionEvent event){
        frameController.setShow(tfShow.getText());
    }
    public  void setShow(String text){
        lbShow.setText(text);

    }
    public ChildController(){
        System.out.println("进入childcontroller");
    }
    public  void btnSet_click(ActionEvent event){
        lbShow.setText(tfShow.getText());
        SpringController sc=springView.getController();
        sc.setTextArea(tfShow.getText());
    }
    private SpringView springView;
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("初始化了");
    }

    public SpringView getSpringView() {
        return springView;
    }
    @Autowired
    public void setSpringView(SpringView springView) {
        this.springView = springView;
    }

    public  void btnChild_click(ActionEvent event){
        springView=new SpringView();
        springView.show();
    }
}
