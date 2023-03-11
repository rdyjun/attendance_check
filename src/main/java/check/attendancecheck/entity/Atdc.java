package check.attendancecheck.entity;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "attendanceCheckList")
public class Atdc {
    @Id @Column(name = "atdcId", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "studentId")
    private String stdId;

    @Column(name = "date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String date;

    @Column(name = "type")
    private String type;

    public Atdc (Member member, String type, String date) {
        this.name = member.getName();
        this.stdId = member.getStdId();
        this.date = date;
        this.type = type;
    }
}
