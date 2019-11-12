package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Aaa;
import jakubfilipiak.interntasks.learnhibernate.repositories.AaaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AaaService {

    private AaaRepository aaaRepository;
    private BbbService bbbService;

    public AaaService(AaaRepository aaaRepository, BbbService bbbService) {
        this.aaaRepository = aaaRepository;
        this.bbbService = bbbService;
    }

    @Transactional
    public Aaa addAaa(Aaa aaa) {
//        if (!aaa.getBbbs().isEmpty()) {
//            Set<Bbb> savedBbbs = new HashSet<>();
//            aaa.getBbbs().forEach(bbb -> savedBbbs.add(bbbService.addBbb(bbb)));
//        }
        aaa.getBbbs().forEach(bbb -> bbb.setAaa(aaa));
        return aaaRepository.save(aaa);
    }

    @Transactional
    public Optional<Aaa> getAaaById(Long id) {
        return aaaRepository.findById(id);
    }
}
