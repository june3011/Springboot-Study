import Nav from "../common/Nav/Nav";
import { useState } from "react";
import {
  LoginButton,
  LoginExplainText,
  LoginInput,
  LoginInputBox,
  LoginMiddleWrap,
  LoginWrap,
} from "./style";
import useAuth from "../../hooks/auth/useAuth";

const Login = () => {
  const [name, setName] = useState<string>("");
  const [pw, setPw] = useState<string>("");

  const saveName = (e: React.ChangeEvent<HTMLInputElement>) => {
    setName(e.target.value);
  };
  const savePw = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPw(e.target.value);
  };

  const { postLogin } = useAuth();

  return (
    <>
      <Nav />
      <LoginWrap>
        <LoginMiddleWrap>
          <LoginExplainText
            style={{ justifyContent: "center", fontSize: "20px" }}
          >
            로그인
          </LoginExplainText>
          <LoginInputBox>
            <LoginExplainText>아이디</LoginExplainText>
            <LoginInput
              placeholder="아이디를 입력하세요"
              type="text"
              onChange={saveName}
            />
          </LoginInputBox>
          <LoginInputBox>
            <LoginExplainText>비밀번호</LoginExplainText>
            <LoginInput
              placeholder="비밀번호를 입력하세요"
              type="password"
              onChange={savePw}
            />
          </LoginInputBox>
          <LoginButton
            onClick={() => {
              postLogin({ name: name, pw: pw });
            }}
          >
            로그인
          </LoginButton>
        </LoginMiddleWrap>
      </LoginWrap>
    </>
  );
};

export default Login;
