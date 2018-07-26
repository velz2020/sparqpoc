package org.sparqpoc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("org.sparq")
public class SparqPOCApplication {
	
	//private final static Logger logger = LogManager.getLogger(SparqPOCApplication.class);
    public static void main(String[] args) {
    	System.out.println("###########Current Directory = " + System.getProperty("user.dir"));
        SpringApplication.run(SparqPOCApplication.class, args);
        //logger.info("##############just a test info log#############");
    }
}
