package springbasic.springbasic.order;

import springbasic.springbasic.discount.DiscountPolicy;
import springbasic.springbasic.discount.FixDiscountPolicy;
import springbasic.springbasic.member.Member;
import springbasic.springbasic.member.MemberRepository;
import springbasic.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

   private final MemberRepository memberRepository;
   private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
