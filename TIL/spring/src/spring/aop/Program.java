package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

public class Program {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
//				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		
		Exam exam = (Exam) context.getBean("exam"); 
		
		System.out.printf("total is %d\n", exam.total());
		System.out.printf("avg is %f\n", exam.avg());
		
		/*
		Exam exam = new NewlecExam(1,1,1,1);
		
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
				new Class[] {Exam.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//이곳에 Handler 의 core 작성
						//위아래에 곁다리 업무, 가운데에 실제 업무 호출하는 코드
						
						long start = System.currentTimeMillis();
						
						//실제 업무 호출하는 로직
						Object result = method.invoke(exam, args);
						
						long end = System.currentTimeMillis();
						
						String message = (end - start)+"ms 시간이 걸렸습니다";
						System.out.println(message);
						
						return result;
					}
				}
			); 
		*/
		
//		System.out.printf("total is %d\n", exam.total());
		
	}

}
