package com.sokolovskaya.task.service.dto;

import com.sokolovskaya.task.database.enumeration.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewRequestInfo {

    private Integer id;
    private String request;
    private Double bid;
    private LocalDate date;
    private String userName;
    private RequestStatus status;
}
