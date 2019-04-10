package com.sokolovskaya.task.database.model;

import com.sokolovskaya.task.database.enumeration.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true, exclude = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "request", schema = "test")
public class Request extends BaseEntity<Integer> {

    @Column(name = "request", nullable = false)
    private String request;

    @Column(name = "bid", nullable = false)
    private Double bid;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RequestStatus status;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
