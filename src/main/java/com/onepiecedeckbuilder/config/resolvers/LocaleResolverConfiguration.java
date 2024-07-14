package com.onepiecedeckbuilder.config.resolvers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;
import java.util.Locale;

@Configuration
public class LocaleResolverConfiguration {

    @Bean
    public LocaleResolver localeResolverTest() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setSupportedLocales(List.of(Locale.ENGLISH, Locale.FRENCH));
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return localeResolver;
    }

}
