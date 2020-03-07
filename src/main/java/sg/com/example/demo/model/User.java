package sg.com.example.demo.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class User {

    @CsvBindByName
    @GeneratedValue
    private @Id Long id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private Double salary;

}
