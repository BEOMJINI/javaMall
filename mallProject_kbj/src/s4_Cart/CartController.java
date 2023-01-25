package s4_Cart;

import java.util.ArrayList;

import s0_Mall.MallController;
import s2_Item.Item;
import s_Util.Util;

public class CartController {
	private CartController() {
	}

	private static CartController instance = new CartController();

	public static CartController getInstance() {
		return instance;
	}

	private CartDAO cDao;
	private MallController mCon;

	public void init() {
		cDao = new CartDAO();
		mCon = MallController.getInstance();
	}

	/** member 쇼핑메뉴 1번 쇼핑에서 장바구니에 담기 기능 */
	public void addCart(Item i) {
		cDao.getClist().add(new Cart(cDao.Num(), mCon.getLoginId(), i.getName(), i.getPrice()));
		System.out.printf("[%s] 장바구니에 담겼습니다.\n", i.getName());
	}

	/** member 쇼핑메뉴 2번 장바구니에 > 1번 구매 선택시 admin의 구매목록에 출력하기위해 데이터옮기기 기능 */
	public void addBuy(ArrayList<Cart> c) {
		cDao.getBuylist().addAll(c);
		c.clear();
		System.out.println("장바구니에 담긴 물건을 구매했습니다.\n장바구니를 비웁니다.");
	}

	/** admin 회원관리 메뉴 2번 주문목록 */
	public void printBuy() {
		System.out.println("\n[주문목록]");
		if (cDao.getBuylist().size() == 0) {
			System.out.println("주문 상품이 없습니다.");
		}
		for (Cart c : cDao.getBuylist()) {
			System.out.println(c.toString());
		}
	}

	/** admin 장바구니 관리 메뉴 1번 전체장바구니 목록 */
	public void printAdminCart() {
		System.out.println("\n[전체 장바구니목록]");
		if (cDao.getClist().size() == 0) {
			System.out.println("전체 장바구니가 비었습니다.");
		}
		for (Cart c : cDao.getClist()) {
			System.out.println(c.toString());
		}
	}

	/** member 메뉴 2번 장바구니 목록 */
	public void printCart() {
		ArrayList<Cart> memberCart = new ArrayList<>();
		for (int i = 0; i < cDao.getClist().size(); i++) {
			if (cDao.getClist().get(i).getId().equals(mCon.getLoginId())) {
				memberCart.add(cDao.getClist().get(i));

			}
		}
		while (true) {
			System.out.println("\n[장바구니 목록]");
//	for(Cart c : cDao.getClist()){
//		if(c.getId().equals(mCon.getLoginId())) {
//			System.out.println(c.toString());
//		}else {
//			System.out.println("Test");
//		}
//	}
			if (memberCart.size() == 0) {
				System.out.println("장바구니가 비었습니다.");
			} else {
				for (int i = 0; i < memberCart.size(); i++) {
					System.out.println(i + 1 + ") " + memberCart.get(i).toString());
				}
			}
			System.out.println("\n[0]뒤로가기 [1]구매 [2]장바구니삭제");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				System.out.println("[구매]");
				for (int i = 0; i < cDao.getClist().size(); i++) {
					if (cDao.getClist().get(i).getId().equals(mCon.getLoginId())) {
						// addBuy(cDao.getClist());
						// cDao.getClist().clear();
						// memberCart.clear();
						cDao.getClist().remove(i);
						i--;
					}
				}
				addBuy(memberCart);
			} else if (sel == 2) {
				System.out.println("[장바구니삭제]\n번호를 선택해 삭제해주세요.");
				System.out.println(memberCart.size());
				int choice = Util.getValue(1, memberCart.size()) - 1;
				if (choice >= 0 && choice <= memberCart.size() - 1) {
					memberCart.remove(choice);
				}

//		for(int i=0; i<cDao.getClist().size();i++) {
//			if(cDao.getClist().get(i).getId().equals(mCon.getLoginId())) {
//				cDao.getClist().remove(choice);
//				i--;
//			}
//		}
			}
		}
	}

}
