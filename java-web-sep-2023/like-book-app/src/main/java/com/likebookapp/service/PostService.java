package com.likebookapp.service;

import com.likebookapp.model.dto.post.PostAddBindingModel;
import com.likebookapp.model.dto.post.PostViewDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final MoodRepository moodRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LoggedUser loggedUser;

    private final ModelMapper modelMapper;

    public PostService(MoodRepository moodRepository, UserRepository userRepository, PostRepository postRepository, LoggedUser loggedUser, ModelMapper modelMapper) {
        this.moodRepository = moodRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }


    public void addPost(PostAddBindingModel postAddBindingModel) {

        Mood mood = moodRepository.findByName(postAddBindingModel.getMood());

        User user = userRepository.findByUsername(loggedUser.getUsername());

        if(mood != null) {
            Post post = new Post();
            post.setContent(postAddBindingModel.getContent());
            post.setCreator(user);
            post.setMood(mood);

            postRepository.save(post);
        }
    }

    public List<Post> getPostsFromCurrentUser(Long id) {

        return postRepository.findAllByCreatorId(id);
    }

    public List<PostViewDTO> getPostsFromOtherUsers(Long id) {
        return postRepository
                .findAllByCreator_IdNot(id)
                .stream()
                .map(post -> {
                    PostViewDTO postViewDTO = new PostViewDTO();
                    postViewDTO.setUserLikes(post.getUserLikes());
                    postViewDTO.setUsername(post.getCreator().getUsername());
                    postViewDTO.setId(post.getId());
                    postViewDTO.setMood(post.getMood());
                    postViewDTO.setContent(post.getContent());

                    return postViewDTO;
                }).collect(Collectors.toList());
    }

    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    public void likePostWithId(Long postId, Long userId) {

        Post post = postRepository.findById(postId).orElse(null);

        User user = userRepository.findById(userId).orElse(null);

        post.getUserLikes().add(user);

        postRepository.save(post);
    }
}
