package com.example.colectivoIkuna.application.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class EventCalendarDTO {
    private long id;
    private String activityName;
    private String dateTime;
    private BigDecimal percentageProgress;
}
