package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements  DiscountPolicy {

    private static final int DISCOUNT_FIXED_AMOUNT = 1000;

    @Override
    public int discount(Member member) {
        if (member.getGrade() == Grade.VIP) {
            return DISCOUNT_FIXED_AMOUNT;
        } else {
            return 0;
        }
    }
}