package srvrtdnv;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import srvrtdnv.service.NoteService;

@Controller
@ComponentScan(basePackages = "srvrtdnv.service")
public class HelloController {
	
	@Autowired
	private NoteService nService;
	
	@RequestMapping(value = "/")
	public String redirect() {
		return "redirect:/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute Note note) {
		if (note.isExist()) {
			nService.update(note);
		} else {
			nService.save(note);
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String noteList(Model model, HttpSession session) {
		model.addAttribute("notes", nService.findAll());
		
		return "list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("note", new Note());
		return "noteForm";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable String id, Model model) {
		model.addAttribute("note", nService.findById(id));
		return "noteForm";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@ModelAttribute Note note, @PathVariable String id) {
		nService.delete(id);
		return "redirect:/list";
	}
	
	public NoteService getnService() {
		return nService;
	}

	public void setnService(NoteService nService) {
		this.nService = nService;
	}
	
}
