package service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberServiceTests {
	private MemberService memberService = MemberService.getInstance();
	
	@Test
	public void testExist() {
		assertNotNull(memberService);
		log.info(memberService);
	}
		
}
