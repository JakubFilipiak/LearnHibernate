package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.C;
import jakubfilipiak.interntasks.learnhibernate.repositories.CRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CService {

    private CRepository cRepository;

    public CService(CRepository cRepository) {
        this.cRepository = cRepository;
    }

    public C addC(C c) {
        return cRepository.save(c);
    }

    public Optional<C> getCById(Long id) {
        return cRepository.findById(id);
    }
}
