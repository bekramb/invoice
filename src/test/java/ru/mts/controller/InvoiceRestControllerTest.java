package ru.mts.controller;


import org.junit.*;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@WebAppConfiguration
public class InvoiceRestControllerTest {
    private static final Logger LOG = LoggerFactory.getLogger("result");

    private static StringBuilder results = new StringBuilder();

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    MockHttpSession session;

    private MockMvc mockMvc;

    @Rule
    // http://stackoverflow.com/questions/14892125/what-is-the-best-practice-to-determine-the-execution-time-of-the-bussiness-relev
    public Stopwatch stopwatch = new Stopwatch() {
        @Override
        protected void finished(long nanos, Description description) {
            String result = String.format("%-95s %7d", description.getDisplayName(), TimeUnit.NANOSECONDS.toMillis(nanos));
            results.append(result).append('\n');
            LOG.info(result + " ms\n");
        }
    };

    @AfterClass
    public static void printResult() {
        LOG.info("\n-------------------------------------------------------------------------------------------------------" +
                "\nTest                                                                                       Duration, ms" +
                "\n-------------------------------------------------------------------------------------------------------\n" +
                results +
                "-------------------------------------------------------------------------------------------------------\n");
        results.setLength(0);
    }

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).
                build();
    }

    @Test
    public void getAllProduct() throws Exception {
        this.mockMvc.perform(get("/rest/product")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Планшет"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].name").value("Телефон"));
//        this.mockMvc.perform(get("/rest/product")).andDo(print());
//        LOG.info(this.mockMvc.perform(get("/rest/product")).andReturn().getResponse().getContentAsString());
    }


    @Test
    public void getAllSeller() throws Exception {
        this.mockMvc.perform(get("/rest/seller")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("ПАО ФЛЭКС"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].name").value("ИП ИВАНОВ"));
    }

    @Test
    public void getAllCustomer() throws Exception {
        this.mockMvc.perform(get("/rest/customer")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].firstName").value("Иван"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].firstName").value("Петр"));
    }

    @Test
    public void getAllInvoice() throws Exception {
        this.mockMvc.perform(get("/rest/invoice")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].seller.name").value("ПАО ФЛЭКС"))
                .andExpect(jsonPath("$[0].products").isNotEmpty())
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].seller.name").value("ИП ИВАНОВ"))
                .andExpect(jsonPath("$[1].products").isNotEmpty());
    }

    @Test
    public void getInvoicebyName() throws Exception {
        this.mockMvc.perform(get("/rest/invoice/filter?name=ИП ИВАНОВ")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0]seller.name").value("ИП ИВАНОВ"))
                .andExpect(jsonPath("$[0].products").isNotEmpty())
                .andExpect(jsonPath("$[1].seller.name").value("ИП ИВАНОВ"))
                .andExpect(jsonPath("$[1].products").isNotEmpty());
    }
}