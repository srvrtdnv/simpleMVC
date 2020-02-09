package srvrtdnv;


public class Note {
	private String id;
	private String note;
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isExist() {
		return !id.equals("");
	}
}
