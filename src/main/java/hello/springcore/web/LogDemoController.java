package hello.springcore.web;

import hello.springcore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger logger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
//        MyLogger myLogger = loggerProvider.getObject();
        String requestURL = request.getRequestURL().toString();
        logger.setRequestURL(requestURL);

        logger.log("controller test");
        logDemoService.logic("testId");
        return "ok";
    }
}