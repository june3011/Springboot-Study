import styled from "styled-components";
import { palette } from "../../styles/palette";

export const LoginWrap = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 100px;
`;

export const LoginMiddleWrap = styled.div`
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

export const LoginInputBox = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 65px;
  width: 80%;
`;

export const LoginExplainText = styled.div`
  display: flex;
`;

export const LoginInput = styled.input`
  display: flex;
  padding-left: 10px;
  width: 100%;
  height: 40px;
  outline: none;
`;

export const LoginButton = styled.div`
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
