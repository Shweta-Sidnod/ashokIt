package com.carrental.CarRental.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class HotelDto {
    private String id;
    private String hotel;
    private String room;
    private Integer stay;
    private String manageParking;
    private Double finalCost;
}
