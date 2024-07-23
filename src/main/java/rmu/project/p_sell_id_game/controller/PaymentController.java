package rmu.project.p_sell_id_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import rmu.project.p_sell_id_game.entity.PaymentEntity;
import rmu.project.p_sell_id_game.model.PaymentModel;
import rmu.project.p_sell_id_game.service.PaymentService;

import org.springframework.beans.BeanUtils;

import java.util.Date;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentEntity> registerPayment(
            @RequestBody PaymentModel paymentDTO,
            @RequestParam("file") MultipartFile file) {

        try {
            PaymentEntity payment = new PaymentEntity();
            BeanUtils.copyProperties(paymentDTO, payment);
            payment.setPaymentDate(new Date());
            payment.setFile(file.getBytes());

            PaymentEntity savedPayment = paymentService.savePayment(payment);
            return ResponseEntity.ok(savedPayment);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentEntity> getPayment(@PathVariable Long id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
