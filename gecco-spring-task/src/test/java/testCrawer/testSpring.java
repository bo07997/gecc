package testCrawer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaomaoguai.gecco.service.myservice.BookInfoService;
import com.xiaomaoguai.gecco.testcrawler.bookInfo;
/**
 * Created by codingBoy on 16/11/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring-context.xml"})
public class testSpring {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
  @Autowired
    private BookInfoService bookInfoService;

    @Test
    public void getSeckillList() throws Exception {
    	bookInfo bookInfo =new bookInfo("HUIHIU", "15614564", "无尽", "LDB", "KHFKHFDSKDFS", "545", "54", "66", "13", "JKSJFDKS.COM", "CNKJCSHUIHSD");
    	bookInfoService.insertBookInfo(bookInfo);
        System.out.println();

    }

  
}
