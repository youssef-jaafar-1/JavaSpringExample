package config;

@Configuration //annotation that tells Spring this is a configuration class. we can have multiple config classes.
// @ComponentScan(basePackages = "beans") //FLAG 1,2,3
@ComponentScan(basePackages={"Repositories", "Services"}) //Flag5. scan for components in multiple packages.
public class ProjectConfig  {
    //we can have both XML and annoaiton configurations at the same time.
    //we can import one config to the other.
    //

    //we declare an instance of the class we want to use in the config class
    //a method that returns an instance of the bean. this instance will be placed in teh context when we use @bean annotation
    //@Bean is used when declaring methods of the class we want to use, in the ProjetConfig class
    //we return from that method the instance. the instance can be used in the spring context.

    //FLAG1
    @Bean
    @Primary //used when wehave more than 1 instance created in ProjectConfig, indicating that myBean1 is the primary instance to use in the context
    public MyBean myBean1(){
        MyBean b = new MyBean();
        b.setText("Hello");
        return b;
    }

    //2 instances of the same class in the config class
    @Bean
    public MyBean myBean2(){
        MyBean b = new MyBean();
        b.setText("World");
        return b;
    }

    @Bean("C") //here we name the instance C instead of myBean3
    public MyBean myBean3(){
        MyBean b = new MyBean();
        b.setText("World");
        return b;
    }
}
