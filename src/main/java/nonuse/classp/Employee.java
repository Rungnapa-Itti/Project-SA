package nonuse.classp;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private List<String> id = new ArrayList<>();
    private List<String> name = new ArrayList<>();
    private List<String> phone = new ArrayList<>();
    private List<String> email = new ArrayList<>();
    private List<String> managerid = new ArrayList<>();
    private List<String> projectid = new ArrayList<>();

    public Employee(String eid, String ename, String ephone, String eemail, String emanagerid, String eprojectid) {
        System.out.println(eid +" "+ename +" "+ephone + " "+eemail+" "+emanagerid+" "+eprojectid);
        id.add(String.valueOf(eid));
        name.add(String.valueOf(ename));
        phone.add(String.valueOf(ephone));
        email.add(String.valueOf(eemail));
        managerid.add(String.valueOf(emanagerid));
        projectid.add(String.valueOf(eprojectid));

    }

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getManagerid() {
        return managerid;
    }

    public void setManagerid(List<String> managerid) {
        this.managerid = managerid;
    }

    public List<String> getProjectid() {
        return projectid;
    }

    public void setProjectid(List<String> projectid) {
        this.projectid = projectid;
    }
}
