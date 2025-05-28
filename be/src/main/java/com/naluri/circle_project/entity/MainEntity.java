package com.naluri.circle_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "main")
public class MainEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;
}
