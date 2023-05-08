package com.kbstar.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ItemSearch {
    private String name;
    private Integer price;
    private String startdate;
    private String enddate;

}
