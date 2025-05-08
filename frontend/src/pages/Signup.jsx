import React, { useState } from "react";
import "../pages/css/Signup.css";
import { Link } from "react-router-dom";
import register_image from "../components/assets/register.jpg";
import authService from "../api/authService";
import userService from "../api/userService";
import { useUser } from '../contexts/UserContext';
import { useNavigate } from 'react-router-dom'

export const Signup = () => {
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const { login } = useUser();
  const navigate = useNavigate();

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try{
        const data = await authService.register(name, email, password);
        const userData = await userService.getUserData();
    
        login(userData)
        navigate("/")
    }catch(error){
        alert(error.message)
    }
  };

  return (
    <div className="login">
      <div className="left1">
        <div className="login-container">
          <form onSubmit={handleSubmit} className="login-form">
            <h2>Register</h2>
            <div className="input-group">
              <label htmlFor="username">Name:</label>
              <input
                type="text"
                id="name"
                value={name}
                onChange={handleNameChange}
                placeholder="Enter your Name"
              />
            </div>
            <div className="input-group">
              <label htmlFor="email">Email:</label>
              <input
                type="text"
                id="email"
                value={email}
                onChange={handleEmailChange}
                placeholder="Enter your Email"
              />
            </div>
            <div className="input-group">
              <label htmlFor="password">Password:</label>
              <input
                type="password"
                id="password"
                value={password}
                onChange={handlePasswordChange}
                placeholder="Enter your password"
              />
            </div>
            <button type="submit" className="login-button">
              SignUp
            </button>
            <div className="signup">
              <Link to="/login">
                <a>Already have an account? Login Here!</a>
              </Link>
            </div>
          </form>
        </div>
      </div>
      <div className="right1">
        <img src={register_image} alt="" />
      </div>
    </div>
  );
};
