import React from "react";
import { Route, Routes } from "react-router-dom";
import Nav from "./common/Nav/Nav";
import PostList from "./PostList/PostList";
import Register from "./Register/Register";
import View from "./View/View";

function App() {
  return (
    <>
      <Routes>
        <Route index element={<PostList />} />
        <Route path="/write" element={<Register />} />
        <Route path="/view/:idx" element={<View />} />
      </Routes>
    </>
  );
}

export default App;
