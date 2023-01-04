import { useEffect, useState } from "react";
import postListRepository from "../../repository/postList/postList.repository";
import { post } from "../../types/post.type";

const usePostList = () => {
  const [postList, setPostList] = useState<post[]>([]);

  const getPostList = async () => {
    try {
      const data = await postListRepository.getPostList();
      console.log(data);
      setPostList(data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getPostList();
  }, []);

  return { postList };
};

export default usePostList;
