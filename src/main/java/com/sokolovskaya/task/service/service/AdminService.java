package com.sokolovskaya.task.service.service;

import com.sokolovskaya.task.database.enumeration.RequestStatus;
import com.sokolovskaya.task.database.repository.RequestRepository;
import com.sokolovskaya.task.service.dto.Report;
import com.sokolovskaya.task.service.dto.UpdateStatus;
import com.sokolovskaya.task.service.dto.ViewRequestInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminService {

    private final RequestRepository requestRepository;

    public List<ViewRequestInfo> getAll() {
        return requestRepository.findAll()
                .stream()
                .map(it -> ViewRequestInfo.builder()
                        .id(it.getId())
                        .request(it.getRequest())
                        .bid(it.getBid())
                        .date(it.getDueDate())
                        .userName(it.getUser().getName())
                        .status(it.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    public Report getReport() {
        return Report.builder()
                .allRequests(requestRepository.count())
                .completedRequests(requestRepository.countAllByIdWhereStatusIs(RequestStatus.COMPLETED.toString()))
                .deniedRequests(requestRepository.countAllByIdWhereStatusIs(RequestStatus.DENIED.toString()))
                .build();
    }

    public void updateStatus(UpdateStatus updateStatus) {
        requestRepository.updateStatus(updateStatus.getStatus().name(), updateStatus.getId());
    }
}
