import com.demo.ioc.Ioc;
import com.demo.ioc.SpringLifeCycle;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/*
* IOC 让程序员不在关注怎么去创建对象，而是关注与对象创建之后的操作，把对象的创建、初始化、销毁等工作交给spring容器来做。
* 通过spring容器创建的三种方式
* 1.利用默认构造函数创建对象
* 2.利用静态工厂方法
* 3.利用实例工厂方法
*
* spring容器创建对象的时机。
* 在spring的配置文件bean中有一个属性 lazy-init="default/true/false"
 　　　　①、如果lazy-init为"default/false"在启动spring容器时创建对象（默认情况）
　　　　 ②、如果lazy-init为"true",在context.getBean时才要创建对象
* spring的bean中的scope:"singleton/prototype/request/session/global session"
*1.默认scope的值是singleton，即产生的对象是单例的
* 2.scope=“prototype”　多例模式，并且spring容器启动的时候并不会创建对象，而是在得到 bean 的时候才会创建对象
* 在单例模式下，启动 spring 容器，便会创建对象；在多例模式下，启动容器并不会创建对象，获得 bean 的时候才会创建对象
* */
public class TestIoc {
    //传统的new创建对象
    @Test
    public void test() {
        Ioc ioc = new Ioc();
        ioc.sayHelloIoc();
    }

    //Spring 容器利用构造函数创建对象
    @Test
    public void TestIoc() {
        List<Integer> list1 = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            list1.add(i);
        }
        //启动spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从spring容器中取出数据
        Ioc ioc = (Ioc) context.getBean("helloIoc");
        //调用对象方法
        ioc.sayHelloIoc();
        //利用配置文件alias别名属性创建对象
        Ioc ioc2 = (Ioc) context.getBean("helloIoc2");
        ioc2.sayHelloIoc();
    }

    //spring 容器利用静态工厂方法创建对象
    //spring容器只负责调用静态工厂方法。而这个静态工厂方法内部实现由成员完成
    @Test
    public void CreateObjectStaticFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Ioc staticFactory = (Ioc) context.getBean("helloStaticFactory");
        staticFactory.sayHelloIoc();
    }

    /**
     * Spring 容器利用实例工厂方法创建对象
     */
    @Test
    public void createObjectInstanceFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Ioc staticFactory = (Ioc) context.getBean("instance");
        staticFactory.sayHelloIoc();
    }

    //spring 容器的初始化和销毁
    /*
    * spring 容器的声明周期
　　 1、spring容器创建对象
     2、执行init方法
     3、调用自己的方法
     4、当spring容器关闭的时候执行destroy方法
　　注意：当scope为"prototype"时，调用 close（） 方法时是不会调用 destroy 方法的
*/
    @Test
    public void SpringLifeCycle() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringLifeCycle hello = (SpringLifeCycle) context.getBean("SpringLifeCycle");
        hello.sayHello();
        //销毁spring容器
        ClassPathXmlApplicationContext classContext = (ClassPathXmlApplicationContext) context;
        classContext.close();
    }
}
