package com.osumba.product_service.dto.category;

import java.util.UUID;

public record CategoryRecord(
        UUID id,
        String name,
        String description ) { }
