package SRMS_app_1.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SRMS_app_1.com.entities.PendingPayment;

@Repository
public interface PendingPaymentRepository extends JpaRepository<PendingPayment, Long>{

}
