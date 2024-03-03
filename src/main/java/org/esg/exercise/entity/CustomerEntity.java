package org.esg.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerRef;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "address_line_one")
    private String addressLineOne;

    @Column(name = "address_line_two")
    private String addressLineTwo;

    @Column(name = "town")
    private String town;

    @Column(name = "county")
    private String county;

    @Column(name = "country")
    private String country;

    @Column(name = "postcode")
    private String postcode;
}
