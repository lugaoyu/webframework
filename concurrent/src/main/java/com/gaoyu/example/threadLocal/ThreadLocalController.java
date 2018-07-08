package com.gaoyu.example.threadLocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController
{
        private static final Logger LOG = LoggerFactory.getLogger(ThreadLocalController.class);
        
        @RequestMapping("/test")
        @ResponseBody
        public Long test()
        {
                LOG.info("ThreadLocalController begin");
                return RequestHolder.getId();
        }
}
