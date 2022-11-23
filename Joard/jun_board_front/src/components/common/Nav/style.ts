import styled from "styled-components";
import { palette } from "../../../styles/palette";

export const NavBarBackgroundWrap = styled.div`
  display: flex;
  top: 0;
  width: 100%;
  height: 80px;
  background-color: ${palette.main};
  justify-content: center;
  box-sizing: border-box;
`;

export const NavBarWrap = styled.div`
  display: flex;
  width: 60%;
  align-items: center;
  justify-content: space-between;
  box-sizing: border-box;
  gap: 30px;
  /* padding-left: 50px; */
`;

export const TitleAndLogoWrap = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  gap: 5px;
  &:hover {
    cursor: pointer;
  }
`;

export const NavItemWrap = styled.span`
  color: ${palette.white};
  font-size: 1.5rem;
`;

export const RegisterButton = styled.div`
  height: 30%;
  padding: 8px 13px;
  color: ${palette.main};
  background-color: ${palette.white};
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 30px;
  &:hover {
    cursor: pointer;
  }
`;
