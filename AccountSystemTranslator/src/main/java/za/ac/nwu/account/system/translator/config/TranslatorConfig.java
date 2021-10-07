package za.ac.nwu.account.system.translator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.account.system.repository.config.RepoConfig;

@Import({RepoConfig.class})
@Configuration
public class TranslatorConfig {
}
