package cn.utils.c3p0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 王炳智 on 2017/8/23.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Service service = (Service) ctx.getBean("service");
        service.add();

    }

}
