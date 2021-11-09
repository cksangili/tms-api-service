import java.util.Date;

public class TestBean {


    private Integer taskId;


    private String role;


    private String responsible;


    private String status;


    private String taskDescription;


    private Date dueDate;

    private Date createDate;


    private String comments;

    public TestBean(Integer taskId, String role, String responsible, String status, String taskDescription, Date dueDate, Date createDate, String comments) {
        this.taskId = taskId;
        this.role = role;
        this.responsible = responsible;
        this.status = status;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.createDate = createDate;
        this.comments = comments;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
