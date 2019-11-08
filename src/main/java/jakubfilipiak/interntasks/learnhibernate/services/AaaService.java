package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Aaa;
import jakubfilipiak.interntasks.learnhibernate.repositories.AaaRepository;
import org.springframework.stereotype.Service;

@Service
public class AaaService {

    private AaaRepository aaaRepository;

    public AaaService(AaaRepository aaaRepository) {
        this.aaaRepository = aaaRepository;
    }

    public Aaa addAaa(Aaa aaa) {
        return aaaRepository.save(aaa);
    }
}
