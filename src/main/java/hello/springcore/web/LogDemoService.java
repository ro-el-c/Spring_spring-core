package hello.springcore.web;

import hello.springcore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger logger;

    public void logic(String id) {
        logger.log("service id: " + id);
    }
}
