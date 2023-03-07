package com.example.graphql.mutation;

import com.example.graphql.model.Post;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
class PostMutationController {

  @MutationMapping
  Mono<Post> addPost(final @Argument String title, final @Argument String content) {
    return Mono.just(new Post(3, title, content));
  }
}
