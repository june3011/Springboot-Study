import * as S from "./style";
import { TfiClipboard } from "react-icons/tfi";
import { useNavigate } from "react-router-dom";

const Nav = () => {
  const navigator = useNavigate();
  return (
    <S.NavBarBackgroundWrap>
      <S.NavBarWrap>
        <S.TitleAndLogoWrap
          onClick={() => {
            navigator("/");
          }}
        >
          <TfiClipboard style={{ fontSize: "1.5rem", color: "white" }} />
          <S.NavItemWrap>JOARD</S.NavItemWrap>
        </S.TitleAndLogoWrap>
        <S.RegisterButton
          onClick={() => {
            navigator("/write");
          }}
        >
          등록
        </S.RegisterButton>
      </S.NavBarWrap>
    </S.NavBarBackgroundWrap>
  );
};

export default Nav;
