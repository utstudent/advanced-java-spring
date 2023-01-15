package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepo extends JpaRepository<House, Long> {

    List<House> findByAddress(String address);

    List<House> findByAddressIsNot(String address);

    List<House> findByAddressContaining(String address);

    List<House> findById(String address);

    List<House> findByBedroomNumIs(Integer bedroomNum);

    List<House> findByBedroomNumGreaterThan(int bedroomNum);

    List<House> findByYearBuiltIs(int yearBuilt);

    List<House> findByYearBuiltGreaterThan(int yearBuilt);

    List<House> findTop2ByBedroomNumGreaterThan(int bedroomNum);

    List<House> findByBathroomNumIs(int bathroomNum);

    List<House> findByBathroomNumGreaterThanEqual(int bathroomNum);

    List<House> findByBedroomNumGreaterThanAndBathroomNumGreaterThanEqual(int bedroomNum, int bathroomNum);
}
