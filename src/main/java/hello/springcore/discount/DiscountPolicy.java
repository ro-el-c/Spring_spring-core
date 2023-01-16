package hello.springcore.discount;

import hello.springcore.member.Member;

public interface DiscountPolicy {
    /***
     * @return 할인 대상 금액
     * ex. 1000 = 1000원 할인
     */
    int discount(Member member, int price);
}