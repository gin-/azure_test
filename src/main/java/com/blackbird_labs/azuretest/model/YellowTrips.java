package com.blackbird_labs.azuretest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Table(name = "yellow_trips")
@Data
@Entity
@ToString
public class YellowTrips {
    @Id
    @Column
    private String vendor_id;
    @Column
    private Date pickup_datetime;
    @Column
    private Date dropoff_datetime;
    @Column
    private int passenger_count;
    @Column
    private double trip_distance;
    @Column
    private int rate_code;
    @Column
    private char store_and_fwd_flag;
    @Column
    private int PULocationID;
    @Column
    private int DOLocationID;
    @Column
    private int payment_type;
    @Column
    private double fare_amount;
    @Column
    private double extra;
    @Column
    private double mta_tax;
    @Column
    private double tip_amount;
    @Column
    private double tolls_amount;
    @Column
    private double improvement_surcharge;
    @Column
    private double total_amount;

}

/*
  vendor_id varchar(3) NOT NULL DEFAULT '0',
  pickup_datetime datetime NOT NULL,
  pickup_year smallint NOT NULL DEFAULT 0,
  pickup_month tinyint NOT NULL DEFAULT 0,
  pickup_day tinyint NOT NULL DEFAULT 0,
  pickup_week tinyint NOT NULL DEFAULT 0,
  pickup_time TIME NOT NULL DEFAULT '00:000:00',
  dropoff_datetime datetime NOT NULL,
  dropoff_year smallint NOT NULL DEFAULT 0,
  dropoff_month tinyint NOT NULL DEFAULT 0,
  dropoff_day tinyint NOT NULL DEFAULT 0,
  dropoff_week tinyint NOT NULL DEFAULT 0,
  dropoff_time TIME NOT NULL DEFAULT '00:000:00',
  pickup_pt geography not null default 'POINT(0,0)',
  dropoff_pt geography not null default 'POINT(0,0)',
  PULocationID smallint NOT NULL DEFAULT 0,
  DOLocationID smallint NOT NULL DEFAULT 0,
  passenger_count tinyint NOT NULL DEFAULT 0,
  trip_distance decimal(6,2) NOT NULL DEFAULT 0,
  rate_code tinyint NOT NULL DEFAULT 0,
  store_and_fwd_flag varchar(1) NOT NULL DEFAULT 'N',
  payment_type tinyint NOT NULL DEFAULT 0,
  fare_amount decimal(6,2) NOT NULL DEFAULT 0,
  surcharge decimal(6,2) NOT NULL DEFAULT 0,
  extra decimal(6,2) NOT NULL DEFAULT 0,
  mta_tax decimal(6,2) NOT NULL DEFAULT 0,
  tip_amount decimal(6,2) NOT NULL DEFAULT 0,
  tolls_amount decimal(6,2) NOT NULL DEFAULT 0,
  improvement_surcharge decimal(6,2) NOT NULL DEFAULT 0,
  total_amount decimal(7,2) NOT NULL DEFAULT 0,

 */