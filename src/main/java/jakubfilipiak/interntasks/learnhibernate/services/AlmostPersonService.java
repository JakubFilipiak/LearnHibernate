package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.AlmostPerson;
import jakubfilipiak.interntasks.learnhibernate.repositories.AlmostPersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlmostPersonService {

    private AlmostPersonRepository almostPersonRepository;

    public AlmostPersonService(AlmostPersonRepository almostPersonRepository) {
        this.almostPersonRepository = almostPersonRepository;
    }

    public AlmostPerson addAlmostPerson(AlmostPerson almostPerson) {
        return almostPersonRepository.save(almostPerson);
    }

    public Optional<AlmostPerson> getAlmostPersonById(Long id) {
        return almostPersonRepository.findById(id);
    }
}
