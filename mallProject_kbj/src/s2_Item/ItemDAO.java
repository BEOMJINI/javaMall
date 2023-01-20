package s2_Item;

import java.util.ArrayList;

public class ItemDAO {
	private ArrayList<Item> ilist;
	private int cNum;

	public ItemDAO() {
		ilist = new ArrayList<>();
		cNum = 100;
	}

	@Override
	public String toString() {
		if(ilist.size()==0) {
			System.out.println("등록된 상품이 없습니다.");
		}
		String s = "";
		for (Item m : ilist) {
			s += "[NUM] " + m.getNum() + " [ID] " + m.getCategoryName() + " [PW] " + m.getName() + " [NAME] "
					+ m.getPrice() + "\n";
		}
		return s;
	}

	public ArrayList<Item> getIlist() {
		return ilist;
	}

	public void setIlist(ArrayList<Item> ilist) {
		this.ilist = ilist;
	}

	/** 아이템번호 부여 */
	public int Num() {
		cNum++;
		return cNum;
	}

	/** 아이템추가시 중복 방지 */
	public boolean checkIname(String name) {
		for (Item m : ilist) {
			if (name.equals(m.getName())) {
				return true;
			}
		}
		return false;
	}
}
