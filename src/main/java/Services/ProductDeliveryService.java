package Services;


import Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

//Flag 5
//@service will tell that in our app ProductDeliveryService has the role of a service
@Service
public class ProductDeliveryService {

    //by using the @Autowired annotation, you instruct sprin to take from the context a value, and use it
        //in addSomeProduct(). productRepository.add() will no longer be a null value, but will be the value
        //of the component created by spring inside the context (in ProductRepository.java).
        //so now productRepository.add() won't return a null value. or NullPointerException
    @Autowired //Autowired can be used on the field directly, or on the constructor or on the setup.
    private ProductRepository productRepository;

    public void addSomeProduct() {
        //we need to give productRepository a value in the context in order for it to not be null
        productRepository.add();
        productRepository.add();
        productRepository.add();

    }
}
