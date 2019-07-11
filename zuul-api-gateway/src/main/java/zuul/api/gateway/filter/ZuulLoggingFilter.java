package zuul.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulLoggingFilter.class);


    @Override
    public String filterType() {
        //"pre" -> filters before the request is executed, "post" -> filter after the request is executed,
        //"error" -> filter only error requests
        return "pre";
    }

    @Override
    public int filterOrder() { //a priority order can be set if there are multiple filters
        return 1;
    }

    @Override
    public boolean shouldFilter() { //should this filter be executed? business logic can be implemented
        return true; //yes, it will be executed
    }

    @Override
    public Object run() throws ZuulException {

        //the interception logic goes here
       HttpServletRequest request =  RequestContext.getCurrentContext().getRequest();
        LOGGER.info("request -> {}", "request uri -> {}", request, request.getRequestURI());
       return null;

    }
}
