package hello.springcore.xml;

import hello.springcore.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

    @Test
    void xmlAppcontext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml"); // appConfig.xml == src/main/resources/appConfig.xml
        // ApplicationContext 가 부모

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
