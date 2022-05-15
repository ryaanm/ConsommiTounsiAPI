package tn.esprit.spring.ServiceInterface;


import java.util.List;

import tn.esprit.spring.entities.Comment ; 

public interface ICommentService {
	public Comment save(Comment comment);
	List<Comment> retrieveAllComment();
	Comment retrieveComment (Long id);
	void deleteComment(Long id);
	Comment updateComment(Comment comment);
}