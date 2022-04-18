package com.example.jpa.many_to_many_addColumn;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class BookPublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_PUBLISHER_ID")
    private Integer id;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "BOOK_ID")
  private Book book;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "PUBLISHER_ID")
  private Publisher publisher;
  private boolean activated;
}
