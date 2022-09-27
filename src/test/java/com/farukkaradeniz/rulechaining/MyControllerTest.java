package com.farukkaradeniz.rulechaining;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyController.class)
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @SneakyThrows
    @ParameterizedTest
    @CsvSource({
            "ömer,karadeniz,16,true",
            "ömer,karadeniz,66,true",
            "ömer,,26,true",
            ",karadeniz,26,true",
            ",,26,true",
    })
    void test_fails(String name, String surname, Integer age, Boolean bold) {
        var request = new Person(name, surname, age, bold);

        var mvcRequest = MockMvcRequestBuilders.post("/")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(mvcRequest)
                .andExpect(status().isBadRequest());
    }

    @SneakyThrows
    @ParameterizedTest
    @CsvSource({
            "ömer,karadeniz,26,false",
    })
    void test_success(String name, String surname, Integer age, Boolean bold) {
        var request = new Person(name, surname, age, bold);

        var mvcRequest = MockMvcRequestBuilders.post("/")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(mvcRequest)
                .andExpect(status().isOk());
    }

    @SneakyThrows
    private String asJsonString(Object o) {
        return new ObjectMapper().writeValueAsString(o);
    }
}
