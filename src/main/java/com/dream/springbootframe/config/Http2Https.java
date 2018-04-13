package com.dream.springbootframe.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

/**
 * http转向https
 *
 * 根据java EE开发的颠覆者 Spring Boot实战 7.4.4内http转向https示例代码所写
 */
/*@Configuration*/
public class Http2Https {

    /*@Bean*/
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint s = new SecurityConstraint();
                s.setUserConstraint("CONFIDENTIAL");
                SecurityCollection ss = new SecurityCollection();
                ss.addPattern("/*");
                s.addCollection(ss);
                context.addConstraint(s);
            }
        };

        tomcat.addAdditionalTomcatConnectors(HttpConnector());
        return tomcat;
    }

    /*@Bean*/
    public Connector HttpConnector() {
        Connector c = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        c.setScheme("http");
        c.setPort(8080);
        c.setSecure(false);
        c.setRedirectPort(8099);
        return c;
    }
}
