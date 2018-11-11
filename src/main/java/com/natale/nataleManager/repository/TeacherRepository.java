package com.natale.nataleManager.repository;

import com.natale.nataleManager.model.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {
}
