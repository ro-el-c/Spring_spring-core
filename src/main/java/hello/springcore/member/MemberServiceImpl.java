package hello.springcore.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service")
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository; // 스프링 빈이 아님.
    // private final MemberRepository memberRepository = new MemberRepository(); 와 동일
    // 스프링이 관리하는 애가 아님!

    @Autowired // 생성자에 작성 -> MemberRepository 타입에 맞는 애를 찾아서 자동으로 의존관계 주입해줌
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}