package com.adriano.assignmentpartone.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EventDTO {

    private UUID eventId;

    private String transId;

    private String transTms;

    private String rcNum;

    private String clientId;

    private Long eventCnt;

    private String locationCd;

    private String locationId1;

    private String locationId2;

    private String addrNbr;
}
