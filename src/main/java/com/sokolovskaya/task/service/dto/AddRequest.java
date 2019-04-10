package com.sokolovskaya.task.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddRequest {

    @NotBlank
    private String request;

    @NotNull
    private Double bid;

    @NotBlank
    private String date;

    private Integer userId;
}
