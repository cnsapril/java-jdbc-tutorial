package cn.cns.jdbctemplatetutorial;

import cn.cns.jdbctemplatetutorial.dao.RuleValueDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JdbcTemplateTutorialApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JdbcTemplateTutorialApplication.class, args);

		RuleValueDao ruleValueDao = ctx.getBeanFactory().getBean(RuleValueDao.class);

		boolean isInvalid = ruleValueDao.isLEOUInvalid("0036", "12345");
		System.out.println(isInvalid);
	}
}
