package hello.springcore.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository; // 스프링 빈이 아님.
    // private final MemberRepository memberRepository = new MemberRepository(); 와 동일
    // 스프링이 관리하는 애가 아님!

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