package io.mzlnk.fluqxverse.springboot.authsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.jackson.ProblemModule;

@Configuration
public class AutoConfiguration {

    @ConditionalOnMissingBean(value = ObjectMapper.class)
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new ProblemModule());
    }

}