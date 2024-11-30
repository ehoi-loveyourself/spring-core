package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // ThreadA: A사용자 10,000원 주문
        statefulService1.order("orderA", 10_000);
        // ThreadB: B사용자 20,000원 주문
        statefulService2.order("orderB", 20_000);

        // ThreadA: A사용자 주문 금액 조회
        int price = statefulService1.getPrice();

        // ThreadA: A사용자는 10,000원을 기대했지만, 기대와는 다르게 20,000원이 출력된다.
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20_000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}