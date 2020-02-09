package srvrtdnv.dao;

import java.util.List;

import srvrtdnv.Note;

public interface NoteDAO {
	List<Note> findAll();
	Note findById(String id);
	int delete(String id);
	int save(Note note);
	int update(Note note);
}
