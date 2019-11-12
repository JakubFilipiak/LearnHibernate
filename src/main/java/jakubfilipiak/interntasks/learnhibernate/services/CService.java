package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.C;
import jakubfilipiak.interntasks.learnhibernate.repositories.CRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CService {

    private CRepository cRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public CService(CRepository cRepository) {
        this.cRepository = cRepository;
    }

    public C addC(C c) {
        return cRepository.save(c);
    }

    public List<C> addAllCs(List<C> cs) {
        return cRepository.saveAll(cs);
    }

    public Optional<C> getCById(Long id) {
        return cRepository.findById(id);
    }

    public List<C> getAllCs() {
        return cRepository.findAll();
    }

    public long countNumberOfCsByNativeQueryOnRepo() {
        return cRepository.countCsByNativeQuery();
    }

    public long countCsInDbByNativeQueryOnEntityManager() {
        String countSql = "SELECT COUNT(*) FROM C";
        BigInteger csNumber = (BigInteger) entityManager.createNativeQuery(countSql).getSingleResult();
        return csNumber.longValue();
    }

    public long countNumberOfCsByFindAllAndSize() {
        return cRepository.findAll().size();
    }

    public int countNumberOfCsWithGivenNameByNativeQueryOnRepo(String name) {
        return cRepository.countCsWithGivenNameByNativeQuery(name);
    }

    public int countNumberOfCsWithGivenNameByFindNameWithQueryAndSize(String name) {
        return cRepository.findByNameWithQuery(name).size();
    }

    public int countNumberOfCsWithGivenNameByFindByNameAndSize(String name) {
        return cRepository.findByName(name).size();
    }
}
