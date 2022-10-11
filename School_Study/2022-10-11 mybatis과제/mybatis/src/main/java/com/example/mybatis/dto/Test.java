package com.example.mybatis.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
@Data
public class Test {

//    Test(String aa, String bb){
//        this.aa = aa;
//        this.bb = bb;
//    }
// AllArgsConstructor 쓰면 안 써도됨

    private Long idx;

    @NotEmpty
    private String aa;
    @NotEmpty
    private String bb;


}
