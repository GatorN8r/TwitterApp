package com.twitter.app;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

@ApplicationPath("/api")
public class RestConfig extends Application {
    public RestConfig(@Context ServletConfig servletConfig) {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("My Twitter API");
        beanConfig.setBasePath("/twitter/api");
        beanConfig.setResourcePackage("com.twitter.app");
        beanConfig.setScan(true);
    }
}
