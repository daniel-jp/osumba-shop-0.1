package com.osumba.payment_service.controller;

import com.osumba.payment_service.dto.PaymentResponse;
import com.osumba.payment_service.entity.Payment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.osumba.payment_service.dto.PaymentRequest;
import com.osumba.payment_service.service.PaymentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    @Autowired
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody @Valid PaymentRequest request){
        paymentService.createPayment(request);
        return  ResponseEntity.ok("Payment successfully ✅");
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAllPayment (){
        return ResponseEntity.ok(paymentService.findAllPayment());
    }

}
