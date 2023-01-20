package s3_Admin;

import s1_Member.MemberController;
import s2_Item.ItemController;
import s_Util.Util;

public class AdminController {
	private AdminController() {
	}

	private static AdminController instance = new AdminController();

	public static AdminController getInstance() {
		return instance;
	}

	private MemberController mCon;
	private ItemController iCon;
	
	public void init() {
		mCon = MemberController.getInstance();
		iCon = ItemController.getInstance();
	}

	/** admin 메뉴 페이지 */
	public void adminMenu() {
		while (true) {
			System.out.println("\n_________________ADMIN_________________");
			System.out.println("[0]뒤로가기 [1]회원관리 [2]상품관리 [3]장바구니관리");
			int sel = Util.getValue(0, 3);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				adminMember();
			} else if (sel == 2) {
				adminItem();
			} else if (sel == 3) {
				adminCart();
			}
		}
	}

	/** admin 회원관리페이지 */
	public void adminMember() {
		while (true) {
			System.out.println("\n_______ADMIN 회원관리________");
			System.out.println("[0]뒤로가기 [1]회원목록 [2]주문목록");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				mCon.printMember();
			} else if (sel == 2) {

			}
		}
	}

	/** admin 상품관리페이지 */
	public void adminItem() {
		while (true) {
			System.out.println("\n_____________ADMIN 상품관리_____________");
			System.out.println("[0]뒤로가기 [1]전체 상품목록 [2]상품추가 [3]상품삭제");
			int sel = Util.getValue(0, 3);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				iCon.printItem();
			} else if (sel == 2) {
				iCon.addItem();
			} else if (sel == 3) {
				iCon.deleteItem();
			}
		}
	}

	/** admin 장바구니관리페이지 */
	public void adminCart() {
		while (true) {
			System.out.println("\n_____ADMIN 장바구니관리______");
			System.out.println("[0]뒤로가기 [1]전체 장바구니목록");
			int sel = Util.getValue(0, 1);
			if (sel == 0) {
				break;
			} else if (sel == 1) {

			}
		}
	}

}
