package me.myarmy.service;

import lombok.extern.slf4j.Slf4j;
import me.myarmy.api.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Manki Kim on 2017-04-02.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void areaTest(){
         List<Object> result = this.categoryService.area("서울");
        assertThat(result).isNotNull();
    }
}
