package PTIT_CNTT1_IT210_Session01_Bai5.config;

import PTIT_CNTT1_IT210_Session01_Bai5.model.SystemConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("PTIT_CNTT1_IT210_Session01_Bai5")
public class AppConfig {
    @Bean
    public SystemConfig systemConfig() {
        return new SystemConfig();
    }
}
