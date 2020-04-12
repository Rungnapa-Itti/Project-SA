package Model;

public class Progress {
    private  String engineerId;
    private String detail;
    private String report_Date;

    public Progress(String employeeId, String detail, String report_Date) {
        this.engineerId = employeeId;
        this.detail = detail;
        this.report_Date = report_Date;
    }

    public String getEmployeeId() {
        return engineerId;
    }

    public void setEmployeeId(String employeeId) {
        this.engineerId = employeeId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getReport_Date() {
        return report_Date;
    }

    public void setReport_Date(String report_Date) {
        this.report_Date = report_Date;
    }
}
