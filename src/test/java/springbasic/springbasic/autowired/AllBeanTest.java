package springbasic.springbasic.autowired;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic.springbasic.AutoAppConfig;
import springbasic.springbasic.discount.DiscountPolicy;
import springbasic.springbasic.member.Grade;
import springbasic.springbasic.member.Member;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


@Slf4j
public class AllBeanTest {


    @Test
    void findAllBean(){
        //new AnnotationConfigApplicationContext 스프링컨ㅌ이너를 생성하면서스프링빈으로 등록한다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L,"userA", Grade.VIP);
        int discountPrice = discountService.discount(member,10000,"fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

    }

    //DiscountService는 Map으로 모든 DiscountPolicy 를 주입 받는다 이대
    static class DiscountService{

        private final Map<String,DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String,DiscountPolicy> policyMap,List<DiscountPolicy> policies){

            this.policyMap = policyMap;
            this.policies = policies;



            log.info("policyMap = " + policyMap);
            log.info("policies = " + policies);

        }

        public int discount(Member member,int price,String discountCode){
            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            log.info("discountCode = " + discountCode);
            log.info("discountPolicy = " + discountPolicy);

            return discountPolicy.discount(member,price);
        }
    }
}
