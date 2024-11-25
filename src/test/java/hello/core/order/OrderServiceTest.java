package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void 주문한다() {
        // 1. 회원가입
        long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        // 2. 주문
        Order order = orderService.createOrder(memberId, "itemName", 10_000);

        // 검증
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}