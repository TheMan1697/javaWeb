package dao;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import domain.Member;
import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDaoTests {
	private MemberDao memberDao = MemberDao.getInstance();
//	private Logger log = Logger.getLogger(MemberDaoTests.class);
		
	
	
	@Test
	public void testExist() {
		log.info(memberDao);
	}
		
	@Test
	public void testLongin() {
		Member member=memberDao.login("bibibik", "1234");
		log.info(member);
		assertNotNull(member);
	}
	
//	@Test
//	public void testEquals() {
//		int[] arr= {1,2,3,4,5};
//		int[] arr2= {1,2,3,4,5};
//		
//		log.info(arr);
//		log.info(arr2);
//		log.info(arr == arr2);
//		log.info(Arrays.equals(arr, arr2));
//		Assert.assertArrayEquals(arr, arr2);
//	}
//	@Test
//	public void testEquals2() {
//		String str = new String("12345");
//		String str2 = new String("12345");
//		
//		log.info(str==str2);
//		log.info(str.equals(str2));
//		Assert.assertSame(str, str2);
//	}
	@Test
	public void testRegister() {
		Member member = new Member();
		member.setId("pigbar");
		member.setPw("1234");
		member.setName("돼지바짱");
		memberDao.register(member);
	}
	@Test
	public void testGet() {
		String id ="bibibik";
		
		log.info(memberDao.get(id));
	}
	
	@Test
	public void testModify() {
		Member member= new Member();
		log.info(memberDao.get("bibibik"));
		member=memberDao.get("bibibik");
		member.setName("test name");
		member.setPw("12345");
		memberDao.modify(member);
		log.info(member);
	}
	
	@Test
	public void testRemove() {
		memberDao.remove("pigbar");
		log.info(memberDao.get("pigbar"));
	}
	@Test
	public void testUpdateAuth() {
		Member member = new Member();
		log.info(memberDao.get("돼지바"));
		member= memberDao.get("돼지바");
		member.setAuth("1");
		memberDao.updateAuth(member);
	}
	@Test
	public void testUpdateAuthToken() {
		Member member = new Member();
		log.info(memberDao.get("돼지바"));
		member= memberDao.get("돼지바");
		member.setAuth_token("12345");
		memberDao.updateAuthToken(member);
	}
	
}
