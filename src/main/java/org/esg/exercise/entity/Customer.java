package org.esg.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customer")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Column(name = "customer-ref")
    private String customerRef;

    @Column(name = "customer-name")
    private String customerName;

    @Column(name = "address-line-one")
    private String addressLineOne;

    @Column(name = "address-line-two")
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
