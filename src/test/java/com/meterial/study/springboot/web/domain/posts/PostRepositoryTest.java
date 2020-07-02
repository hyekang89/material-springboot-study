package com.meterial.study.springboot.web.domain.posts;

import com.meterial.study.springboot.domain.posts.Posts;
import com.meterial.study.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public  void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트제목";
        String content = "테스트본문";

        postsRepository.save(Posts.builder()
                    .title(title)
                    .content(content)
                    .author("test@gmail.com")
                    .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
