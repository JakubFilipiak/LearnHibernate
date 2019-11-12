package jakubfilipiak.interntasks.learnhibernate.repositories;

import jakubfilipiak.interntasks.learnhibernate.models.C;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CRepository extends JpaRepository<C, Long> {

    @Query("SELECT COUNT(*) FROM C")
    int countCsByNativeQuery();

    @Query(value = "SELECT COUNT(*) FROM C WHERE C.name = ?1", nativeQuery = true)
    int countCsWithGivenNameByNativeQuery(String name);

    @Query(value = "SELECT * FROM C WHERE C.name = ?1", nativeQuery = true)
    Collection<C> findByNameWithQuery(String name);

    Collection<C> findByName(String name);
}
