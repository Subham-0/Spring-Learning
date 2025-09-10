package com.subham.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spel_config.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student.ternaryCheck);
        System.out.println(student.squareRoot);
        System.out.println(student.pi);
        System.out.println(student.methodRes);

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello Coder'");
        System.out.println(expression.getValue());

    }
}
