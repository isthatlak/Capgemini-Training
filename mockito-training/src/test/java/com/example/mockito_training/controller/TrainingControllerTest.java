package com.example.mockito_training.controller;

import com.example.mockito_training.dto.TrainingDTO;
import com.example.mockito_training.model.Training;
import com.example.mockito_training.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest      //this will run the project and then you can use httpclient
@WebMvcTest(TrainingController.class)
class TrainingControllerTest{

    @MockitoBean
    TrainingService trainingService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void findById() throws Exception{
        Training t = new Training(101, Date.valueOf("2026-03-07"),Date.valueOf("2026-04-06"), "mockito", "XYZ");
        when(trainingService.findById(101)).thenReturn(new TrainingDTO(t));

        mockMvc.perform(get("/training/101")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.trainingId").value("101"))
                .andDo(res -> System.out.println(res.getResponse().getContentAsString()));
    }
}
