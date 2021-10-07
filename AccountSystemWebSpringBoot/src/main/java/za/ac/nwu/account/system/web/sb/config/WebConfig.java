package za.ac.nwu.account.system.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.account.system.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.account.system.web.sb.controller",
        "za.ac.nwu.account.system.web.sb.exception"
})

public class WebConfig {
}
