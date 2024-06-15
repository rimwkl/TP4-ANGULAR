package ma.emsi.demo4.repository;

import ma.emsi.demo4.entities.Payment;
import ma.emsi.demo4.entities.PaymentStatus;
import ma.emsi.demo4.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByType(PaymentType type);

    List<Payment> findByStatus(PaymentStatus status);
}
