package springbasic.springbasic;

import springbasic.springbasic.member.MemberService;
import springbasic.springbasic.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

    }
}
