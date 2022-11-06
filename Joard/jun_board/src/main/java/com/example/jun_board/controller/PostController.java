package com.example.jun_board.controller;

import com.example.jun_board.dto.WriteDTO;
import com.example.jun_board.entity.Post;
import com.example.jun_board.repository.PostRepository;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @PostMapping("write.do")
    public void register2(@RequestParam("title") String title,
                          @RequestParam("content") String content,
                          @RequestParam("writter") String writter){
        System.out.println(title+" "+content+" "+writter);
        Post post = Post.builder()
                .title(title)
                .content(content)
                .writter(writter)
                .build();

        System.out.println(post.getId()+" "+post.getTitle()+" "+post.getContent()+" "+post.getWritter()+" "+post.getWdate());

        System.out.println(post.getId()+" 번 아이디 정보를 등록하였습니다.");

        postRepository.save(post);
    }

    @GetMapping("detail/{id}")
    public Post detail(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow();
//        Post viewdPost = post.builder()
//                .title(post.getTitle())
//                .content(post.getContent())
//                .writter(post.getWritter());

        return post;
    }

    @PostMapping("write")
    public void register(Post post){

        System.out.println(post.getId()+" "+post.getTitle()+" "+post.getContent()+" "+post.getWritter()+" "+post.getWdate());

        System.out.println(post.getId()+" 번 아이디 정보를 등록하였습니다.");

        postRepository.save(post);

    }

    @PatchMapping("update/{id}")
    public void update(@RequestBody Post post, @PathVariable Long id){

        Post tmpPost = postRepository.findById(id)
                .orElseThrow();
        tmpPost.setTitle(post.getTitle());
        tmpPost.setContent(post.getContent());
        tmpPost.setWdate(LocalDateTime.now());

        System.out.println(id+" 번 아이디 정보를 수정하였습니다.");

        postRepository.save(tmpPost);

    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){

        System.out.println(id+" 번 아이디를 삭제하였습니다.");
        postRepository.deleteById(id);

    }


}
