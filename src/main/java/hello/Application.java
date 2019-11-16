// package hello;

// import java.util.Arrays;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;

// @SpringBootApplication
// public class Application {
    
//     public static void main(String[] args) {
//         ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
//         System.out.println("Let's inspect the beans provided by Spring Boot:");
        
//         String[] beanNames = ctx.getBeanDefinitionNames();
//         Arrays.sort(beanNames);
//         for (String beanName : beanNames) {
//             System.out.println(beanName);
//         }
//     }

// }

package org.telecom.infinispan.cache.solution;

// import java.util.Arrays;

// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.cache.annotation.EnableCaching;
// import org.springframework.scheduling.annotation.EnableScheduling;

// import org.springframework.boot.SpringApplication;
// import org.springframework.context.ApplicationContext;

// @SpringBootApplication
// @EnableCaching
// @EnableScheduling
// public class Application {

//    public static void main(String[] args) {
//       // new SpringApplicationBuilder().sources(Application.class).run(args);
//    		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
// 		System.out.println("Let's inspect the beans provided by Spring Boot:");

// 		String[] beanNames = ctx.getBeanDefinitionNames();
// 		Arrays.sort(beanNames);
// 			for (String beanName : beanNames) {
// 		    System.out.println(beanName);
// 		}
//    }

// }


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class Application {

   public static void main(String[] args) {
      new SpringApplicationBuilder().sources(Application.class).run(args);
   }
}





