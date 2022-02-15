package com.example.meconnect.service;

import com.example.meconnect.entity.Post;
import com.example.meconnect.entity.User;
import com.example.meconnect.mapper.PostMapper;
import com.example.meconnect.model.PostRequest;
import com.example.meconnect.model.PostResponse;
import com.example.meconnect.repository.PostRepo;
import com.example.meconnect.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepository userRepository;

    public void submitPostToDB(PostRequest postRequest) {
        Post post = postMapper.dtoToDao(postRequest);
        postRepo.save(post);
    }

    public List<PostResponse> getAllPosts() {
        return postRepo.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<PostResponse> getAllPostsByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return postRepo.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void deletePost(Long postId, String username) {
        postRepo.deleteByPostIdAndUsername(postId,username);
    }

//	public ArrayList<Post> deletePostFromDB(long postId){
//		postRepo.deleteById(postId);
//		ArrayList<Post> result = retrievePostFromDB();
//		return result;
//	}
}
