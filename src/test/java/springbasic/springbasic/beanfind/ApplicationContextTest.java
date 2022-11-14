package springbasic.springbasic.beanfind;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbasic.springbasic.AppConfig;
import springbasic.springbasic.member.MemberService;
import springbasic.springbasic.member.MemberServiceImpl;


@Slf4j
public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean(){
        String[] beanNames = ac.getBeanDefinitionNames();

        for(String beanName : beanNames){
            Object bean = ac.getBean(beanName);
            log.info("name= " + beanName + "object=" + bean);
        }
    }

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


}
