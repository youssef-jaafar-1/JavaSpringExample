package Services;


import Repositories.ProductRepository;

//Flag 5
//@service will tell that in our app ProductDeliveryService has the role of a service
@Service
public class ProductDeliveryService {

    private ProductRepository productRepository;

    public void addSomeProduct() {
        //we need to give productRepository a value in the context in order for it to not be null
        productRepository.add();
        productRepository.add();
        productRepository.add();

    }
}
