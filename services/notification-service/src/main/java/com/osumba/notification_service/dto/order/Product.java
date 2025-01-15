package com.osumba.notification_service.dto.order;

import java.math.BigDecimal;

public record Product(
          Long productId,
          String name,
          String description,
          BigDecimal price,
          double quantity) {
}
