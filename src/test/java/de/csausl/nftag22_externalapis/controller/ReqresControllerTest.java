package de.csausl.nftag22_externalapis.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureMockRestServiceServer
class ReqresControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MockRestServiceServer mockServer;

    @Test
    void getUsers_ShouldReturnListofUsers_WhenCalled() throws Exception {
        // GIVEN
        mockServer.expect(requestTo("https://reqres.in/api/users"))
                        .andExpect(method(HttpMethod.GET))
                                .andRespond(withSuccess("""
                                               {
                                               "page": 2,
                                               "per_page": 6,
                                               "total": 12,
                                               "total_pages": 2,
                                               "data": [
                                                   {
                                                       "id": 7,
                                                       "email": "michael.lawson@reqres.in",
                                                       "first_name": "Michael",
                                                       "last_name": "Lawson",
                                                       "avatar": "https://reqres.in/img/faces/7-image.jpg"
                                                   }
                                               ],
                                               "support": {
                                                   "url": "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",
                                                   "text": "Tired of writing endless social media content? Let Content Caddy generate it for you."
                                               }
                        """, MediaType.APPLICATION_JSON));

        // WHEN&THEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                               [{
                                                       "id": 7,
                                                       "email": "michael.lawson@reqres.in",
                                                       "first_name": "Michael",
                                                       "last_name": "Lawson",
                                                       "avatar": "https://reqres.in/img/faces/7-image.jpg"
                               }]
                               """));
    }
}