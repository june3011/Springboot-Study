import styled from "styled-components";
import { palette } from "../../styles/palette";

export const ViewWrap = styled.div`
  display: flex;
  width: 60%;
  height: 100%;
  flex-direction: column;
  padding: 10px 0;
`;

export const TitleWrap = styled.div`
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: space-between;
  padding-right: 20px;
  box-sizing: border-box;
`;
export const Title = styled.div`
  display: flex;
  font-size: 2rem;
`;

export const ViewCount = styled.div`
  display: flex;
  font-size: 1rem;
`;

export const ContentText = styled.div`
  font-size: 1.5rem;
`;

export const Content = styled.div`
  display: flex;
  width: 100%;
  height: 500px;
  flex-direction: column;
  padding: 20px 0;
  gap: 15px;
`;

export const BottomWrap = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

export const ModifyButtonWrap = styled.div`
  display: flex;
  gap: 10px;
  justify-content: center;
`;

export const ModifyButton = styled.div`
  display: flex;
  width: 30px;
  text-align: center;
  border-radius: 50px;
  padding: 7px 13px;
  color: ${palette.white};
  background-color: ${palette.main};
  &:hover {
    cursor: pointer;
  }
`;

export const TitleInput = styled.input`
  display: flex;
  font-size: 2rem;
`;

export const ContentInput = styled.input`
  display: flex;
`;
