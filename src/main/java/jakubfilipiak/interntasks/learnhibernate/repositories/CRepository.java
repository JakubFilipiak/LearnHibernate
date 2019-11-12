package jakubfilipiak.interntasks.learnhibernate.repositories;

import jakubfilipiak.interntasks.learnhibernate.models.C;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRepository extends JpaRepository<C, Long> {

}
