package rmu.project.p_sell_id_game.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rmu.project.p_sell_id_game.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
