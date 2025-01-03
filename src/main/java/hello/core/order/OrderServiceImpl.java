package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 고객 조회
        Member member = memberRepository.findById(memberId);

        // 할인 금액 구하기
        /* 이 서비스 로직에서 멤버의 등급에 따라 할인을 적용하는 로직을 구현하지 않고
        * 해당 책임을 할인 쪽으로 넘겼으므로 단일 책임 원칙을 잘 지킨 코드라고 할 수 있다.
        */
        int discount = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}