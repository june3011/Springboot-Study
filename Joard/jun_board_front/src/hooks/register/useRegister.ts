import registerRepository from "../../repository/register/register.repository";
import { postBasicInfo } from "../../types/postRegister.type";

const useRegister = () => {
  const postRegister = async (postBasicInfo: postBasicInfo) => {
    await registerRepository.postRegister(postBasicInfo);
  };

  return { postRegister };
};
export default useRegister;
