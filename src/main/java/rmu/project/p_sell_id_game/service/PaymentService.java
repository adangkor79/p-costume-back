package rmu.project.p_sell_id_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rmu.project.p_sell_id_game.entity.PaymentEntity;
import rmu.project.p_sell_id_game.repository.PaymentRepository;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository PaymentRepository;

    public PaymentEntity savePayment(PaymentEntity payment) {
        return PaymentRepository.save(payment);
    }

    public Optional<PaymentEntity> getPaymentById(Long id) {
        return PaymentRepository.findById(id);
    }
}
