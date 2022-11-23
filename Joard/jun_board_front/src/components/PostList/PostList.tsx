import { useNavigate } from "react-router-dom";
import usePostList from "../../hooks/postList/usePostList";
import registerRepository from "../../repository/register/register.repository";
import Wrap from "../common/BodyWrap/Wrap";
import Nav from "../common/Nav/Nav";
import * as S from "./style";
import "./style.css";

const PostList = () => {
  const { postList } = usePostList();
  const navigator = useNavigate();

  return (
    <Wrap>
      <Nav />
      <S.PostListWrap>
        <S.Table>
          <S.TrHead>
            <S.Th className="title">글 제목</S.Th>
            <S.Th className="content">글 내용</S.Th>
            <S.Th>글 쓴이</S.Th>
            <S.Th>마지막 수정 시간</S.Th>
            <S.Th className="viewCount">조회수</S.Th>
          </S.TrHead>
          {/* <S.Tr>
            <S.Td className="title">제목제목</S.Td>
            <S.Td className="content">안녕핫요</S.Td>
            <S.Td>기준</S.Td>
            <S.Td>2022-10-30</S.Td>
            <S.Td className="viewCount">100</S.Td>
          </S.Tr>
          <S.Hr />
          <S.Tr>
            <S.Td className="title">제목제목</S.Td>
            <S.Td className="content">
              aslkfjalskjflaksjflkas ㅁ니ㅏ러미나ㅓㅇ리ㅏㅓ 민 림넝
              리ㅓㅁㄴ이러ㅣㅁ너리ㅏ먼ㅇ 리ㅏㅁ넝리ㅓㅁ니ㅏㅇ러ㅣ ㅁ나어림넝리나
            </S.Td>
            <S.Td>기준</S.Td>
            <S.Td>2022-10-30</S.Td>
            <S.Td className="viewCount">100</S.Td>
          </S.Tr>
          <S.Hr />
          <S.Tr>
            <S.Td className="title">
              만어ㅗ하ㅓ모니럴ㅇ허암린;ㅎㅇ러ㅏ;ㅁㅎ로이하ㅚㅏ먼ㅇㄹ하ㅣㅓㅁ;ㄴㅇㅎ라ㅣ
              ㅓ미나ㅗㅇ림ㄴ아허ㅗ러마허ㅚㅓㅣㅗ
            </S.Td>
            <S.Td className="content">내용인데 아무것도 없음</S.Td>
            <S.Td>기준</S.Td>
            <S.Td>2022-10-30</S.Td>
            <S.Td className="viewCount">100</S.Td>
          </S.Tr>
          <S.Hr /> */}
          {postList.map((post, idx) => {
            console.log(post.wdate);

            return (
              <div key={post.id}>
                <S.Tr
                  // key={post.id}
                  onClick={() => {
                    navigator(`/view/${idx}`);
                  }}
                  style={{ cursor: "pointer" }}
                >
                  <S.Td className="title">{post.title}</S.Td>
                  <S.Td className="content">{post.content}</S.Td>
                  <S.Td>{post.writter}</S.Td>
                  <S.Td>
                    {post.wdate[0] + "-" + post.wdate[1] + "-" + post.wdate[2]}
                  </S.Td>
                  <S.Td className="viewCount">{post.viewCount}</S.Td>
                </S.Tr>
                <S.Hr />
              </div>
            );
          })}
        </S.Table>
      </S.PostListWrap>
    </Wrap>
  );
};
export default PostList;
