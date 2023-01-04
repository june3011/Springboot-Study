import axios from "axios";
import { postBasicInfo, postInfo } from "../../types/postRegister.type";

class RegisterRepository {
  public async postRegister(postBasicInfo: postInfo) {
    await axios.post(
      `http://127.0.0.1:8080/board/write.do`,
      { title: postBasicInfo.title, content: postBasicInfo.content },
      {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      }
    );
  }

  public async getViewCount(id: number) {
    const data = axios.get(`http://127.0.0.1:8080/board/viewCount/${id}`);
    return data;
  }
}

export default new RegisterRepository();
