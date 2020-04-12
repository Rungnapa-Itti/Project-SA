package Model;

public class Customer {
    private  String name;
    private  String email;
    private  String nameCompany;
    private  String phone;


    public Customer(String name, String email, String nameCompany, String phone) {
        this.name = name;
        this.email = email;
        this.nameCompany = nameCompany;
        this.phone = phone;

    }



    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getEmail() {
        return email;
    }

    public  void setEmail(String email) {
        this.email = email;
    }

    public  String getNameCompany() {
        return nameCompany;
    }

    public  void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public  String getPhone() {
        return phone;
    }

    public  void setPhone(String phone) {
        this.phone = phone;
    }


}
