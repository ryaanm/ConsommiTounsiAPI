package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.ServiceInterface.ICommentService;
import tn.esprit.spring.entities.Comment;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	ICommentService ServiceComment;

	@GetMapping("/retrieve-all-cmnt")
	@ResponseBody
	public List<Comment> getComments() {
	List<Comment> listComments = ServiceComment.retrieveAllComment();
	return listComments;
}
	
	@GetMapping("/retrieve-comment/{comment-id}")
	@ResponseBody
	public Comment retrieveComment(@PathVariable("comment-id") Long idComment) {
	return ServiceComment.retrieveComment(idComment);
	}

	@PostMapping("/add-comment")
	@ResponseBody
	public Comment addComment(@RequestBody Comment c )
	{
		Comment comment= ServiceComment.save(c);
	return comment;
	}
	@DeleteMapping("/remove-comment/{comment-id}")
	@ResponseBody
	public void removeComment(@PathVariable("comment-id") Long idComment) {
		ServiceComment.deleteComment(idComment);
	}

	@PutMapping("/modify-comment")
	@ResponseBody
	public Comment modifyComment(@RequestBody Comment comment) {
	return ServiceComment.updateComment(comment);
	}
}
