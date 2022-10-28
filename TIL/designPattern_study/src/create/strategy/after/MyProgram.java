package create.strategy.after;

import create.strategy.before.Mode;
import create.stratagy.after.SearchButton;

public class MyProgram {

		private SearchButton searchButton = new SearchButton(this);
		
		public Mode mode = Mode.ALL;

		public void setModeAll() { mode = Mode.ALL; }
		public void setModeImage() { mode = Mode.IMAGE; }
		public void setModeNews() { mode = Mode.NEWS; }
		public void setModeMap() { mode = Mode.MAP; }

		public void testProgram() {
			searchButton.onClick();//현재 상태의 "..." 출력
			setModeImage();//이미지검색 모드로
			searchButton.onClick();//"SEARCH IMAGE" 출력
			setModeNews();
			searchButton.onClick();//"SEARCH NEWS" 출력
			setModeMap();
			searchButton.onClick();//"SEARCH MAP" 출력
		}
		
}
