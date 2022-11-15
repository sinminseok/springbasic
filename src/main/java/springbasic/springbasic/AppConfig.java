package springbasic.springbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbasic.springbasic.discount.DiscountPolicy;
import springbasic.springbasic.discount.FixDiscountPolicy;
import springbasic.springbasic.discount.RateDiscountPolicy;
import springbasic.springbasic.member.MemberRepository;
import springbasic.springbasic.member.MemberService;
import springbasic.springbasic.member.MemberServiceImpl;
import springbasic.springbasic.member.MemoryMemberRepository;
import springbasic.springbasic.order.OrderService;
import springbasic.springbasic.order.OrderServiceImpl;

//좋은 객체지향 설계 5가지 원칙의 적용
//SRP,DIP,OCP 적용
//SRP 단일 책임 원칙 한 클래스는 하나의 책임만을 가져아한다.
// - 클라이언트 객체는 직접 구현객체를 생성하고 연결하고 실행하는 다양한 책임을 가지고 있음
// - SRP단일 책임 원칙을 따르면서 관심사를 분리함
// -클라이언트 객체는 실행하는 책임만 담당

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }


    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
