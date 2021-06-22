package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Donation;

import java.util.List;


public interface DonationRepository extends JpaRepository<Donation, Long> {

    default Long getNumberOfBags(){
        List<Donation> donations = findAll();
        Long sum = 0L;
        for(Donation d : donations){
            sum += d.getQuantity();
        }
        return sum;
    }

}
