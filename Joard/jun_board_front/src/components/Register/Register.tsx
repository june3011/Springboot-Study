import { useState } from "react";
import { useNavigate } from "react-router-dom";
import useRegister from "../../hooks/register/useRegister";
import Wrap from "../common/BodyWrap/Wrap";
import Nav from "../common/Nav/Nav";
import * as S from "./style";

const Register = () => {
  const [writter, setWritter] = useState<string>("");
  const [title, setTitle] = useState<string>("");
  const [content, setContent] = useState<string>("");

  const navigator = useNavigate();
  const { postRegister } = useRegister();

  return (
    <Wrap>
      <Nav />
      <S.RegisterWrap>
        <form
          action=""
          id="formWrite"
          style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "flex-end",
            gap: "5px",
          }}
        >
          <S.RegisterButton
            type="button"
            value="글쓰기"
            onClick={() => {
              try {
                postRegister({ title, content, writter });
                console.log("글쓰기누름");
                navigator("/");
              } catch (error) {
                console.log(error);
              }
            }}
          />
          <S.TitleInput
            type="text"
            id="w_title"
            placeholder="제목"
            required
            onChange={(e) => setTitle(e.target.value)}
          />
          <S.WritterInput
            type="text"
            id="w_writer"
            placeholder="작성자"
            required
            onChange={(e) => setWritter(e.target.value)}
          />
          <S.ContentInput
            type="text"
            id="w_content"
            placeholder="내용"
            required
            onChange={(e) => setContent(e.target.value)}
          />
        </form>
      </S.RegisterWrap>
    </Wrap>
  );
};

export default Register;
