import axios from "axios";
import { post } from "../../types/post.type";

class PostListRepository {
  public async getPostList(): Promise<post[]> {
    const { data } = await axios.get("http://127.0.0.1:8080/board/list");

    return data;
  }
}

export default new PostListRepository();
