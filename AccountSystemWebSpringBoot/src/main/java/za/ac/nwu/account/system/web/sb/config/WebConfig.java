package za.ac.nwu.account.system.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.account.system.web.sb.controller",
        "za.ac.nwu.account.system.web.sb.exception"
})

public class WebConfig {
}
