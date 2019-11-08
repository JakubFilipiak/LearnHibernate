package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Aaa;
import jakubfilipiak.interntasks.learnhibernate.repositories.AaaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AaaService {

    private AaaRepository aaaRepository;

    public AaaService(AaaRepository aaaRepository) {
        this.aaaRepository = aaaRepository;
    }

    public Aaa addAaa(Aaa aaa) {
        return aaaRepository.save(aaa);
    }

    public Optional<Aaa> getAaaById(Long id) {
        return aaaRepository.findById(id);
    }
}
