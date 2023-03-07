package com.example.graphql.batch;

import com.example.graphql.model.Post;
import com.example.graphql.model.PostComment;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
class BatchController {

  private final Map<Post, Collection<PostComment>> postComments = Map.of(
      new Post(1, "Russia attacks Ukraine", "Russia is a terrorist state"),
      List.of(new PostComment(1, "+1"), new PostComment(1, "+11")),
      new Post(2, "Putin must d i e", "Puck Futin"),
      List.of(new PostComment(2, "+2"), new PostComment(2, "+22")));

  @QueryMapping
  Collection<Post> posts() {
    return postComments.keySet();
  }

  @BatchMapping(typeName = "Post", field = "comments")
  Map<Post, Collection<PostComment>> postComments(Collection<Post> posts) {
    return postComments;
  }

  /*
  @SchemaMapping(typeName = "Post", field = "comments")
  Collection<PostComment> postComments(Post post) {
    System.out.println("Fetching post comment for post ID = " + post.id());
    return postComments.get(post);
  }
  */

  @QueryMapping
  Post postById(final @Argument Integer id) {
    return postComments.keySet().stream()
        .filter(post -> post.id().equals(id))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Post with specified id not found"));
  }
}
