package org.example.entiry;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Message")
@Entity(name = "Message")
@EqualsAndHashCode(of = {"id",})
public class Message {


    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "message")
    private String message;


}
