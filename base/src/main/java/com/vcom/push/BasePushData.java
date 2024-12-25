package com.vcom.push;

import java.io.Serializable;

/**
 * Created by bin on 18/4/11.
 */

public class BasePushData implements Serializable {
    private int push_type;  //0：消息通知，1：gps通知，2任务通知，4：订单通知，5：通知司机消息，6支付通知
    private int server_type;
    // 0:{0:司机启程，1:司机加价，2:乘客是否接受加价出发，3.乘客取消订单4,.政企审核通知5.后台通知司机信息}
    // 1:{0:进入区域，1:离开区域}
    // 2:{0: 新分配任务，1:预约任务，2.接到乘客, 3:通知乘客车辆信息，4:乘客到达, 5:预约单被抢}
    ///4: {0:定制客运接收后台任务通知}
    // 6:{0:司机确认现金支付}


    public int getPush_type() {
        return push_type;
    }

    public void setPush_type(int push_type) {
        this.push_type = push_type;
    }

    public int getServer_type() {
        return server_type;
    }

    public void setServer_type(int server_type) {
        this.server_type = server_type;
    }
}
