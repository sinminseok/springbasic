package springbasic.springbasic.discount;

import springbasic.springbasic.member.Member;

public interface DiscountPolicy {

    int discount(Member member,int price);
}
