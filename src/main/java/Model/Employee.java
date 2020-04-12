package Model;

public class Employee {
    private String name;
    private String position;
    private String phone;
    private String email;
    private String count;

    public Employee(String name, String position, String phone, String email, String count) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
