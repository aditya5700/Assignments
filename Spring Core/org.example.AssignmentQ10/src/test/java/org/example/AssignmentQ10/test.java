package org.example.AssignmentQ10;

import org.example.AssignmentQ9.Example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class test { public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("A10.xml");
    Example example1 = (Example)context.getBean("example1", Example.class);
    System.out.println(example1);
}
}
