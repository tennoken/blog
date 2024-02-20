package io.blog.Repository;

import io.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BlogRepository extends JpaRepository<Blog , Integer> {

}
