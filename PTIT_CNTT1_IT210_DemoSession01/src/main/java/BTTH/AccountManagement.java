package BTTH;

import BTTH.impl.VipNotify;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AccountManagement {

    List<Account> accounts = new ArrayList<>(
            Arrays.asList(
                    new Account("Nguyen Van A", 50000.2, "VIP"),
                    new Account("Nguyen Van B", 4000.0, "VIP"),
                    new Account("Nguyen Van C", 45000.2, "Normal"),
                    new Account("Tran Van C", 3500.0, "normal")
            )
    );

    public void checkBalance(String username, String area){
        if(username == null || username.isEmpty()){
            System.err.println("Username không được để trống");
            return;
        }

        boolean isExisted = accounts.stream().anyMatch(account -> account.getFullname().equals(username));
        if (!isExisted){
            System.out.println("Người dùng không tồn tại ");
            return;
        }

        // check balance
        Account account = accounts.stream().filter(account1 -> account1.getFullname().equals(username)).findFirst().orElse(null);


        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        if(account != null){
            if (account.getBalance() < 0){
                System.err.println("Không đủ số dư");
                return;
            }

//            int[] number = new int[10];

            String nameArea = "";
            if(account.getBalance() < 5000){
                if(area.equalsIgnoreCase("vip")){
                    nameArea += "vip";
                }else {
                    nameArea += "normal";
                }
                nameArea += "Notify";
                Notification notification = context.getBean(nameArea, Notification.class);
                notification.sendNotify();
            }
        }

    }


}
