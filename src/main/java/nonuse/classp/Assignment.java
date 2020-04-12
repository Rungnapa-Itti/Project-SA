package nonuse.classp;

import java.util.List;

public class Assignment {

    private List<String> id;
    private List<String> name;
    private List<String> detail;
    private List<String> startDate;
    private List<String> finnishDate;
    private List<String> status;
    private List<String> department;
    private List<String> employeeid;

    public Assignment(String aid, String aname, String adetail, String astartDate, String afinnishDate, String astatus, String adepartment, String aemployeeid) {
      id.add(aid);
      name.add(aname);
      detail.add(adetail);
      startDate.add(astartDate);
      finnishDate.add(afinnishDate);
      status.add(astatus);
      department.add(adepartment);
      employeeid.add(aemployeeid);
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

    public List<String> getDetail() {
        return detail;
    }

    public void setDetail(List<String> detail) {
        this.detail = detail;
    }

    public List<String> getStartDate() {
        return startDate;
    }

    public void setStartDate(List<String> startDate) {
        this.startDate = startDate;
    }

    public List<String> getFinnishDate() {
        return finnishDate;
    }

    public void setFinnishDate(List<String> finnishDate) {
        this.finnishDate = finnishDate;
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

    public List<String> getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(List<String> employeeid) {
        this.employeeid = employeeid;
    }
}
