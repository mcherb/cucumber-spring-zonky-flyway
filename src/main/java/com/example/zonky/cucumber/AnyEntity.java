package com.example.zonky.cucumber;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "any_entity")
public class AnyEntity {

    @Id
    private Long id;

    private String name;
}
