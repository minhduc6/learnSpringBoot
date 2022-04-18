package com.example.jpa.many_to_many_addColumn;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer version;


    @OneToMany(mappedBy = "publisher")
    private Set<BookPublisher> bookPublishers = new HashSet<>();

    public  void addBookPublisher(BookPublisher bookPublisher){
        this.bookPublishers.add(bookPublisher);
    }

}
