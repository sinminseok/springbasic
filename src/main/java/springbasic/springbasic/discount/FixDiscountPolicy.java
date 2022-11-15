package springbasic.springbasic.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springbasic.springbasic.member.Grade;
import springbasic.springbasic.member.Member;

@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
