import axios from "axios";
import { postBasicInfo } from "../../types/postRegister.type";

class RegisterRepository {
  public async postRegister(postBasicInfo: postBasicInfo) {
    await axios.post(
      `http://127.0.0.1:8080/board/write.do?title=${postBasicInfo.title}&content=${postBasicInfo.content}&writter=${postBasicInfo.writter}`
    );
  }

  public async getViewCount(id: number) {
    const data = axios.get(`http://127.0.0.1:8080/board/viewCount/${id}`);
    return data;
  }
}

export default new RegisterRepository();
