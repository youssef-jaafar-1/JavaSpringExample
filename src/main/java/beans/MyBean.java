package beans;


//@Component will create only 1 instance of MyBean and places it in the spring context, so if you want to use more than
    // one instance, intialize the instances in ProjectConfig and remove the @Component here.
    //there are situations in which it is enought to have only 1 instance of a specific type
//@Controller //above MyBean instad of Component
//@Service or @Repository above MyBean instead of @Component are the same when creating instances. we will how they are different and when to use each of them
// when using @Repository, we need to do auto wiring in main.java to link the instance to its class and properly initialize the instance
@Component //FLAG 4, instead of using @Bean and declaring instances in ProjectConfig.
public class MyBean { //class whose instances will be placed in spring's context
    //whatever you want

    private string text;

    //@PostConstruct instructs spring it has to call this method immediately after the creation of the component.
        //we can use this annotation with @Component in MyBean.java and with @Bean in ProjectConfig.java
    @PostConstruct //this works only with instances part of the spring context, it won't get called when creating instances that are not part of spring context.
    private void init() {
        this.text = "HELLO";
    }

    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
