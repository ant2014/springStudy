package com.cube.springStudy;

import com.cube.springStudy.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("Tome");
        helloWorld.setAge(26);
        helloWorld.say();

        //
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloNewWorld = (HelloWorld) context.getBean("HelloWorld");
        helloNewWorld.say();
    }
}
