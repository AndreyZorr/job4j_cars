package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class PostRepository {

    private final CrudRepository crudRepository;

    public List<Post> findLastDay() {
        return crudRepository.query(
                "From Post Where as create :fCreate",
                Post.class,
                Map.of("fCreate", LocalDateTime.now().minusDays(1))
        );
    }

    private List<Post> findPostAllPhoto() {
        return crudRepository.query("""
                        Select distinct p
                        from Post p Join p.photo
                        Where size(p.photo) > 0""",
                Post.class
        );
    }

    private List<Post> findPostAllBrand(int brandId) {
        return crudRepository.query("From Post Where brand_id :fId",
                Post.class,
                Map.of("fId", brandId)
        );
    }
}
