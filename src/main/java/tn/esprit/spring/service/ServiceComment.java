package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.ServiceInterface.ICommentService;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.repository.CommentRepository;

@Service
public class ServiceComment implements ICommentService {
	@Autowired
	CommentRepository cm;
	@Override
	public Comment save(Comment comment) {
		 cm.save(comment);
		return comment;
	}

	@Override
	public List<Comment> retrieveAllComment() {
		List<Comment> comment = (List<Comment>) cm.findAll();
		return comment;
	}

	@Override
	public void deleteComment(Long id) {
		Optional<Comment> comment = cm.findById(id);

		  if(comment.isPresent()) 
		    {
		        cm.deleteById(id);}	
		
				
	}

	@Override
	public Comment updateComment(Comment comment) {
		 cm.save(comment);
			return comment;
	}

	@Override
	public Comment retrieveComment(Long id) {
		return cm.findById(id).get();
	}
}