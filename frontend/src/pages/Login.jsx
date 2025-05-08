import React, { useState } from 'react';
import '../pages/css/Login.css';
import login_image from '../components/assets/login.jpg'
import authService from '../api/authService'
import userService from '../api/userService'
import { useNavigate } from 'react-router-dom'
import { useUser } from '../contexts/UserContext';


export const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const { login } = useUser();
  const navigate = useNavigate();

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    const data = await authService.login(username, password)
    const userData = await userService.getUserData(); 

    login(userData)
    navigate("/")

  };

  return (
    <div className="login">
      <div className="left1">
      <div className="login-container">
      <form onSubmit={handleSubmit} className="login-form">
        <h2>Login</h2>
        <div className="input-group">
          <label htmlFor="username">Email:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={handleUsernameChange}
            placeholder="Enter your email"
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
        <button type="submit" className="login-button">Login</button>
        <div className="signup">
        <a>Don´t have an account? Register Here!</a>
      </div>
      </form>
    </div>
      </div>
      <div className="right1">
        <img src={login_image} alt="" />
      </div>
    </div>
  );
};

