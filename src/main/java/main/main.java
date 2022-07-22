package main;

import Services.ProductDeliveryService;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//context = collection of instances the framework knows and managed by the framework. in our case the framework is Spring.
public class main {
    /**
     * context can be configured using XML or annotations
     *
     */
    public static void main(String[] args){
        //our main context has to be configured somewhere
        //this context is configured using hte ProjectConfig class
        try(var context =
                    new AnnotationConfigApplicationContext(ProjectConfig.class)){

        //FLAG1
        //b1, b2, b3 are the same bean we have created in the config class
            //they reference the same instance created in ProjectConfig class
            //here we created an instance and put it in spring context
        //using a bean by type
        MyBean b1 = context.getBean(MyBean.class); // it is the bean created in the ProjectConfig file
        MyBean b2 = context.getBean(MyBean.class); // it is the bean created in the ProjectConfig file
        MyBean b3 = context.getBean(MyBean.class); // it is the bean created in the ProjectConfig file

        //using a bean by name: when we do not want to define a default bean to use in ProjectConfig
            //used to tell spring which bean we want in addition to its type
        //by name
        //FLAG 2
        MyBean b4 = context.getBean(name: "myBean1", MyBean.class);
        //FLAG 3
        MyBean b5 = context.getBean(name: "C", MyBean.class);


        System.out.println(b1.getText()); //should print hello

            //now using stereoptype annotation:
                //if we did not declare any instances of type MyBean in ProjectConfig class, we can
                // use @Component above the class MyBean, this way I tell Spring that the class will create an instance
                // and that instance is 1 component that is part of the context
            // but also, in the config class, we have to use an annotation called @ComponentScan above the class ProjectConfig
                //@ComponentScan(basePackages = "beans") used to specify teh packages in which spring shoul find classes annotated with
                //stereotype annotations @Component
            //also, we have to initialize the private String text in MyBean class. so we define an init method in MyBean.java
                // to initialize the instance after its creation, we use @PostConstruct

        //FLAG 5 --
            //by type
        ProductDeliveryService service = context.getBean(ProductDeliveryService.clas);
        service.addSomeProduct();
        }
    }
}


//errors:
//NoSuchBeanDefinitonException: if we did not define an instance of the class we want in the ProjectConfig class
//NoUniqueBeanDefinitionException: when we have  more than 1 instance of the same class, and we use the instances
    //in the context while referencing the instance by type.
    //sol1 => tell spring that one of the beans will be defaulted. use @Primary above the instance you want as primary.
    //sol2 => request a bean by its method name AND by the bean type