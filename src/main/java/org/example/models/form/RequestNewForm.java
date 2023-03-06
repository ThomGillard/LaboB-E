package org.example.models.form;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RequestNewForm {

    private LocalDate date;

    private int time;

    private int duration;

    private String reason;

    private List<Long> equipmentsId;


}
