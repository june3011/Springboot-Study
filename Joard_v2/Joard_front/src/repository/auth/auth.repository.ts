import axios from "axios";
import { signupCheckType, signupType } from "../../types/signup.type";

class AuthRepository {
  public async postSignup(userInfo: signupType) {
    await axios.post("http://127.0.0.1:8080/user/signup", userInfo);
  }

  public async postLogin(userInfo: signupType) {
    const data = await axios.post("http://127.0.0.1:8080/user/login", userInfo);
    return data;
  }
}

export default new AuthRepository();
