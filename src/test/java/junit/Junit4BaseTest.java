package junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by adam on 10/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class Junit4BaseTest extends AbstractJUnit4SpringContextTests {

    private static final Logger logger = LoggerFactory.getLogger(Junit4BaseTest.class);

    /**
     *
     * TODO: 测试类实例化前必须要做的一些事情在这里(这个方法在测试类运行的时候只执行一次)
     *
     * @throws Exception void
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        logger.debug("setUpBeforeClass");
    }

    /**
     *
     * TODO: 测试类实例化后必须要做的一些事情在这里(这个方法在测试类运行的时候只执行一次)
     *
     * @throws Exception void
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        logger.debug("tearDownAfterClass");
    }

}
