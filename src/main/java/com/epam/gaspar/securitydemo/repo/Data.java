package com.epam.gaspar.securitydemo.repo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Data {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    @Column(name = "create_timestamp")
    @CreationTimestamp
    private Instant createTimestamp;

    public static Data of(String key, String value) {
        return Data.builder()
                .key(key)
                .value(value)
                .build();
    }

}
