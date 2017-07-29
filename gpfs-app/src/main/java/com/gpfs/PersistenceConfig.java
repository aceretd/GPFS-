package com.gpfs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryImplementationPostfix = "CustomImpl")
public class PersistenceConfig {

}
