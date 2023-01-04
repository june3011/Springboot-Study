import React from "react";
import { Route, Routes } from "react-router-dom";
import Nav from "./common/Nav/Nav";
import Login from "./Login/Login";
import PostList from "./PostList/PostList";
import Register from "./Register/Register";
import Signup from "./Signup/Signup";
import View from "./View/View";

function App() {
  return (
    <>
      <Routes>
        <Route index element={<PostList />} />
        <Route path="/write" element={<Register />} />
        <Route path="/view/:idx" element={<View />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </>
  );
}

export default App;
