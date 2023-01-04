import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import usePostList from "../../hooks/postList/usePostList";
import postListRepository from "../../repository/postList/postList.repository";
import Wrap from "../common/BodyWrap/Wrap";
import Nav from "../common/Nav/Nav";
import * as S from "./style";

const View = () => {
  const { postList } = usePostList();
  const { idx } = useParams();
  const index = Number(idx);

  const [post, setPost] = useState({
    title: "기본제목",
    content: "기본내용",
    writter: "기본작성자",
    viewCount: 0,
  });

  console.log(postList[index]);

  //   const date = new Date(postList[index]?.wdate);
  //   console.log(date);

  useEffect(() => {
    (async () => {
      try {
        const { data } = await axios.get(
          `http://127.0.0.1:8080/board/detail/${Number(idx) + 1}`
        );
        setPost(data);
      } catch (error) {}
    })();
  }, [idx]);

  const [isModifying, setIsModifying] = useState<boolean>(false);

  const navigator = useNavigate();

  const [title, setTitle] = useState("");
  const [content, setContent] = useState(postList[index]?.content);

  useEffect(() => {
    setTitle(post.title);
    setContent(post.content);
  }, []);

  useEffect(() => {
    if (post) {
      setTitle(post.title);
      setContent(post.content);
    }
  }, [post]);

  return (
    <Wrap>
      <Nav />
      {isModifying === false ? (
        <S.ViewWrap>
          <S.TitleWrap>
            <S.Title>{post.title}</S.Title>
            <S.ViewCount>{post.viewCount}회 읽음</S.ViewCount>
          </S.TitleWrap>
          {/* <div>{postList[index]?.id}</div> */}
          <S.Content>
            <S.ContentText>내용</S.ContentText>
            {post.content}
          </S.Content>
          <S.BottomWrap>
            <div>작성자 : {post.writter}</div>
            <div>
              {postList[index]?.wdate[0] +
                "-" +
                postList[index]?.wdate[1] +
                "-" +
                postList[index]?.wdate[2]}
            </div>
          </S.BottomWrap>
          <S.ModifyButtonWrap>
            <S.ModifyButton onClick={() => setIsModifying((prev) => !prev)}>
              수정
            </S.ModifyButton>
            <S.ModifyButton
              onClick={async () => {
                await axios.delete(
                  `http://127.0.0.1:8080/board/delete/${index + 1}`
                );
                navigator("/");
              }}
            >
              삭제
            </S.ModifyButton>
          </S.ModifyButtonWrap>
        </S.ViewWrap>
      ) : (
        <S.ViewWrap>
          <S.TitleWrap>
            <S.TitleInput
              onChange={(e) => {
                setTitle(e.target.value);
              }}
              value={title}
            ></S.TitleInput>
            <S.ViewCount>{post.viewCount}회 읽음</S.ViewCount>
          </S.TitleWrap>
          {/* <div>{postList[index]?.id}</div> */}
          <S.Content>
            <S.ContentText>내용</S.ContentText>
            <S.ContentInput
              onChange={(e) => {
                setContent(e.target.value);
              }}
              value={content}
            ></S.ContentInput>
          </S.Content>
          <S.BottomWrap>
            <div>작성자 : {post.writter}</div>
            <div>
              {postList[index]?.wdate[0] +
                "-" +
                postList[index]?.wdate[1] +
                "-" +
                postList[index]?.wdate[2]}
            </div>
          </S.BottomWrap>
          <S.ModifyButtonWrap>
            <S.ModifyButton
              onClick={() => {
                axios.patch(`http://127.0.0.1:8080/board/update/${index + 1}`, {
                  title: title,
                  content: content,
                  writter: post.writter,
                });
                navigator("/");
              }}
            >
              완료
            </S.ModifyButton>
          </S.ModifyButtonWrap>
        </S.ViewWrap>
      )}
    </Wrap>
  );
};

export default View;
