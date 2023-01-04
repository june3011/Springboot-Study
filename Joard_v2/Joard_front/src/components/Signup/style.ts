import styled from "styled-components";
import { palette } from "../../styles/palette";

export const SignupWrap = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 100px;
`;

export const SignupMiddleWrap = styled.div`
  display: flex;
  width: 500px;
  height: 500px;
  border: 1px solid black;
  border-radius: 20px;
  padding: 20px;
  flex-direction: column;
  align-items: center;
  gap: 20px;
  position: relative;
`;

export const SignupInputBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 65px;
  width: 80%;
`;

export const SignupExplainText = styled.div`
  display: flex;
`;

export const SignupInput = styled.input`
  display: flex;
  padding-left: 10px;
  width: 100%;
  height: 40px;
  outline: none;
`;

export const SignupButton = styled.div`
  position: absolute;
  bottom: 50px;
  left: 40%;
  width: 100px;
  height: 40px;
  background-color: ${palette.main};
  border: 1px solid black;
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
`;
