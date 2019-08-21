/**
 * File : FrameController.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/16 0016下午 5:46:51
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code.controller;

import com.it.code.view.ChildView;
import com.it.code.view.SpringView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/16 0016下午 5:46:51
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/16 0016下午 5:46:51
 * @modDesc : 
 */
@Controller
public class FrameController {
    @FXML
    private Label lbShow;
    @FXML
    private Button btnOne;
    @FXML
    private Button btnTwo;
    @FXML
    private TextField tfShow;
    private ChildController childControler1;
    private ChildController childControler2;
    private  Stage childStage1;
    private  Stage childStage2;
    @Autowired
    private SpringView springView;
    @Autowired
    private ChildView childView;
    public  FrameController(){
        System.out.println("进入FrameController");
    }
    @FXML
    private  void btnOne_click(ActionEvent event){
        FXMLLoader loader1=new FXMLLoader(getClass().getResource("/fxml/child.fxml"));
        try {
            Pane pane=loader1.load();
            childControler1=loader1.getController();
            childControler1.frameController=this;
            childStage1=new Stage();
            childStage1.setTitle("子窗体1");
            childStage1.setScene(new Scene(pane));
            childStage1.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @FXML
    private  void btnTwo_click(ActionEvent event){
        FXMLLoader  loader2=new FXMLLoader(getClass().getResource("/fxml/child.fxml"));
        try {
            Pane pane=loader2.load();
            childControler2=loader2.getController();
            childControler2.frameController=this;
            childStage2=new Stage();
            childStage2.setTitle("子窗体2");
            childStage2.setScene(new Scene(pane));
            //childStage2.initModality(Modality.APPLICATION_MODAL);
            childStage2.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void btnSetOne_click(ActionEvent event){
        TextField tf=(TextField) childStage1.getScene().lookup("#tfShow");
        tf.setText(tfShow.getText());
    }
    @FXML
    private void btnSetTwo_click(ActionEvent event){
        childControler2.setShow(String.valueOf(childStage1.isShowing()));
    }
    @FXML
    private  void btnSetThree_click(ActionEvent event){
        springView.show();
        childView.show();
    }
    public  void setShow(String text){
        lbShow.setText(text);
    }
}
