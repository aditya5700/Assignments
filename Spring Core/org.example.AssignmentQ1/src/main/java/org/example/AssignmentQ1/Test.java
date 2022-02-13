package org.example.AssignmentQ1;
public class Test {import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

    public class Test {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("AssignmentQ1.xml");

            Address address1 = context.getBean("address1", Address.class);
            System.out.println("Address Class Bean");
            System.out.println(address1);

            System.out.println("**************************************************");

            Customer customer1 = context.getBean("customer1", Customer.class);
            System.out.println("Customer Class Bean ");
            System.out.println(customer1);
        }

    }
}