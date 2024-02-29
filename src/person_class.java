public class person_class {
/**Variables
 *  name: name of the person
 * surname: surname of the person
 * address: address of the person
 * phone: phone number of the person
 * ID: ID of the person
 */
    protected String name;
    protected String surname;
    protected String address;
    protected String phone;
    protected int ID;

    /**
     * Constructor
     * 
     */
    public person_class(String name, String surname, String address, String phone, int ID) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.ID = ID;
    }

    /**
     * get and set methods for the variables
     */
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }



 

}