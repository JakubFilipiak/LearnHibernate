package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Bbb;
import jakubfilipiak.interntasks.learnhibernate.repositories.BbbRepository;
import org.springframework.stereotype.Service;

@Service
public class BbbService {

    private BbbRepository bbbRepository;

    public BbbService(BbbRepository bbbRepository) {
        this.bbbRepository = bbbRepository;
    }

    public Bbb addBbb(Bbb bbb) {
        return bbbRepository.save(bbb);
    }
}
