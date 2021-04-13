package tdd.practice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UserName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @CreationTimestamp
    private LocalDateTime createdTime;

    public UserName(){
    }
    public UserName(String name) {
        this.userName = name;
    }
}
