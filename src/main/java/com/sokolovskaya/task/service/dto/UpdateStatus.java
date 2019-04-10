package com.sokolovskaya.task.service.dto;

import com.sokolovskaya.task.database.enumeration.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStatus {

    private Integer id;

    @NotNull
    private RequestStatus status;

    private Integer userId;
}
