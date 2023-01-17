package hello.springcore;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        /**
         * 어노테이션 기반 구성
         * 파라미터 AppConfig.class -> AppConfig 에 있는 환경 설정 정보를 스프링 컨테이너에 등록하고 관리
         * */
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        /**
         * AppConfig 의 memberService 객체를 가져오겠다는 의미
         * */

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}