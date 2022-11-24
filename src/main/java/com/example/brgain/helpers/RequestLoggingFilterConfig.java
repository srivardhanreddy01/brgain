package com.example.brgain.helpers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Component
public class RequestLoggingFilterConfig {
  @Bean
  public CommonsRequestLoggingFilter logFilter() {
    CommonsRequestLoggingFilter filter
            = new CommonsRequestLoggingFilter();
    filter.setIncludeQueryString(true);
    filter.setIncludePayload(true);
    filter.setMaxPayloadLength(100000);
    filter.setIncludeHeaders(false);
    filter.setIncludeClientInfo(false);
    filter.setAfterMessagePrefix("REQUEST DATA : ");
    return filter;
  }
}
