package com.myallutilities.utilities.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.Map;


@Component
public class MessageUtil {
	
	
	@Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }
    public String get(String messageKey, Map<String, String> model) {
    	String rawText = accessor.getMessage(messageKey);
    	
    	
    	for (String key : model.keySet()) {
			String value = model.get(key);
			rawText = rawText.replaceAll( "\\$\\{"+ key +"\\}" , value  );
		}


        return rawText;
    }
}
