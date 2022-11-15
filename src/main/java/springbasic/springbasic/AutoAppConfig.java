package springbasic.springbasic;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


//컴포넌트 스캔 기본대상 @Component,@Configuration,@Service,@Controller,@Repository
@Configuration
@ComponentScan(
        //지정하지 않으면 @ComponentScan의 위치를 프로젝트 최상단에 둔다.그러면 해당 위치부터 컴포넌트를 스캔한다,.
//        basePackages = "springbasic.springbasic",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class))
public class AutoAppConfig {


}
