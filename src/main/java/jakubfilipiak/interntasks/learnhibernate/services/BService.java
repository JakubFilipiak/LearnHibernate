package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.B;
import jakubfilipiak.interntasks.learnhibernate.repositories.BRepository;
import org.springframework.stereotype.Service;

@Service
public class BService {

    private BRepository bRepository;

    public BService(BRepository bRepository) {
        this.bRepository = bRepository;
    }

    public B addB(B b) {
        return bRepository.save(b);
    }
}
