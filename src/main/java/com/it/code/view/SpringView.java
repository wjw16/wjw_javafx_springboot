/**
 * File : SpringView.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/20 0020下午 5:31:23
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/20 0020下午 5:31:23
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/20 0020下午 5:31:23
 * @modDesc : 
 */
@Component
public class SpringView extends AbstractView {
    public  SpringView(){
        fxmlUrl="/fxml/springview.fxml";
        super.init(fxmlUrl);
    }
}
