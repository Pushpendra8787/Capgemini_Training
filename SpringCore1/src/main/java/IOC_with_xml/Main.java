package IOC_with_xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import javax.sql.rowset.spi.XmlReader;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("beanConfiguration.xml"));
        C1 example = (C1) beanFactory1.getBean("c1");
        System.out.println(example);

        BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("beanConfiguration.xml"));
        C1 example2 = (C1) beanFactory2.getBean("c2");
                ;
        System.out.println(example2);
    }
}
