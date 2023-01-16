package hello.springcore.order;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.FixDiscountPolicy;
import hello.springcore.discount.RateDiscountPolicy;
import hello.springcore.member.Member;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;

    @Override
    // 주문 생성 요청이 오면
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 1. 회원 정보 조회
        Member member = memberRepository.findById(memberId);
        // 2. 할인 정책 적용
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 3. 주문 객체 생성 & 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    /** 설계가 잘 된 이유
     * OrderService 입장에서 '할인 정책'에 대한 일에 관계 X
     * 할인에 대한 내용은 DiscountPolicy 가 모두 해결 후, OrderService 에게 전달만 함
     *
     * -> 단일 책임의 원칙(SRP) 잘 지켜짐
     *
     * => 만약, 할인 정책에 변경 사항이 생기면,
     *    OrderService 는 변경 없이 사용 가능
     *    DiscountPolicy 만 수정하면 됨
     */
}