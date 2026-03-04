package com.Architecture_Website.Architecture_Website.Request;

import java.time.LocalDateTime;

public record TicketRequest(
        String name,
        Integer area,
        String phone,
        String budget,
        String typeOfConsulting,
        LocalDateTime timeReceipt,
        String description
) {
}
