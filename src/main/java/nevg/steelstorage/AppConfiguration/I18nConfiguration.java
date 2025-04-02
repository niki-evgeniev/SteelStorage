package nevg.steelstorage.AppConfiguration;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class I18nConfiguration {

    @Bean
    public LocaleResolver localResolver() {
//        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//        cookieLocaleResolver.setCookieName("lang");
//        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
//        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.ENGLISH);
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH); // По подразбиране на английски
        return sessionLocaleResolver;
    }

        @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        localeChangeInterceptor.setIgnoreInvalidLocale(true);
        return localeChangeInterceptor;
    }
//@Bean
//public LocaleChangeInterceptor localeChangeInterceptor() {
//    return new LocaleChangeInterceptor() {
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
//            String lang = request.getParameter("lang");
//            System.out.println("Changing language to: " + lang);
//
//            if (lang == null) {
//                System.out.println("WARNING: Lang parameter is missing!");
//            }
//
//            return super.preHandle(request, response, handler);
//        }
//    };
//}


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(Locale.ENGLISH);
        return messageSource;
    }
}
