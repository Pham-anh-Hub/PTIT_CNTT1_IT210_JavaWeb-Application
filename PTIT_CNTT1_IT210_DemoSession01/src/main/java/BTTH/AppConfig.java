package BTTH;

import BTTH.impl.NormalNotify;
import BTTH.impl.VipNotify;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public VipNotify vipNotify(){
        return new VipNotify();
    }


    @Bean
    public NormalNotify normalNotify(){
        return new NormalNotify();
    }

    @Bean
    public AccountManagement accountManagement(){
        return  new AccountManagement();
    }
}
