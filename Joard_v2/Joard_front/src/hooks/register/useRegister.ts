import registerRepository from "../../repository/register/register.repository";
import { postBasicInfo, postInfo } from "../../types/postRegister.type";

const useRegister = () => {
  const postRegister = async (postBasicInfo: postInfo) => {
    await registerRepository.postRegister(postBasicInfo);
  };

  return { postRegister };
};
export default useRegister;
