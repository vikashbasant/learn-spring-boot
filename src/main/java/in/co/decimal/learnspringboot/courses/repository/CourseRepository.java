package in.co.decimal.learnspringboot.courses.repository;

import in.co.decimal.learnspringboot.courses.bean.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
