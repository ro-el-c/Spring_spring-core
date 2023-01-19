package hello.springcore.beanfind;

import hello.springcore.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// JUnit5부터 public 설정 필요 X
class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        // 등록된 빈 이름 가져오기
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + ", object = " + bean);
        }
    }

    /**
     * 스프링 내부에 있는 것 제외하고, 내가 등록한 것들만 보고싶은 경우
     * */
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            // 각 빈에 대한 메타 데이터 정보
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                // ROLE_APPLICATION - 직접 등록한 애플리케이션 빈
                // ROLE_INFRASTRUCTURE - 스프링이 내부에서 사용하는 빈
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + ", object = " + bean);
            }

            // 내가 @Bean 으로 등록한 스프링 빈과 AppConfig 빈만 출력
        }
    }
}