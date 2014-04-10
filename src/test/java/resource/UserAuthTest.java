package resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import admin.rssreader.resource.AuthResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class UserAuthTest {

	@Autowired
	AuthResource authResource;
	
	@Test
	public void test() {
		System.out.println(authResource.auth("admin", "de128adee6d5143bcf8c463e93b6496b"));
	}
}
