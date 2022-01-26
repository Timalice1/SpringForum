package com.example.SpringSecvice.services;

import com.example.SpringSecvice.entity.Post;
import com.example.SpringSecvice.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Value("${upload.path}")
    private String uploadPath;

    /**
     *Save new post to DB
     * @param post new post from HTML
     * @return true if all ok
     */
    public boolean add(@Valid Post post, BindingResult result){

        if(result.hasErrors())
            return false;

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
    public boolean add(@Valid Post post, BindingResult result, MultipartFile file){

        if(result.hasErrors())
            return false;

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
    public String uploadPhoto(MultipartFile file) {
        String name = file.getOriginalFilename();

        try(FileOutputStream fos = new FileOutputStream(uploadPath + name);){
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

}
