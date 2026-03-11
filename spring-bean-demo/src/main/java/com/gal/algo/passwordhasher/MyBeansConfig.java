package com.gal.algo.passwordhasher;

import com.gal.algo.Calc;
import com.gal.algo.MyCalc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MyBeansConfig {
    //will create beans and provide to spring context, then onwards context will manage
    @Scope("prototype")
    // @Scope("request")
    // @Scope("session")
    // @Scope("application")
    
    @Bean
    StringBuilder getStringBuilder(){
        return new StringBuilder("bean from Configuration");
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/testdb");
        ds.setUsername("root");
        ds.setPassword("123456789");

        return ds;
    }

    @Bean
    @Primary
    Calc getCalc(){
        return new MyCalc();
    }
    @Bean(name="getCalcNamedBean")
    Calc getCalc2(){
        return new MyCalc();
    }
}
