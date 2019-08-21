/**
 * File : SpringController.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/20 0020下午 5:30:21
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/20 0020下午 5:30:21
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/20 0020下午 5:30:21
 * @modDesc : 
 */
public class SpringController {
    @FXML
    private TextArea taShow;
    public  void setTextArea(String text){
        taShow.setText(text);
    }
}
