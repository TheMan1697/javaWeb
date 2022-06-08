package domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDto {
	private static final int PAGE_COUNT = 10;
	private int start;//시작 숫자 11
	private int end; //종료 숫자 13
	private int total;//게시글 총 갯수
		
	private boolean next;// 다음 페이지 가능여부
	private boolean prev;//이전 페이지 가능여부
	private Criteria criteria;//pageNum, amount
	
	//total,page,amount 
	
	public PageDto(int total, Criteria criteria) {
		this.total = total;
		this.criteria = criteria;
		
		//1 10
		//2 10
		//3 10
		//4 10
		//10 10
		//11 20
		
		end=(criteria.getPageNum()+(PAGE_COUNT-1))/PAGE_COUNT*PAGE_COUNT;
		start = end-PAGE_COUNT+1;
		//		end = (total+9)/criteria.getAmount();
		
		int realEnd = (total + (criteria.getAmount()-1))/criteria.getAmount();
		if(realEnd<end) {
			end= realEnd;
		}
		prev =criteria.getPageNum() >1;
		next= criteria.getPageNum()<realEnd;
	}
	public static void main(String[] args) {
//		int i =11;
//		int result = (i+9)/10*10;
//		
//		System.out.printf("%10s %10s %10s %10s %n","origin","floor","round",
//				"ceil");
//		for (int j=1; j<=30;j++) {
//			System.out.printf("%10d %10d %10d %10d %n",j,j/10*10,(j+5)/10*10,(j+9)/10*10);
//		}
//		System.out.println(result);
		PageDto dto = new PageDto(448, new Criteria(1,10,1));
		System.out.println(dto);
	}
	
	
}
