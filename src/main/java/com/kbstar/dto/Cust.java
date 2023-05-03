package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
//화면에서 값이 들어오거나, 데이터베이스에 넣기 위해 셋팅할때 모두 에러남
public class Cust {
    @Size(min=4, max=10, message = "ID는 최소 4글자, 최대 10글자")//내가 정한 사이즈 이외엔 오류야.
    @NotEmpty(message = "아이디는 필수항목입니다.")//빈값 오류
    private String id;
    @Size(min=5, max=10, message = "PWD는 최소 5글자, 최대 10글자")//내가 정한 사이즈 이외엔 오류야.
    @NotEmpty(message = "패스워드는 필수항목입니다.")//빈값 오류
    private String pwd;
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

}
