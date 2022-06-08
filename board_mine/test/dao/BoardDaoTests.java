package dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.mail.handlers.text_html;

import domain.Board;
import domain.Criteria;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDaoTests {
	private BoardDao boardDao = BoardDao.getInstance();
	
	@Test
	public void testExist() {
		assertNotNull(boardDao);
		log.info(boardDao);
	}
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		cri.setAmount(50);
		List<Board> boards= boardDao.list(cri);
		assertNotNull(boards);
		boardDao.list(cri);
		boards.forEach(log::info);
	}
	@Test
	public void testGet() {
		boardDao.get(169L);
		log.info(boardDao.get(169L));
	}
	@Test
	public void testRegister() {
		Board board= new Board();
		List<Board> boards = new ArrayList<Board>();
		board.setTitle("비비빅");
		board.setContent("맛있지 않음?");
		board.setWriter("bibibik");
		boardDao.register(board);
		log.info(boardDao.get(board.getBno()));
	}
	@Test
	public void testCount() {
		Criteria cri = new Criteria();
		cri.setCategory(2);
		List<Board> boards = boardDao.list(cri);
		boards.forEach(log::info);
	}
	@Test
	public void testModify() {
		Board board = boardDao.get(583L);
		log.info(boardDao.get(583L));
		board.setTitle("modify");
		board.setContent("test");
		boardDao.modify(board);
		log.info(boardDao.get(583L));
	}
	@Test
	public void testRemove() {
		boardDao.remove(300L);
		log.info(boardDao.get(300L));
	}
	@Test
	public void testModifyNullByWriter() {
		Board board = boardDao.get(565L);
		log.info(board);
		boardDao.modifyByWriter(board.getWriter());
		log.info(board.getWriter());
		log.info(board);
	}
		
}
