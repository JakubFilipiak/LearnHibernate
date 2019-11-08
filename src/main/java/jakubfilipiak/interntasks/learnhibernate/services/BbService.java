package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Bb;
import jakubfilipiak.interntasks.learnhibernate.repositories.BbRepository;
import org.springframework.stereotype.Service;

@Service
public class BbService {

    private BbRepository bbRepository;

    public BbService(BbRepository bbRepository) {
        this.bbRepository = bbRepository;
    }

    public Bb addBb(Bb bb) {
        return bbRepository.save(bb);
    }
}
