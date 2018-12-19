package com.myallutilities.utilities.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/","classpath:/images"};

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/**")
////            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
////
//        registry.addResourceHandler("/**")//will look up
//	    .addResourceLocations("classpath:/static/")///and this is the proxy
//	    .resourceChain(true)
//	    .addResolver(new PathResourceResolver() {
//	        @Override
//	        protected Resource getResource(String resourcePath, Resource location) throws IOException {
//	            Resource requestedResource = location.createRelative(resourcePath);
//	            return requestedResource.exists() && requestedResource.isReadable() ? requestedResource : new ClassPathResource("/static/index.html");
//	        }
//	    });
//    }
}