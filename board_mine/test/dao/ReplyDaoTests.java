package dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Reply;
import lombok.extern.log4j.Log4j;

@Log4j
public class ReplyDaoTests {
	private ReplyDao replyDao = ReplyDao.getInstance();
	@Test
	public void testExist() {
		assertNotNull(replyDao);
		log.info(replyDao);
	}
	@Test
	public void testList() {
		Reply reply = new Reply();
		List<Reply> list = replyDao.list(reply.getBno());
		list.forEach(log::info);
	}
	
	@Test
	public void testRegister() {
		Reply reply = new Reply(null, "비비빅", null, 169L, "bibibik");
		replyDao.register(reply);
		log.info(reply);
		assertNotNull(reply);
	}
	@Test
	public void testModify() {
		Reply reply = new Reply(1L, "modify test", null, 584L, "bibibik");
		replyDao.modify(reply);
		log.info(reply);
	}
	
	@Test
	public void testRemove() {
		Long rno =1L;
		replyDao.remove(rno);
		log.info(rno);
	}
}
