import { useNavigate } from "react-router-dom";
import authRepository from "../../repository/auth/auth.repository";
import { signupCheckType, signupType } from "../../types/signup.type";
import { useRecoilState } from "recoil";
import { LoginState } from "../../store/loginAtom";

const useAuth = () => {
  const navigate = useNavigate();
  const [isLogined, setIsLogined] = useRecoilState(LoginState);

  const postSignup = async (userInfo: signupCheckType) => {
    if (userInfo.pw === userInfo.pwCheck) {
      const formData = { name: userInfo.name, pw: userInfo.pw };
      try {
        const res = await authRepository.postSignup(formData);
        console.log("회원가입");
        window.alert("회원가입 성공");
        navigate("/login");
      } catch (error) {
        console.log("회원가입 실패");
        window.alert("회원가입 실패");
      }
      console.log("회원가입 성공");
    } else {
      window.alert("비밀번호가 일치하지 않습니다");
    }
  };

  const postLogin = async (userInfo: signupType) => {
    let temp;
    try {
      const data = await authRepository.postLogin(userInfo);
      console.log(data);
      temp = data;
      window.alert("로그인 성공");
      setIsLogined((prev) => !prev);
      navigate("/");
      localStorage.setItem("token", temp?.data);
    } catch (error) {
      console.log(error);
      window.alert("로그인 실패");
    }
  };

  return { postSignup, postLogin };
};

export default useAuth;
