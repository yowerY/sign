package self.sign.conf;

import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;


@Configuration
public class FreeMarkerConf {
  
    private Logger logger = LoggerFactory.getLogger(FreeMarkerConf.class);

    @Bean("freeMarkerViewResolver")
    public FreeMarkerViewResolver getFreeMarkerViewResolver(){
    	FreeMarkerViewResolver resolver = new FreeMarkerViewResolver("", ".ftl");
    	resolver.setExposeRequestAttributes(true);
    	resolver.setExposeSessionAttributes(true);
    	resolver.setExposeSpringMacroHelpers(true);
    	resolver.setSuffix(".ftl");
    	resolver.setCache(false);
    	resolver.setRequestContextAttribute("request");
    	resolver.setContentType("text/html;charset=utf-8");
    	return resolver;
    }
    
    @Bean("freeMarkerConfigurer")
    public FreeMarkerConfigurer getfreeMarkerConfigurer( )
    		throws IOException, TemplateException {
    	FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
    	factory.setTemplateLoaderPath("classpath:/templates");
    	freemarker.template.Configuration conf = factory.createConfiguration();

	    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
	    configurer.setConfiguration(conf);
	    return configurer;
    }
}