/*
 * retailCustomer_class does not have any additional methods or variables
 * it is a subclass of customer_class
 */
public class retailCustomer_class extends customer_class{
    public retailCustomer_class(String name, String surname, String address, String phone, int ID, int operator_ID, order_class[] order_array) {
        super(name, surname, address, phone, ID, operator_ID, order_array);
    }
}
