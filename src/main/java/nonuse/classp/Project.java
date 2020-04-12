package nonuse.classp;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private List<String> id = new ArrayList<>();
    private List<String> name = new ArrayList<>();
    private List<String> detial = new ArrayList<>();
    private List<String> startDate = new ArrayList<>();
    private List<String> finishDate = new ArrayList<>();
    private List<String> status = new ArrayList<>();
    private List<String> department = new ArrayList<>();
    private List<String> employeeId = new ArrayList<>();

    public Project(String pid, String pname,String pdetial,String dstartDate,String dfinishDate , String dstatus,String ddepartment,String demployeeID){
        System.out.println(pid+" "+pname+" "+pdetial+" "+dstartDate+" "+dfinishDate+" "+dstatus+" "+ddepartment+" "+demployeeID);
        id.add(String.valueOf(pid));
        name.add(String.valueOf(pname));
        detial.add(String.valueOf(pdetial));
        startDate.add(String.valueOf(dstartDate));
        finishDate.add(String.valueOf(dfinishDate));
        status.add(String.valueOf(dstatus));
        department.add(String.valueOf(ddepartment));
        employeeId.add(String.valueOf(demployeeID));

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

    public List<String> getDetial() {
        return detial;
    }

    public void setDetial(List<String> detial) {
        this.detial = detial;
    }

    public List<String> getStartDate() {
        return startDate;
    }

    public void setStartDate(List<String> startDate) {
        this.startDate = startDate;
    }

    public List<String> getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(List<String> finishDate) {
        this.finishDate = finishDate;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public List<String> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(List<String> employeeId) {
        this.employeeId = employeeId;
    }
}
