package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void VIP_할인_적용() {
        // given: VIP 회원이 있고
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when: 정률 할인 정책을 적용했을 때
        int discount = discountPolicy.discount(member, 10_000);

        // then: 할인액이 정확한지
        Assertions.assertThat(discount).isEqualTo(1_000);
    }

    @Test
    @DisplayName("일반 회원은 할인정책이 적용되지 않는다.")
    void 일반_할인_미적용() {
        // given: 일반 회원이 있고
        Member member = new Member(1L, "memberA", Grade.BASIC);

        // when: 정률 할인 정책을 적용했을 때
        int discount = discountPolicy.discount(member, 10_000);

        // then: 할인액이 정확한지
        Assertions.assertThat(discount).isEqualTo(0);
    }
}