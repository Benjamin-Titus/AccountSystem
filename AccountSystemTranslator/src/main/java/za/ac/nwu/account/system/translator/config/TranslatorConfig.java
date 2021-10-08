package za.ac.nwu.account.system.translator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.account.system.repository.config.RepoConfig;
import za.ac.nwu.account.system.repository.persistence.AccountTypeRepo;

@Import({RepoConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.account.system.translator"
})
public class TranslatorConfig {

    }
}
