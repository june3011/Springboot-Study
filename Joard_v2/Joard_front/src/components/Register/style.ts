import styled from "styled-components";
import { palette } from "../../styles/palette";

export const RegisterWrap = styled.div`
  width: 60%;
  height: 100%;
  box-sizing: border-box;
  padding: 30px 0;
`;

export const TitleInput = styled.input`
  display: flex;
  width: 100%;
  height: 30px;
  font-size: 2rem;
  color: #222222;
  border: none;
  border-bottom: 1px solid #aaaaaa;
  padding: 0 0 5px 10px;
  background: none;
  &:focus {
    outline: none;
  }
`;

export const WritterInput = styled.input`
  display: flex;
  width: 100%;
  height: 30px;
  font-size: 1rem;
  color: #222222;
  border: none;
  border-bottom: 1px solid #aaaaaa;
  padding: 0 0 5px 10px;
  background: none;
  &:focus {
    outline: none;
  }
`;

export const ContentInput = styled.input`
  display: flex;
  width: 100%;
  height: 700px;
  font-size: 1rem;
  color: #222222;
  border: none;
  padding: 0 0 0 10px;
  background: none;
  &:focus {
    outline: none;
  }
`;

export const RegisterButton = styled.input`
  border: none;
  background-color: ${palette.main};
  font-size: 1.2rem;
  padding: 7px 13px;
  border-radius: 50px;
  &:hover {
    cursor: pointer;
  }
`;
