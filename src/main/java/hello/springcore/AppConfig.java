/** 팩토리 메서드를 통해 스프링 빈을 스프링 컨테이너에 등록하는 방법
 *  = 외부에서 메소드(ex. memberService)를 호출해서 스프링 빈이 생성되는 방법
 * */

package hello.springcore;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.RateDiscountPolicy;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import hello.springcore.member.MemoryMemberRepository;
import hello.springcore.order.OrderService;
import hello.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 구성 영역
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
        // memberRepository()는 new MemoryMemberRepository()로 치화될 수 있음
        // 이것은 스프링 컨테이너가 관리하는 게 아님.
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
        //return null;
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}