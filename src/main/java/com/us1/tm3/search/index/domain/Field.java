package com.us1.tm3.search.index.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Field extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, length = 100)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String labelName;
    private String value;
    private String labelValue;
    private String keyId;
    @ManyToOne
    @JoinColumn(name = "filterId")
    private SearchFilter searchFilter;
}
