package com.HailMaryAPI.HailMary.Policies;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.HailMaryAPI.HailMary.Clients.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class PolicyConfig {

    @Bean
    CommandLineRunner commandLineRunner(PolicyRepository repository, ClientRepository clientRepository) {
        return args -> {
            Optional<Client> optionalCole = clientRepository.findById(1);
            Client cole = null;
            if(!optionalCole.isEmpty()) {
                cole = optionalCole.get();
            }

            Policy one = new Policy(cole, "Manu15", "Cole", "Kepford",
            "Manulife", "Universal", 500000.0, LocalDate.of(2011, 05, 16), LocalDate.of(2099, 05, 16));

            Policy two = new Policy(cole, "Manu16", "Cole", "Kepford",
            "Manulife", "Term 10", 500000.0, LocalDate.of(2011, 02, 25), LocalDate.of(2021, 02, 25));

            repository.saveAll(List.of(one, two));
        };
    }
    
}