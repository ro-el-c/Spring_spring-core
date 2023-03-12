package hello.springcore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 스프링 빈으로 제대로 등록되는지 확인 + 앞서 작성한 코드를 최대한 유지하기 위하여 @Configuration 제외하고 스프링 빈 등록
public class AutoAppConfig {

}
