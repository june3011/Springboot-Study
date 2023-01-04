import * as S from "./style";
import { TfiClipboard } from "react-icons/tfi";
import { useNavigate } from "react-router-dom";
import { useRecoilState } from "recoil";
import { LoginState } from "../../../store/loginAtom";
import axios from "axios";
import { useState, useEffect } from "react";

const Nav = () => {
  const navigator = useNavigate();
  const [isLogined, setIsLogined] = useRecoilState(LoginState);

  const [username, setUsername] = useState<string>("");

  const myInfo = async () => {
    try {
      const data = await axios.get("http://127.0.0.1:8080/user/myInfo", {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      });
      setUsername(data.data);
      console.log(username);
      setIsLogined(true);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    myInfo();
  }, []);

  return (
    <S.NavBarBackgroundWrap>
      <S.NavBarWrap>
        <S.TitleAndLogoWrap
          onClick={() => {
            navigator("/");
          }}
        >
          <TfiClipboard style={{ fontSize: "1.5rem", color: "white" }} />
          <S.NavItemWrap
            onClick={() => {
              navigator("/");
            }}
          >
            JOARD
          </S.NavItemWrap>
          {isLogined && (
            <S.NavItemWrap style={{ marginLeft: "25px", fontSize: "1.3rem" }}>
              {username} 님
            </S.NavItemWrap>
          )}
        </S.TitleAndLogoWrap>
        <S.ButtonWrap>
          {isLogined ? (
            <>
              <S.RegisterButton
                onClick={() => {
                  setIsLogined((prev) => !prev);
                  localStorage.removeItem("token");
                }}
              >
                로그아웃
              </S.RegisterButton>
            </>
          ) : (
            <>
              <S.RegisterButton
                onClick={() => {
                  // setIsLogined((prev) => !prev);

                  navigator("/login");
                }}
              >
                로그인
              </S.RegisterButton>
              <S.RegisterButton
                onClick={() => {
                  navigator("/signup");
                }}
              >
                회원가입
              </S.RegisterButton>
            </>
          )}
          {isLogined && (
            <S.RegisterButton
              onClick={() => {
                navigator("/write");
              }}
            >
              등록
            </S.RegisterButton>
          )}
        </S.ButtonWrap>
      </S.NavBarWrap>
    </S.NavBarBackgroundWrap>
  );
};

export default Nav;
