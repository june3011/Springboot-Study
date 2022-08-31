package org.dgsw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      // 객체담는 통이라는 걸 알려줌
public class AppCtx {

    @Bean
    public A a(){
        return new A();
    }

}
