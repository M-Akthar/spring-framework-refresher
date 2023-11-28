package com.in28minutes.springframeworkrefresher.repository;

import com.in28minutes.springframeworkrefresher.repository.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
