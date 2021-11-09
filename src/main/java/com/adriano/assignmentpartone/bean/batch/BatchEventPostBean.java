package com.adriano.assignmentpartone.bean.batch;


import com.adriano.assignmentpartone.dto.BatchDTO;
import com.adriano.assignmentpartone.service.BatchEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BatchEventPostBean {
    @Autowired
    private BatchEventService batchEventService;
    public ResponseEntity response(BatchDTO input) {
        return ResponseEntity.status(HttpStatus.OK).body( batchEventService.save(input) );
    }
}
