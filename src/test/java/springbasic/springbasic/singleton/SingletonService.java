package springbasic.springbasic.singleton;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class SingletonService {

    //static은 주로 클래스에 할당하고, 모든 객체가 메모리를 공유한다,.
    private static final SingletonService instance = new SingletonService();

    //이 객체 인스턴스가 필요하면 오직 getInstance()메서드를 통해서만 조회할 수 있다 이메서드를 호출하면 항상 같은 인스턴스를 반환함

    public static SingletonService getInstance(){
        return instance;
    }

    //딱 한개의 객체 인스턴스만 존재해야 하므로 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.
    private SingletonService(){

    }
    public void logic(){
        log.info("싱글톤 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }
}
