import { InputProps } from "../../types/commonInputProps";
import Nav from "../common/Nav/Nav";
import { useState } from "react";
import {
  SignupButton,
  SignupExplainText,
  SignupInput,
  SignupInputBox,
  SignupMiddleWrap,
  SignupWrap,
} from "./style";
import useAuth from "../../hooks/auth/useAuth";

const Signup = () => {
  const [name, setName] = useState<string>("");
  const [pw, setPw] = useState<string>("");
  const [pwCheck, setPwCheck] = useState<string>("");

  const saveName = (e: React.ChangeEvent<HTMLInputElement>) => {
    // console.log(e.target.value);
    setName(e.target.value);
  };

  const savePw = (e: React.ChangeEvent<HTMLInputElement>) => {
    // console.log(e.target.value);
    setPw(e.target.value);
  };

  const savePwCheck = (e: React.ChangeEvent<HTMLInputElement>) => {
    // console.log(e.target.value);
    setPwCheck(e.target.value);
  };

  const { postSignup } = useAuth();

  return (
    <>
      <Nav />
      <SignupWrap>
        <SignupMiddleWrap>
          <SignupExplainText
            style={{ justifyContent: "center", fontSize: "20px" }}
          >
            회원가입
          </SignupExplainText>
          <SignupInputBox>
            <SignupExplainText>아이디</SignupExplainText>
            <SignupInput
              placeholder="아이디를 입력하세요"
              type="text"
              onChange={saveName}
            />
          </SignupInputBox>
          <SignupInputBox>
            <SignupExplainText>비밀번호</SignupExplainText>
            <SignupInput
              placeholder="비밀번호를 입력하세요"
              type="password"
              onChange={savePw}
            />
          </SignupInputBox>
          <SignupInputBox>
            <SignupExplainText>비밀번호 확인</SignupExplainText>
            <SignupInput
              placeholder="비밀번호를 확인하세요"
              type="password"
              onChange={savePwCheck}
            />
          </SignupInputBox>
          <SignupButton
            onClick={() => {
              postSignup({ name: name, pw: pw, pwCheck: pwCheck });
            }}
          >
            회원가입
          </SignupButton>
        </SignupMiddleWrap>
      </SignupWrap>
    </>
  );
};

export default Signup;
