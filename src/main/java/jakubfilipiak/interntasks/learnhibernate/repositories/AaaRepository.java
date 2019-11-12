package jakubfilipiak.interntasks.learnhibernate.repositories;

import jakubfilipiak.interntasks.learnhibernate.models.Aaa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AaaRepository extends JpaRepository<Aaa, Long> {

    @Query("select a from Aaa a left join fetch a.bbbs where a.id = :id")
    Optional<Aaa> findById(Long id);
}
