package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Aa;
import jakubfilipiak.interntasks.learnhibernate.repositories.AaRepository;
import org.springframework.stereotype.Service;

@Service
public class AaService {

    private AaRepository aaRepository;

    public AaService(AaRepository aaRepository) {
        this.aaRepository = aaRepository;
    }

    public Aa addAa(Aa aa) {
        return aaRepository.save(aa);
    }
}
