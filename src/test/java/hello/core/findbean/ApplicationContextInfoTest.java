package hello.core.findbean;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionName) {
            Object bean = ac.getBean(s);
            System.out.println("name = " + s + "bean = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();

        for (String s : beanDefinitionName) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(s);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(s);
                System.out.println("name = " + s + "bean = " + bean);
            }

        }
    }
}
