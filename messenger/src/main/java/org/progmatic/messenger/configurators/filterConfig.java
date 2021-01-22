package org.progmatic.messenger.configurators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class filterConfig implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(filterConfig.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.debug("Filter is called");
        chain.doFilter(request, response);
    }
}
