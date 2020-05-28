package pojo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class student {
    @Id
    Integer AID;
    Integer SID;
    String SNAME;
    String P_EmailAdd;
    String P_Mobileno;
    String Password;
    Float Fees;
    String Status;
    @ManyToOne 
    user use;
    public Integer getAID() {
        return AID;
    }
    
    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public Integer getSID() {
        return SID;
    }

    public void setSID(Integer SID) {
        this.SID = SID;
    }

    public user getUse() {
        return use;
    }

    public void setUse(user use) {
        this.use = use;
    }
    
    public String getSNAME() {
        return SNAME;
    }

    public void setSNAME(String SNAME) {
        this.SNAME = SNAME;
    }

    public String getP_EmailAdd() {
        return P_EmailAdd;
    }

    public void setP_EmailAdd(String P_EmailAdd) {
        this.P_EmailAdd = P_EmailAdd;
    }

    public String getP_Mobileno() {
        return P_Mobileno;
    }

    public void setP_Mobileno(String P_Mobileno) {
        this.P_Mobileno = P_Mobileno;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Float getFees() {
        return Fees;
    }

    public void setFees(Float Fees) {
        this.Fees = Fees;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
