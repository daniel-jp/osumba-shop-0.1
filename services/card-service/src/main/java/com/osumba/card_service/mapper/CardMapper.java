package com.osumba.card_service.mapper;

import com.osumba.card_service.dto.CardRequest;
import com.osumba.card_service.dto.CardResponse;
import com.osumba.card_service.entity.Card;
import org.springframework.stereotype.Service;

@Service
public class CardMapper {


    public Card toPayment(CardRequest request) {

        return  Card.builder()
                .id(request.id())
                .cardNumber(request.cardNumber())
                .carHolder(request.carHolder())
                .expiryDate(request.expiryDate())
                .cw(request.cw())
                //.orderId(request.orderId())
                .build();

    }


    public Card toCardResponse(CardResponse card) {
        return new Card(
                card.id(),
                card.cardNumber(),
                card.carHolder(),
                card.expiryDate(),
                card.cw()


        );
    }
}
