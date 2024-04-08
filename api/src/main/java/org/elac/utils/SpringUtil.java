package org.elac.utils;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author David
 * @ClassName SpringUtil
 * @date 2022/6/20 11:52
 **/
public class SpringUtil {

    private SpringUtil() {
        throw new IllegalStateException("SpringUtil class");
    }

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context) {
        SpringUtil.applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    //Get the bean via the bean name
    public static Object getBeanByName(String name) {
        try {
            return getApplicationContext().getBean(name);
        } catch (Exception e) {
            return null;
        }
    }

    //NOSONAR
    public static Object getBeanByClassName(String className) {
        try {
            Class aClass = Class.forName(className);
            return getApplicationContext().getBean(aClass);
        } catch (Exception ex) {
            return null;
        }
    }

    public static <T> T getBean(Class<T> clazz) {
        if (SpringUtil.applicationContext == null) {
            return null;
        }
        try {
            return SpringUtil.applicationContext.getBean(clazz);
        } catch (Exception e) {
            return null;
        }
    }

    //Get the current request
    public static HttpServletRequest currentRequest() {
        Assert.notNull(RequestContextHolder.getRequestAttributes(), "RequestAttributes error");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(servletRequestAttributes, "ServletRequestAttributes error");
        return servletRequestAttributes.getRequest();
    }
}
