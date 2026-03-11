package dependencyInjectionUsingMap;

import dependencyInjection.Library1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {

    public static void main(String[] args) {
        BeanFactory beanFactory1 =
                new XmlBeanFactory(new ClassPathResource("map_kit.xml"));

        Kit k1 = (Kit) beanFactory1.getBean("Kit_id");

        System.out.println(k1);
    }
}
