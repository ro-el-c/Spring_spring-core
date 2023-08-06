package hello.springcore.discount;

import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 정액 할인 - 1000원
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ // enum 타입은 값 비교시 == 사용
            return 1000;
        } else{
            return 0;
        }
        // 삼항 연산자로 가능? -> return (member.getGrade() == Grade.VIP) ? 1000 : 0;
    }
}