package pl.pkolkiew.dddhexarch.base

import groovy.transform.TypeChecked
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import pl.pkolkiew.dddhexarch.DddHexArchApplication
import spock.lang.Specification

/**
 * @author pkolkiew* Created 22.07.2019
 */
@TypeChecked
@SpringBootTest(classes = DddHexArchApplication.class)
@ActiveProfiles("test")
@Rollback
abstract class IntegrationSpec extends Specification {

    @Autowired
    private WebApplicationContext webApplicationContext

    MockMvc mockMvc

    @Before
    void before() {
        //setUp
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//                .apply(springSecurity())
                .build()
    }

}
