/**
 * File : ChildView.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/21 0021上午 8:51:02
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/21 0021上午 8:51:02
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/21 0021上午 8:51:02
 * @modDesc : 
 */
@Component
public class ChildView extends  AbstractView {
    public ChildView(){
        String fu="/fxml/child.fxml";
        super.init(fu);
    }
}
