package platform.codingnomads.co.springtest.usingtestresttemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springtest.usingtestresttemplate.NoSuchCoffeePreferanceException;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;
import platform.codingnomads.co.springtest.usingtestresttemplate.repos.CoffeePreferenceRepo;

import java.util.Optional;

@Service
public class CoffeePreferenceService {

    @Autowired
    private CoffeePreferenceRepo repo;

    public CoffeePreference insertNewCoffeePreference(CoffeePreference coffeePreference) {
        return repo.save(coffeePreference);
    }

    public CoffeePreference getCoffeePreferanceById(Long id) throws NoSuchCoffeePreferanceException {
        Optional<CoffeePreference> coffeePreferenceOptional = repo.findById(id);

        if (coffeePreferenceOptional.isEmpty()) {
            throw new NoSuchCoffeePreferanceException("No Coffee Preference with ID " + id + " could be found.");
        }

        CoffeePreference coffeePreference = coffeePreferenceOptional.get();
        return coffeePreference;
    }
}