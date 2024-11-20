package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService service = new MemberServiceImpl();

    @Test
    public void 회원가입() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        service.join(member);
        Member findMember = service.findMember(1L);

        // then
        Assertions.assertThat(findMember).isEqualTo(member);
    }

}