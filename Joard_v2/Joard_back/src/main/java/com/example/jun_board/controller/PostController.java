package com.example.jun_board.controller;

import com.example.jun_board.dto.WriteDTO;
import com.example.jun_board.entity.Post;
import com.example.jun_board.entity.User;
import com.example.jun_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;    // autowired 필드형 주입 대신에 생성자로 주입

    @GetMapping("list")
    public List<Post> list() {
        List<Post> list = postRepository.findAll();
        System.out.println("Post 리스트를 조회하였습니다.");
        return list;
    }
//
//    @GetMapping("viewCount/{id}")
//    public Long getViewCount(@PathVariable Long id){
//        List<Post> list = postRepository.findAll();
//        Post post = postRepository.findById(id)
//                .orElseThrow();
//        System.out.println("조회수를 조회하였습니다.");
//        return post.getId();
//    }

    @PostMapping("/write.do")
    public void register2(@RequestBody WriteDTO writeDTO) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // User 정보 바로 받아와서 작성자 입력 안 하도록 하기

        Optional<Post> thisPost = postRepository.findById(user.getUserId());

        Post post = Post.builder()
                .title(writeDTO.getTitle())
                .content(writeDTO.getContent())
                .writter(user.getUsername())
                .viewCount(thisPost.get().getViewCount()+1)
                .build();

        System.out.println(post.getId()+" "+post.getTitle()+" "+post.getContent()+" "+post.getWritter()+" "+post.getWdate());

        System.out.println(post.getId()+" 번 아이디 정보를 등록하였습니다.");

        postRepository.save(post);
    }

    @GetMapping("detail/{id}")
    public Post detail(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow();
        Post updateViewPost = Post.builder()
                .writter(post.getWritter())
                .title(post.getTitle())
                .content(post.getContent())
                .viewCount(post.getViewCount() + 1)
                .build();


        return updateViewPost;
    }

//    @PostMapping("write")
//    public void register(Post post){
//
//        System.out.println(post.getId()+" "+post.getTitle()+" "+post.getContent()+" "+post.getWritter()+" "+post.getWdate());
//
//        System.out.println(post.getId()+" 번 아이디 정보를 등록하였습니다.");
//
//        postRepository.save(post);
//
//    }

    @PatchMapping("update/{id}")
    public void update(@RequestBody Post post, @PathVariable Long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Post tmpPost = postRepository.findById(id)
                .orElseThrow();

        if(!user.getUsername().equals(tmpPost.getWritter())) throw new RuntimeException("권한이없습니다");
        tmpPost.setTitle(post.getTitle());
        tmpPost.setContent(post.getContent());
        tmpPost.setWdate(LocalDateTime.now());

        System.out.println(id+" 번 아이디 정보를 수정하였습니다.");

        postRepository.save(tmpPost);

    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postRepository.findById(id).orElseThrow();

        if(!user.getUsername().equals(post.getWritter())) throw new RuntimeException("권한이 없습니다");

        System.out.println(id+" 번 아이디를 삭제하였습니다.");
        postRepository.delete(post);

    }


}
