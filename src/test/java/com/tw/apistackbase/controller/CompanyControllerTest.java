package com.tw.apistackbase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_200_when_get_all_companies()throws Exception{
        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_204_when_company_not_exist()throws Exception{
        mockMvc.perform(get("/companies/3"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
