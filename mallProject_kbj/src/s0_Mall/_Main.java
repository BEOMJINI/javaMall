package s0_Mall;

import s1_Member.Member;
import s1_Member.MemberController;
import s1_Member.MemberDAO;
import s2_Item.ItemController;
import s3_Admin.AdminController;

public class _Main {
	public static void main(String[] args) {
		MallController.getInstance().init();
		MemberController.getInstance().init();
		AdminController.getInstance().init();
		ItemController.getInstance().init();
		MallController.getInstance().mallMenu();
	}
}
