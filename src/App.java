import java.util.Scanner;
import java.io.File;



public class App {
    public static void main(String[] args) throws Exception {
        // open file and read
        File file = new File("/workspaces/customer_tracking/content.txt");
        Scanner fileScanner = new Scanner(file); // Scanner nesnesi oluştur

        /**
         * Define the arrays for the classes
         * customer class contains retail and corporate customers
         */
        operator_class [] operator = new operator_class [100];
        int operator_count = 0;
        order_class [] order = new order_class [100];
        int order_count = 0;
        customer_class [] customers = new customer_class [200];
        int customer_count = 0;

        //control for the no customer or no operator
        int control_for_nFound = 0;
        /**
         * Dosya sonuna kadar oku
         * operator_class: operator;name;surname;address;phone;ID;wage
         * order_class: order;product_name;count;total_price;status;customer_id
         * retail_customer: retail_customer;name;surname;address;phone;ID;operator_ID
         * corporate_customer: corporate_customer;name;surname;address;phone;ID;operator_ID;company_name
         * if one of the datas is empty do not assign to the array
         */

        // TODO: dosyadaki okunan satırda eksik veri varsa atama yapma
        // TODO: aynı id ile kimse olamaz
        // salam
        while (fileScanner.hasNextLine()) {
            String satir = fileScanner.nextLine();
            String[] parcalanmisSatir = satir.split(";"); // ";" ile parçala
            if(parcalanmisSatir[0].equals("operator")){ 
                operator[operator_count] = new operator_class(parcalanmisSatir[1], parcalanmisSatir[2], parcalanmisSatir[3], parcalanmisSatir[4], Integer.parseInt(parcalanmisSatir[5]), Integer.parseInt(parcalanmisSatir[6]), null);
                operator_count++;
            }
            else if(parcalanmisSatir[0].equals("corporate_customer")){
                customers[customer_count] = new corporateCustomer_class(parcalanmisSatir[1], parcalanmisSatir[2], parcalanmisSatir[3], parcalanmisSatir[4], Integer.parseInt(parcalanmisSatir[5]), Integer.parseInt(parcalanmisSatir[6]), null, parcalanmisSatir[7]);
                customer_count++;
            }
            else if(parcalanmisSatir[0].equals("retail_customer")){
                customers[customer_count] = new retailCustomer_class(parcalanmisSatir[1], parcalanmisSatir[2], parcalanmisSatir[3], parcalanmisSatir[4], Integer.parseInt(parcalanmisSatir[5]), Integer.parseInt(parcalanmisSatir[6]), null);
                customer_count++;

            }
            else if(parcalanmisSatir[0].equals("order")){
                order[order_count] = new order_class(parcalanmisSatir[1], Integer.parseInt(parcalanmisSatir[2]), Integer.parseInt(parcalanmisSatir[3]), Integer.parseInt(parcalanmisSatir[4]), Integer.parseInt(parcalanmisSatir[5]));
                order_count++;
            }
        }
        fileScanner.close(); // Scanner nesnesini kapat

        //init the operator customer array
        for(int i=0; i<operator_count; i++){
            operator[i].define_customers(customers);
        }
        //init the customer order array
        for(int i=0; i<customer_count; i++){
            customers[i].define_orders(order);
        }



        Scanner kullaniciGirdisiScanner = new Scanner(System.in); // Kullanıcıdan girdi almak için Scanner nesnesi oluştur
        System.out.println("Please enter your ID...");
        String kullaniciGirdisi = kullaniciGirdisiScanner.nextLine(); // Kullanıcıdan girdi al
        
        for(int i=0; i<operator_count; i++){
            if(String.valueOf(operator[i].ID).equals(String.valueOf(kullaniciGirdisi))){
                System.out.println("*** Operator Screen ***\n");
                operator[i].print_operator();
                control_for_nFound++;
            }
        }
        for(int i=0; i<customer_count; i++){
            if(String.valueOf(customers[i].ID).equals(String.valueOf(kullaniciGirdisi))){
                System.out.println("*** Customer Screen ***\n"+"----------------------------");
                customers[i].print_customer();
                control_for_nFound++;
            }
        }
        if (control_for_nFound==0) {
            System.out.println("No operator/customer was found with ID "+kullaniciGirdisi+". Please try again.");
        }


        kullaniciGirdisiScanner.close(); // Kullanıcı girdisi için Scanner nesnesini kapat
    }
}
