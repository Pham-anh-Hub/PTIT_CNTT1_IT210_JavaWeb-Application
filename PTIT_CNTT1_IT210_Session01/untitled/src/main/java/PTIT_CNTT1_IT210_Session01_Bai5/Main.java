package PTIT_CNTT1_IT210_Session01_Bai5;

import PTIT_CNTT1_IT210_Session01_Bai5.config.AppConfig;
import PTIT_CNTT1_IT210_Session01_Bai5.model.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SystemConfig config = context.getBean(SystemConfig.class);

        System.out.println(config.getBranchName());
        System.out.println(config.getOpeningHour());
    }
}
