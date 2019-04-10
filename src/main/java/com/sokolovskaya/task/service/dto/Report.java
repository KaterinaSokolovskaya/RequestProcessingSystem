package com.sokolovskaya.task.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    private Long allRequests;
    private Long completedRequests;
    private Long deniedRequests;
}
