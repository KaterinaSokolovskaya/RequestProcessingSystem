package com.sokolovskaya.task.database.repository;

import com.sokolovskaya.task.database.model.Request;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Integer> {

    List<Request> findAll();

    List<Request> findAllByUserId(Integer userId);

    Request save(Request request);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "update test.request set status = :status where id = :id", nativeQuery = true)
    void updateStatus(@Param("status") String status, @Param("id") Integer id);

    @Query(value = "select count(id) from test.request where status = :status group by status", nativeQuery = true)
    Long countAllByIdWhereStatusIs(@Param("status") String requestStatus);
}
