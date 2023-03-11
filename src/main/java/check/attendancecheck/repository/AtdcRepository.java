package check.attendancecheck.repository;

import check.attendancecheck.entity.Atdc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AtdcRepository extends JpaRepository<Atdc, Long> {
    @Query(value = "SELECT COUNT(a) FROM Atdc a WHERE :memberStdId = a.stdId AND a.date = CONCAT(:date, '%')")
    int findByMember(@Param("memberStdId") String memberStdId, @Param("date") String date);
}
