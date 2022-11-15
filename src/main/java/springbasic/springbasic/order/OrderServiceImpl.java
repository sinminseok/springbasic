package springbasic.springbasic.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbasic.springbasic.discount.DiscountPolicy;
import springbasic.springbasic.discount.FixDiscountPolicy;
import springbasic.springbasic.member.Member;
import springbasic.springbasic.member.MemberRepository;
import springbasic.springbasic.member.MemoryMemberRepository;

//@RequiredArgsConstructor은 lombok이 제공하는 애노테이션이다 final이 붙은 필드를 모아서
//생성자를 자동으로 만들어준다.생성자 주입도 알아서 해줄..걸 ?
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    //생성자 주입을 사용하면 필ㄷ에 final키워드를 사용할 수 있다 그래서 생성자에서 혹시라도
    //값이 설정되지 않는 오류를 컴파일 시점에서 막아줌
   private final MemberRepository memberRepository;
   private final DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }


}
