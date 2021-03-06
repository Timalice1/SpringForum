package com.example.SpringSecvice.services;

import com.example.SpringSecvice.entity.Comment;
import com.example.SpringSecvice.entity.Post;
import com.example.SpringSecvice.repositories.CommentRepository;
import com.example.SpringSecvice.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Value("${upload.path}")
    private String uploadPath;

    /**
     *Save new post to DB
     * @param post new post from HTML
     * @return true if all ok
     */
    public boolean add(@Valid Post post){
        post.setCreationDate(new SimpleDateFormat("dd MMMM yyyy HH:mm:ss").format(new Date()));
        postRepository.save(post);
        return true;
    }

    /**
     * Same, but with img
     * @param post post from HTML
     * @param file img from HTML
     * @return true if saved ok
     */
    public boolean add(@Valid Post post, MultipartFile file){

        post.setPhotoName(uploadPhoto(file));
        post.setCreationDate(new SimpleDateFormat("dd MMMM yyyy HH:mm:ss").format(new Date()));
        postRepository.save(post);
        return true;
    }

    /**
     * Upload img to server
     * @param file img from HTML
     * @return file name
     */
    private String uploadPhoto(MultipartFile file) {
        String name = file.getOriginalFilename();

        try(BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(uploadPath+name))){
            fos.write(file.getBytes());
            fos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        return name;
    }

    /**
     * Get all post from DB
     * @return List of posts
     */
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    /**
     * Get all post from DB and sort it by creation date
     * @return sorted List
     */
    public List<Post> findAllSortByDate(){
        return postRepository.sortByDate();
    }

    public Post findById(Long id){
        return postRepository.findPostById(id);
    }

    public void addComment(Long postId, String text){
        Post post = postRepository.findPostById(postId);
        Comment comment = new Comment();
        comment.setText(text);
        comment.setDate(new Date());
        post.addComment(comment);
        commentRepository.save(comment);
    }

}
