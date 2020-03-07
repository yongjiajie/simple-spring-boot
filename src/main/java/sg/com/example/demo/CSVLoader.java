package sg.com.example.demo;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import sg.com.example.demo.model.User;
import sg.com.example.demo.model.UserRepository;

import java.io.*;
import java.util.Iterator;

@Component
public class CSVLoader {

    private final Logger log = LoggerFactory.getLogger(CSVLoader.class);

    private final String userCSVFileName = "users.csv";

    @Autowired
    UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    /**
     * Loads the csv file to the UserRepository by reading the csv file, then mapping its contents to User beans using OpenCSV, and finally saving them to the UserRepository.
     */
    public void loadUserCSVToRepository() {
        try {
            File csvFile = new ClassPathResource(userCSVFileName).getFile();
            try (
                    Reader reader = new BufferedReader(new FileReader(csvFile));
            ) {
                CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                        .withType(User.class)
                        .build();

                Iterator<User> userIterator = csvToBean.iterator();
                while (userIterator.hasNext()) {
                    User user = userIterator.next();
                    userRepository.save(user);
                    log.info("Inserted user " + user.getName() + " into repository!");
                }
            }
        } catch (IOException e) {
            log.error("An error occured while loading CSV file: " + userCSVFileName, e);
        }
    }

}
