package Model;

public class Project {
    private String name;
    private String engineerName;
    private String customerId;
    private String startDate;
    private String endDate;
    private String state;
    private String detail;

    public Project(String name, String employeeName, String customerName, String startDate,String endDate, String state,String detail) {
        this.name = name;
        this.engineerName = employeeName;
        this.customerId = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getCustomerName() {
        return customerId;
    }

    public void setCustomerName(String customerId) {
        this.customerId = customerId;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }




}
