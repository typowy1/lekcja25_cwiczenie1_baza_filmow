package pl.javastart.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    List<Movie> findByCategory(Category category);
    //to wystarczy ;], nie trzeba nic w ciele pisać poprostu znajdzie, spring data wygeneruje odpowiedni kod sql i wysle do bazy
}
