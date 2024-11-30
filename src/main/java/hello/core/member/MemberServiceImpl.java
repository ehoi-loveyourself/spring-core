package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // as-is 기존에는 MemberServiceImpl 클라이언트가 직접 MemoryMemberRepository 구현체의 의존관계를 설정했다면
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // to-be 지금은 인터페이스에만 의존하고, 어떤 구현체를 의존할 지에 대해서는 전혀 책임을 지고 있지 않다.
    // 외부에서 구현체를 주입시켜주므로 memberServiceImpl 의 원래 기능에만 집중할 수 있다.
    private final MemberRepository memberRepository;

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