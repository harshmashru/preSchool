package pojo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class user {
    Integer ID;
    @Id
    Integer AID;
    String NAME;
    String EmailAdd;
    String Mobile_no;
    String Password;
    Float Salary;
    String status;
    @OneToMany(mappedBy="use")
    private student std;
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAID() {
        return AID;
    }

    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public student getStd() {
        return std;
    }

    public void setStd(student std) {
        this.std = std;
    }
    
    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getEmailAdd() {
        return EmailAdd;
    }

    public void setEmailAdd(String EmailAdd) {
        this.EmailAdd = EmailAdd;
    }

    public String getMobile_no() {
        return Mobile_no;
    }

    public void setMobile_no(String Mobile_no) {
        this.Mobile_no = Mobile_no;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Float getSalary() {
        return Salary;
    }

    public void setSalary(Float Salary) {
        this.Salary = Salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
