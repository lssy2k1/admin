package com.kbstar.dto;

import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Sales {
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //오라클에선 date타입인에 자바에서 string타입이면 들어올까?
    private String rdate;
    private int price;
    private String gender;
}

