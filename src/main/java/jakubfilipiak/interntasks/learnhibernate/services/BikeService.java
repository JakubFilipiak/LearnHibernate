package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Bike;
import jakubfilipiak.interntasks.learnhibernate.repositories.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BikeService {

    private BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Bike addBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    public Optional<Bike> findBikeById(Long id) {
        return bikeRepository.findById(id);
    }
}
