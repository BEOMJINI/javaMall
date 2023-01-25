package s5_Board;

import java.util.Scanner;

import s_Util.Util;

public class BoardController {
	private BoardController() {
	}

	private static BoardController instance = new BoardController();

	public static BoardController getInstance() {
		return instance;
	}

	private BoardDAO bdao;
	private Scanner sc;

	public void init() {
		bdao = new BoardDAO();
		sc = Util.sc;
	}

	/** member 게시판 메뉴 */
	public void printBoard() {
		while (true) {
			System.out.println("\n[게시판 목록]");
			if (bdao.getBlist().size() == 0) {
				System.out.println("게시글이 없습니다.");
			} else {
				for (int i = 0; i < bdao.getBlist().size(); i++) {
					System.out.println(i + 1 + ") " + bdao.getBlist().get(i).toString());
				}
			}
			System.out.println("\n[0]뒤로가기 [1]게시글작성 [2]게시글보기");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				System.out.print("\nTitle : ");
				String t = sc.next();
				String c = "";
				String con = "";
				System.out.println("Content :\n'작성완료'을 입력하시면 작성이 완료됩니다.");
				while (true) {
					c = sc.nextLine();
					if (c.equals("작성완료")) {
						break;
					}
					con += c + "\n";
				}
				// sc.nextLine();
				bdao.getBlist().add(new Board(t, con));

			} else if (sel == 2) {
				if (bdao.getBlist().size() == 0) {
					System.out.println("게시글이 없습니다.");
					break;
				}
				System.out.println("\n[게시글선택]\n게시글 번호로 선택해주세요.");
				int choice = Util.getValue(1, bdao.getBlist().size()) - 1;
				if (choice >= 0 && choice <= bdao.getBlist().size() - 1) {
					System.out.println("제목 : " + bdao.getBlist().get(choice).getTitle() + "\n내용 : "
							+ bdao.getBlist().get(choice).getInfo());
				}
			}
		}
	}

	/** admin 게시판 2번 공지작성 메뉴 */
	public void addNotice() {
		System.out.print("\nTitle : ");
		String n = "[Notice]";
		String t = sc.next();
		n += t;
		String c = "";
		String con = "";
		System.out.println("Content :\n'작성완료'을 입력하시면 작성이 완료됩니다.");
		while (true) {
			c = sc.nextLine();
			if (c.equals("작성완료")) {
				break;
			}
			con += c + "\n";
		}
		// sc.nextLine();
		bdao.getBlist().add(new Board(n, con));
	}

	/** admin 게시판 1번 전체게시판목록 메뉴 */
	public void adminPrintBoard() {
		System.out.println("\n[게시판 목록]");
		if (bdao.getBlist().size() == 0) {
			System.out.println("게시글이 없습니다.");
		} else {
			for (int i = 0; i < bdao.getBlist().size(); i++) {
				System.out.println(i + 1 + ") " + bdao.getBlist().get(i).toString());
			}
		}
		while (true) {
			System.out.println("\n[0]뒤로가기 [1]게시글보기");
			int sel = Util.getValue(0, 1);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				if (bdao.getBlist().size() == 0) {
					System.out.println("게시글이 없습니다.");
					break;
				}
				System.out.println("\n[게시글선택]\n게시글 번호로 선택해주세요.");
				int choice = Util.getValue(1, bdao.getBlist().size()) - 1;
				if (choice >= 0 && choice <= bdao.getBlist().size() - 1) {
					System.out.println("제목 : " + bdao.getBlist().get(choice).getTitle() + "\n내용 : "
							+ bdao.getBlist().get(choice).getInfo());
				}
			}
		}
	}

	/** admin 게시판 3번 게시글삭제 메뉴 */
	public void deleteBoard() {
		if (bdao.getBlist().size() == 0) {
			System.out.println("게시글이 없습니다.");
			return;
		}
		System.out.println("\n[게시글삭제]");
		int sel = Util.getValue(1, bdao.getBlist().size()) - 1;
		if (sel >= 0 && sel <= bdao.getBlist().size() - 1) {
			bdao.getBlist().remove(sel);
			System.out.println(sel + 1 + " 번 게시글 삭제 완료");
		}
	}
}
