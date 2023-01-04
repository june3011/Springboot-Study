import { ReactNode } from "react";
import * as S from "./style";

interface GlobalLayoutProps {
  children: ReactNode;
}

const Wrap = ({ children }: GlobalLayoutProps) => {
  return <S.Wrap>{children}</S.Wrap>;
};

export default Wrap;
