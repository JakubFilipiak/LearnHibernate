package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.A;
import jakubfilipiak.interntasks.learnhibernate.repositories.ARepository;
import org.springframework.stereotype.Service;

@Service
public class AService {

    private ARepository aRepository;

    public AService(ARepository aRepository) {
        this.aRepository = aRepository;
    }

    public A addA(A a) {
        return aRepository.save(a);
    }
}
