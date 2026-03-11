package dependencyInjection;

import IOC_with_xml.C1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args) {
        System.out.println("Library Bean----------------------");
        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("dependencyInjection.xml"));
        Library l1 = (Library) beanFactory1.getBean("L1");
        System.out.println(l1);

        System.out.println("Book Bean----------------------");
        BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("dependencyInjection.xml"));
        Book b1 = (Book) beanFactory2.getBean("B1");
        System.out.println(b1);


        System.out.println("Library1 Bean----------------------");
        BeanFactory beanFactory3 =
                new XmlBeanFactory(new ClassPathResource("listDependencyInjection.xml"));

        Library1 lib = (Library1) beanFactory3.getBean("Lib1");

        System.out.println(lib);





    }
}
