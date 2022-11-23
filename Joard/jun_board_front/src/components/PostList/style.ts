import styled from "styled-components";
import { palette } from "../../styles/palette";

export const PostListWrap = styled.div`
  width: 60%;
  height: 100%;
  padding: 10px 0;
  box-sizing: border-box;
`;

export const Table = styled.div`
  display: flex;
  flex-direction: column;
`;

export const TrHead = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  border-top: 1px solid ${palette.black};
  border-bottom: 1px solid ${palette.black};
  padding: 10px 10px;
  color: ${palette.white};
  background-color: ${palette.main};
`;

export const Th = styled.div`
  display: flex;
  min-width: 100px;
`;

export const Tr = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  padding: 10px 10px;
`;

export const Td = styled.div`
  display: flex;
  min-width: 100px;
  align-items: center;
`;

export const Hr = styled.div`
  width: 100%;
  height: 1px;
  margin: 5px 0;
  background-color: black;
`;
