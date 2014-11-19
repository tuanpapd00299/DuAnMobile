package tuan.Obj;

public class ItemsList {

	@Override
	public String toString() {
		return voice + "_f";
	}

	private String id, category_id, english, pinyin, japanese, favorite, voice,
			status, vietnamese;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getJapanese() {
		return japanese;
	}

	public ItemsList(String id, String category_id, String english,
			String pinyin, String japanese, String favorite, String voice,
			String status, String vietnamese) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.english = english;
		this.pinyin = pinyin;
		this.japanese = japanese;
		this.favorite = favorite;
		this.voice = voice;
		this.status = status;
		this.vietnamese = vietnamese;
	}

	public ItemsList(String id, String category_id, String pinyin,
			String japanese, String favorite, String voice, String status,
			String vietnamese) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.pinyin = pinyin;
		this.japanese = japanese;
		this.favorite = favorite;
		this.voice = voice;
		this.status = status;
		this.vietnamese = vietnamese;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setJapanese(String japanese) {
		this.japanese = japanese;
	}

	public String getVietnamese() {
		return vietnamese;
	}

	public void setVietnamese(String vietnamese) {
		this.vietnamese = vietnamese;
	}

	public ItemsList() {

	}

}
