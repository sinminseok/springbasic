package springbasic.springbasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic.springbasic.member.MemberService;
import springbasic.springbasic.order.OrderService;


public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);

//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

    }
}
