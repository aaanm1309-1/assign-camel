package com.adriano.assignmentpartone.dto;

import lombok.Data;

import java.util.List;
@Data
public class BatchDTO {
    private String batchId;
    private List<RecordDTO> records;

}


//{
//        "batchId": "0310abf6-d1f5-a1b3-8fb0-36fe934b1f28",
//        "records": [
//        {
//        "transId": "0000abf8-d1f5-4536-8fb0-36fe934b1f28",
//        "transTms": "20151022102011927EDT",
//        "rcNum": "10002",
//        "clientId": "RPS-00001",
//        "event": [
//        {
//        "eventCnt": 1,
//        "locationCd": "DESTINATION",
//        "locationId1": "T8C",
//        "locationId2": "1J7",
//        "addrNbr": "0000000001"
//        },
//        {
//        "eventCnt": 1,
//        "locationCd": "CUSTOMER NUMBER",
//        "locationId1": "0007316971"
//        },
//        {
//        "eventCnt": 1,
//        "locationCd": "OUTLET ID",
//        "locationId1": "I029"
//        }
//        ]
//        },