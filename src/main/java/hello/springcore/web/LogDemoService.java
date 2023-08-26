package hello.springcore.web;

import hello.springcore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final ObjectProvider<MyLogger> loggerProvider;

    public void logic(String id) {
        MyLogger myLogger = loggerProvider.getObject();
        myLogger.log("service id: " + id);
    }
}
