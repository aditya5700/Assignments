package Assignment9_2;
import AssignmentQ9.AnnotationBeanLifeCycle;
import AssignmentQ9.InterfaceBeanLifeCycle;
import AssignmentQ9.XmlBeanLifeCycle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {public static void main(String[] args) {
    //This is the code segment for implementing bean lifecycle for XML.
    AbstractApplicationContext context = new ClassPathXmlApplicationContext("AssignmentQ9.xml");
    AssignmentQ9.XmlBeanLifeCycle obj = (XmlBeanLifeCycle) context.getBean("XML1");

    System.out.println(obj);

    context.registerShutdownHook();
}


}
