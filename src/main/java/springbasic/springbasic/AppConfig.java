package springbasic.springbasic;

import springbasic.springbasic.discount.DiscountPolicy;
import springbasic.springbasic.discount.FixDiscountPolicy;
import springbasic.springbasic.member.MemberRepository;
import springbasic.springbasic.member.MemberService;
import springbasic.springbasic.member.MemberServiceImpl;
import springbasic.springbasic.member.MemoryMemberRepository;
import springbasic.springbasic.order.OrderService;
import springbasic.springbasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
