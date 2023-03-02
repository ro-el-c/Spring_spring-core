package hello.springcore.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A 사용자가 10000원 주문
        statefulService1.order("userA", 10000);
        // ThreadB: b 사용자가 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA: A 사용자 주문 금액 조회
        int priceA = statefulService1.getPrice();
        System.out.println("priceA = " + priceA); // A 사용자는 10000원을 기대, but 결과는 20000

        assertThat(statefulService1.getPrice()).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}