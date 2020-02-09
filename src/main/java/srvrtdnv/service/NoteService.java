package srvrtdnv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import srvrtdnv.Note;
import srvrtdnv.dao.NoteDAO;

@Component
@ComponentScan(basePackages = "srvrtdnv.dao")
public class NoteService {
	
	@Autowired
	private NoteDAO dao;
	
	public List<Note> findAll() {
		return dao.findAll();
	}
	
	public Note findById(String id) {
		return dao.findById(id);
	}
	
	public int delete(String id) {
		return dao.delete(id);
	}
	
	public int save(Note note) {
		return dao.save(note);
	}
	
	public int update(Note note) {
		return dao.update(note);
	}

	public NoteDAO getDao() {
		return dao;
	}

	public void setDao(NoteDAO dao) {
		this.dao = dao;
	}
	
}
