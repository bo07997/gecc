package testCrawer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaomaoguai.gecco.mapper.bookInfoMapper;
import com.xiaomaoguai.gecco.service.myservice.BookInfoService;
import com.xiaomaoguai.gecco.testcrawler.bookInfo;
/**
 * Created by codingBoy on 16/11/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring-context.xml,springmvc-servlet.xml"})
public class testSpring {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
	private bookInfoMapper bookInfoMapper;

    @Test
    public void getSeckillList() throws Exception {
    	bookInfo result  = bookInfoMapper.selectByPrimaryKey("f3cc41dcd56391e0");
        System.out.println();

    }

  
}
