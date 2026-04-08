package BTTH.impl;

import BTTH.Notification;
import org.springframework.stereotype.Component;

@Component
public class VipNotify implements Notification {
    @Override
    public void sendNotify(String username, double balance) {
        System.out.println("[POPUP] Tài khoản: " + username + " | Số dư còn lại: " + balance);
    }
}
