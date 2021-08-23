package io.platformbuilders.cliente.config;

import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.helper.MessageHelper;
import io.platformbuilders.cliente.utils.deserializer.LocalDateDeserializer;
import io.platformbuilders.cliente.utils.deserializer.SexoDeserializer;
import io.platformbuilders.cliente.utils.serializer.LocalDateSerializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.Formatter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.time.LocalDate;
import java.util.Locale;

@Configuration
public class AppConfig {

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasenames("classpath:i18n/messages");
        source.setCacheSeconds(3600);
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

    @Bean
    MessageHelper messageHelper(MessageSource messageSource) {
        return new MessageHelper(messageSource);
    }

    @Bean
    Formatter<Sexo> sexoFormatter() {
        return new Formatter<>() {
            @Override
            public Sexo parse(String text, Locale locale) {
                return SexoDeserializer.deserialize(text);
            }

            @Override
            public String print(Sexo sexo, Locale locale) {
                return sexo.getTipo();
            }
        };
    }

    @Bean
    Formatter<LocalDate> localDateFormatter() {
        return new Formatter<>() {
            @Override
            public LocalDate parse(String text, Locale locale) {
                return LocalDateDeserializer.localDatePtBr(text);
            }

            @Override
            public String print(LocalDate localDate, Locale locale) {
                return LocalDateSerializer.serialize(localDate);
            }
        };
    }
}
