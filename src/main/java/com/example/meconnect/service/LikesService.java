package com.example.meconnect.service;

import com.example.meconnect.entity.Likes;
import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import com.example.meconnect.model.LikeRequest;
import com.example.meconnect.repository.LikesRepository;
import com.example.meconnect.repository.PostRepo;
import com.example.meconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikesService {

    @Autowired
    PostRepo postrepo;

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NotificationService notificationService;

    public Post save(LikeRequest likedata) throws Exception {
        if (likedata.getPostid() == null) {
            throw new Exception("postid cannot be null");
        }
        Optional<Post> post = postrepo.findById(likedata.getPostid());

//		    if(post.isEmpty()) {
//		    	throw new Exception("postid not exit in database "+likedata.getPostid());
//		    }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(username);
        Optional<Likes> like = likesRepository.findTopByPostAndUserOrderByIdDesc(post.get(), user);

        if (like.isPresent() && like.get().getLikeType() == likedata.getLiketype()) {
            throw new Exception(" you already from the operation " + likedata);
        }


        if (likedata.getLiketype() == 1) {
            post.get().setLikeCount(post.get().getLikeCount() + 1);
        } else {
            post.get().setLikeCount(post.get().getLikeCount() - 1);
        }


        postrepo.save(post.get());

        Likes likesavedata = new Likes();
        likesavedata.setPost(post.get());
        likesavedata.setUser(user);
        likesavedata.setLikeType(likedata.getLiketype());
        if (like.isPresent()) {
            likesavedata.setId(like.get().getId());
        }
        likesRepository.save(likesavedata);

        notificationService.insertNotification("LIKE_ON_POST", likesavedata.getUser().getUsername(), likesavedata.getPost().getPostId(), likesavedata.getCreatedAt());
        return post.get();
    }
}
