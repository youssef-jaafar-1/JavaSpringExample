package Repositories;

//Flag 5
//it is not wrong to use @Component, but it is better to specify the correct use of a class, so i use repository instead\
    //from the service (ProductDeliveryService.java)  i use the ProductRepository
@Repository
public class ProductRepository {

    //imagine this method creates some record in the DB
    public void add(){
        System.out.println("a new product was added");
    }
}
