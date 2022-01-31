package com.example.SpringSecvice.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @NotEmpty(message = "This field cannot be null")
    @Size(min = 5, message = "At least 5 chars")
    private String title;

    @NotEmpty(message = "This field cannot be null")
    private String description;

    private Date date;

    @OneToMany
    private List<Comment> comments;

    private String creationDate;

    private String photoName;

    private int views;

    public Post() {
    }

    public int commentCount(){
        return comments.size();
    }

    public boolean hasImage(){
        return photoName != null;
    }

    public boolean hasComments() {return !comments.isEmpty();}

    public void addComment(Comment comment){
        comments.add(comment);
        comment.setPost(this);
    }


    public Long getPost_id() {
        return this.post_id;
    }

    public @NotEmpty(message = "This field cannot be null") @Size(min = 5, message = "At least 5 chars") String getTitle() {
        return this.title;
    }

    public @NotEmpty(message = "This field cannot be null") String getDescription() {
        return this.description;
    }

    public Date getDate() {
        return this.date;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public String getPhotoName() {
        return this.photoName;
    }

    public int getViews() {
        return this.views;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public void setTitle(@NotEmpty(message = "This field cannot be null") @Size(min = 5, message = "At least 5 chars") String title) {
        this.title = title;
    }

    public void setDescription(@NotEmpty(message = "This field cannot be null") String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Post)) return false;
        final Post other = (Post) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$post_id = this.getPost_id();
        final Object other$post_id = other.getPost_id();
        if (this$post_id == null ? other$post_id != null : !this$post_id.equals(other$post_id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$comments = this.getComments();
        final Object other$comments = other.getComments();
        if (this$comments == null ? other$comments != null : !this$comments.equals(other$comments)) return false;
        final Object this$creationDate = this.getCreationDate();
        final Object other$creationDate = other.getCreationDate();
        if (this$creationDate == null ? other$creationDate != null : !this$creationDate.equals(other$creationDate))
            return false;
        final Object this$photoName = this.getPhotoName();
        final Object other$photoName = other.getPhotoName();
        if (this$photoName == null ? other$photoName != null : !this$photoName.equals(other$photoName)) return false;
        if (this.getViews() != other.getViews()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Post;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $post_id = this.getPost_id();
        result = result * PRIME + ($post_id == null ? 43 : $post_id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $comments = this.getComments();
        result = result * PRIME + ($comments == null ? 43 : $comments.hashCode());
        final Object $creationDate = this.getCreationDate();
        result = result * PRIME + ($creationDate == null ? 43 : $creationDate.hashCode());
        final Object $photoName = this.getPhotoName();
        result = result * PRIME + ($photoName == null ? 43 : $photoName.hashCode());
        result = result * PRIME + this.getViews();
        return result;
    }

    public String toString() {
        return "Post(post_id=" + this.getPost_id() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", date=" + this.getDate() + ", comments=" + this.getComments() + ", creationDate=" + this.getCreationDate() + ", photoName=" + this.getPhotoName() + ", views=" + this.getViews() + ")";
    }
}
