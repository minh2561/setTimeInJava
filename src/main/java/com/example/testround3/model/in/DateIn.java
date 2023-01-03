package com.example.testround3.model.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateIn {
    private Integer minhdate;
    private Integer minuteStart;
    private Integer dayStart;
    private Integer monthStart;
    private Integer yearStart;

    private Integer minuteEnd;
    private Integer dayEnd;
    private Integer monthEnd;
    private Integer yearEnd;
}
