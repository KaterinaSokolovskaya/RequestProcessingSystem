package com.sokolovskaya.task.service.service;

import com.sokolovskaya.task.database.enumeration.RequestStatus;
import com.sokolovskaya.task.database.model.Request;
import com.sokolovskaya.task.database.repository.RequestRepository;
import com.sokolovskaya.task.database.repository.UserRepository;
import com.sokolovskaya.task.service.dto.AddRequest;
import com.sokolovskaya.task.service.dto.ViewRequestInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;

    public List<ViewRequestInfo> getAllByUserId(Integer id) {
        return requestRepository.findAllByUserId(id)
                .stream()
                .map(it -> ViewRequestInfo.builder()
                        .id(it.getId())
                        .request(it.getRequest())
                        .bid(it.getBid())
                        .date(it.getDueDate())
                        .status(it.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    public Integer addRequest(AddRequest addRequest) {
        return requestRepository.save(Request.builder()
                .request(addRequest.getRequest())
                .bid(addRequest.getBid())
                .dueDate(LocalDate.parse(addRequest.getDate()))
                .status(RequestStatus.WAIT)
                .user(userRepository.findById(addRequest.getUserId()).get())
                .build()).getId();
    }
}
