package pl.pkolkiew.dddhexarch

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.ResultActions
import pl.pkolkiew.dddhexarch.base.IntegrationSpec
import pl.pkolkiew.dddhexarch.user.domain.SampleUsers
import pl.pkolkiew.dddhexarch.user.domain.UserFacade

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * @author pkolkiew* Created 22.07.2019
 */
@ActiveProfiles("in-memory")
class UserControllerAcceptanceSpec extends IntegrationSpec implements SampleUsers {

    @Autowired
    UserFacade userFacade

    @WithMockUser
    def "positive add user with pagination"() {

        given: "There are users with login: 'login111' and 'login999' in system"
            userFacade.addUser(user1)
            userFacade.addUser(user2)

        when: "I go to /users"
            ResultActions getUsers = mockMvc.perform(get("/user/users"))
        then: "I found two users"
            getUsers.andExpect(status().isOk())
                    .andExpect(content().json("{\n" +
                            "    \"content\": [\n" +
                            "        {\n" +
                            "            \"login\": \"$user1.login\",\n" +
                            "            \"pass\": \"$user1.pass\",\n" +
                            "            \"isActive\": 1\n" +
                            "        },\n" +
                            "        {\n" +
                            "            \"login\": \"$user2.login\",\n" +
                            "            \"pass\": \"$user2.pass\",\n" +
                            "            \"isActive\": 1\n" +
                            "        }\n" +
                            "    ],\n" +
                            "    \"pageable\": {\n" +
                            "        \"sort\": {\n" +
                            "            \"sorted\": false,\n" +
                            "            \"unsorted\": true,\n" +
                            "            \"empty\": true\n" +
                            "        },\n" +
                            "        \"offset\": 0,\n" +
                            "        \"pageSize\": 20,\n" +
                            "        \"pageNumber\": 0,\n" +
                            "        \"paged\": true,\n" +
                            "        \"unpaged\": false\n" +
                            "    },\n" +
                            "    \"totalPages\": 1,\n" +
                            "    \"totalElements\": 2,\n" +
                            "    \"last\": true,\n" +
                            "    \"size\": 20,\n" +
                            "    \"number\": 0,\n" +
                            "    \"sort\": {\n" +
                            "        \"sorted\": false,\n" +
                            "        \"unsorted\": true,\n" +
                            "        \"empty\": true\n" +
                            "    },\n" +
                            "    \"numberOfElements\": 2,\n" +
                            "    \"first\": true,\n" +
                            "    \"empty\": false\n" +
                            "}"
                    ))

        then: "cleaning repo"
            userFacade.delete(user1.login)
            userFacade.delete(user2.login)
    }

    // TODO: dont work yet

//    @WithMockUser
//    def "delete both users"() {
//
//        given: "we have users in db already"
////        userFacade.addUser(user1)
////        userFacade.addUser(user2)
//
//        when: "I delete both users"
//            userFacade.delete(user1.login)
//            userFacade.delete(user2.login)
//
//        then: "I'm checking if users have been deleted"
//            UserQueryDto userQueryDto1 = UserQueryDto.builder().login(user1.login).build();
//            UserQueryDto userQueryDto2 = UserQueryDto.builder().login(user2.login).build();
//
//            ResultActions findUser1 = mockMvc.perform(get("/show")
//                    .accept(MediaType.APPLICATION_JSON)
//                    .content("{\n" +
//                            "\t\"login\": \"$user1.login\"\n" +
//                            "}"))
//
//            ResultActions findUser2 = mockMvc.perform(get("/show")
//                    .accept(MediaType.APPLICATION_JSON)
//                    .content("{\n" +
//                            "\t\"login\": \"$user2.login\"\n" +
//                            "}"))
//
//        findUser1.andExpect(status().is(404))
//                    .andExpect(content().json("{\n" +
//                            "\t\"code\": \"404\",\n" +
//                            "\t\"message\": \"userNotFound\",\n" +
//                            "\t\"details\": \"brak\",\n" +
//                            "\t\"path\": \"/show\",\n" +
//                            "\t\"userMessage\": \"No user with given login found\"\n" +
//                            "}"))
//
//        def result2 = findUser2.andExpect(status().is(404))
//                    .andExpect(content().json("{\n" +
//                            "    \"code\": \"404\",\n" +
//                            "    \"message\": \"userNotFound\",\n" +
//                            "    \"details\": \"brak\",\n" +
//                            "    \"path\": \"/show\",\n" +
//                            "    \"userMessage\": \"No user with given login found\"\n" +
//                            "}")).andReturn();
//
//    }

    @WithMockUser
    def "positive add user without pagination"() {

        given: "There are users with login: 'login111' and 'login999' in system"
            userFacade.addUser(user1)
            userFacade.addUser(user2)

        when: "I go to /users"
            ResultActions getUsers = mockMvc.perform(get("/user/users"))
            then: "I found two users"
            getUsers.andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"content\": [\n" +
                        "        {\n" +
                        "            \"login\": \"$user1.login\",\n" +
                        "            \"pass\": \"$user1.pass\",\n" +
                        "            \"isActive\": 1\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"login\": \"$user2.login\",\n" +
                        "            \"pass\": \"$user2.pass\",\n" +
                        "            \"isActive\": 1\n" +
                        "        }\n" +
                        "    ]}"
                ))
    }

}
