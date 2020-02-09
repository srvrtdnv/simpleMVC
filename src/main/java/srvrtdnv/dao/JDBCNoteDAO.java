package srvrtdnv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import srvrtdnv.Note;

@Component
public class JDBCNoteDAO implements NoteDAO {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
		}
	}

	@Override
	public List<Note> findAll() {
		List<Note> resultList = new ArrayList<Note>();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mvc", "root", "root");
			Statement state = con.createStatement();
			
			resultList = convert(state.executeQuery("SELECT * FROM notes;"));
			
			con.close();
		} catch (SQLException e) {
			
		}
		
		return resultList;
	}

	@Override
	public Note findById(String id) {
		Note result = new Note();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mvc", "root", "root");
			Statement state = con.createStatement();
			
			result = convert(state.executeQuery("SELECT * FROM notes WHERE id = " + id + ";")).get(0);
			
			con.close();
		} catch (SQLException e) {
			
		}
		
		return result;
	}

	@Override
	public int delete(String id) {
		int result = -1;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mvc", "root", "root");
			result = con.createStatement().execute("DELETE FROM notes WHERE id = " + id + ";") ? 1 : -1;
			con.close();
		} catch (SQLException e) {
		}
		
		return result;
	}

	@Override
	public int save(Note note) {
		int result = -1;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mvc", "root", "root");
			String text = note.getNote();
			result = con.createStatement().execute("INSERT INTO notes (note) VALUES (\"" + text + "\");") ? -1 : 1;
			con.close();
		} catch (SQLException e) {
		}
		
		return result;
	}

	@Override
	public int update(Note note) {
		int result = -1;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mvc", "root", "root");
			String id = note.getId();
			String text = note.getNote();
			result = con.createStatement().execute("UPDATE notes SET note = \"" + text + "\" WHERE id = " + id + ";") ? -1 : 1;
			con.close();
		} catch (SQLException e) {
		}
		
		return result;
	}
	
	private List<Note> convert(ResultSet rs) throws SQLException {
		List<Note> result = new ArrayList<Note>();
		
		while(rs.next()) {
			Note note = new Note();
			note.setId(rs.getString("id"));
			note.setNote(rs.getString("note"));
			result.add(note);
		}
		return result;
	}
}
