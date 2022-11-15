package springbasic.springbasic.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springbasic.springbasic.member.Grade;
import springbasic.springbasic.member.Member;


//@Autiwired시 여러 빈이 매칭되면 @Primary가 우선권을 가진다.
@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent /100;
        }else{
            return 0;
        }
    }
}
