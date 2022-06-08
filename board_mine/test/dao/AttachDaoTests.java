package dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Attach;
import lombok.extern.log4j.Log4j;

@Log4j
public class AttachDaoTests {
	private AttachDao attachDao = AttachDao.getInstance();
	
	@Test
	public void testExists() {
		assertNotNull(attachDao);
		log.info(attachDao);
	}
	
	@Test
	public void testList() {
		List<Attach> list = attachDao.list(8L);
		System.out.println(list);
		log.info(list);
	}
	
	@Test
	public void testInsert() {
		Attach attach = new Attach();
		attach.setUuid("test");
		attach.setOrigin("test");
		attach.setPath("test");
		attach.setImage(true);
		attach.setOrd(0);
		attach.setBno(584L);
		attachDao.insert(attach);
		log.info(attach);
	}
	@Test
	public void testRemove() {
		log.info(attachDao.list(584L));
		attachDao.remove(584L);
		log.info(attachDao.list(584L));
	}
}
