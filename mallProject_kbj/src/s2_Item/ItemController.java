package s2_Item;

import java.util.Scanner;

import s_Util.Util;

public class ItemController {
	private ItemController() {
	}

	private static ItemController instance = new ItemController();

	public static ItemController getInstance() {
		return instance;
	}

	private ItemDAO iDao;
	private Scanner sc;

	public void init() {
		iDao = new ItemDAO();
		sc = Util.sc;
	}

	/** admin 상품관리 1.상품목록 출력 */
	public void printItem() {
		System.out.println("\n[상품목록]");
		System.out.println(iDao.toString());
	}

	/** admin 상품관리 2.상품추가 */
	public void addItem() {
		System.out.println("\n[상품추가]");
		while (true) {
			System.out.print("# Name ->  ");
			String name = sc.next();
			if (iDao.checkIname(name) == true) {
				System.out.println("[중복된 상품이름]\n다른 상품이름을 사용해주세요.");
				continue;
			}
			System.out.print("# CategoryName ->  ");
			String cName = sc.next();
			System.out.print("# Price ->  ");
			int price = sc.nextInt();
			iDao.getIlist().add(new Item(iDao.Num(), cName, name, price));
			System.out.printf("\n[%s 상품추가 완료]\n", name);
			break;
		}
	}

	public void deleteItem() {
		System.out.println("\n[상품삭제]");
		while (true) {
			System.out.print("# Name ->  ");
			String name = sc.next();
			if (iDao.checkIname(name) == false) {
				System.out.println("[목록에 없는 상품]\n상품이름을 확인해주세요.");
				continue;
			}
			for (int i = 0; i < iDao.getIlist().size(); i++) {
				if (name.equals(iDao.getIlist().get(i).getName())) {
					iDao.getIlist().remove(i);
					i--;
				}
			}
			System.out.printf("\n[%s 상품삭제 완료]\n", name);
			break;
		}
	}

}
